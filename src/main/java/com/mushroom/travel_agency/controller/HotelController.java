package com.mushroom.travel_agency.controller;

import com.mushroom.travel_agency.entity.Hotel;
import com.mushroom.travel_agency.service.CountryService;
import com.mushroom.travel_agency.service.HotelService;
import com.mushroom.travel_agency.validation.HotelValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/hotels")
@PropertySource({"classpath:path.properties"})
public class HotelController {
    private final CountryService countryService;
    private final HotelService hotelService;
    private final HotelValidator hotelValidator;
    private final Environment environment;
    @Value("${upload.path}")
    private String upload;

    public HotelController(CountryService countryService, HotelService hotelService, HotelValidator hotelValidator, Environment environment) {
        this.countryService = countryService;
        this.hotelService = hotelService;
        this.hotelValidator = hotelValidator;
        this.environment = environment;
    }

    @GetMapping
    public String hotels(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("hotels", hotelService.getAll());

        return "hotels";
    }

    @GetMapping("/edit/{id}")
    public String editHotelById(@PathVariable Long id, Model model) {
        model.addAttribute("hotel", hotelService.getById(id));
        model.addAttribute("countries", countryService.getAll());
        return "edit_hotel";
    }

    @PostMapping("/edit")
    public String editHotel(@ModelAttribute("hotel") Hotel hotel, Errors errors,
                            @RequestParam("file") MultipartFile file, Model model) throws IOException {
        hotelValidator.validate(hotel, errors);
        if (errors.hasErrors()) {
            return "edit_hotel";
        }

        if(file.getSize()>150000) {
            model.addAttribute("fileError", environment.getProperty("error.file"));
            return "edit_hotel";
        }
        file.transferTo(new File(upload
                +file.getOriginalFilename()));

        hotel.setFilename(file.getOriginalFilename());
        hotelService.save(hotel);
        return "redirect:/hotels";
    }


    @PostMapping("/add")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel, Errors errors,
                           @RequestParam("file") MultipartFile file, Model model) throws IOException {
        hotelValidator.validate(hotel, errors);
        if (errors.hasErrors()) {
            return "hotels";
        }
        if (file.getSize() > 150000) {
            model.addAttribute("fileError", environment.getProperty("error.file.too_large_size"));
            return "hotels";
        }
        file.transferTo(new File(upload
                + file.getOriginalFilename()));

        hotel.setFilename(file.getOriginalFilename());
        hotelService.save(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);
        return "redirect:/hotels";
    }

}
