package com.mushroom.travel_agency.controller;

import com.mushroom.travel_agency.service.CountryService;
import com.mushroom.travel_agency.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    private final HotelService hotelService;
    private final CountryService countryService;

    public HomeController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping
    public String hotels(@RequestParam(value = "country", required = false) String country, Model model) {
        model.addAttribute("hotels", hotelService.getAllByCountryName(country));
        model.addAttribute("countries", countryService.getAll());
        return "home";
    }
}
