package com.mushroom.travel_agency.controller;

import com.mushroom.travel_agency.entity.Room;
import com.mushroom.travel_agency.service.RoomService;
import com.mushroom.travel_agency.validation.RoomValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final RoomValidator validator;

    public RoomController(RoomService roomService, RoomValidator validator) {
        this.roomService = roomService;
        this.validator = validator;
    }

    @GetMapping("/{hotelId}")
    public String findRoomsByHotelId(@PathVariable Long hotelId, Model model) {
        Room room = new Room();
        room.setHotelId(hotelId);
        model.addAttribute("rooms", roomService.getAllByHotelId(hotelId));
        model.addAttribute("newRoom", room);
        return "rooms";
    }

    @GetMapping("/delete/{roomId}")
    public String delete(@PathVariable Long roomId) {
        Room deletedRoom = roomService.delete(roomId);
        return "redirect:/rooms/" + deletedRoom.getHotelId();
    }

    @PostMapping
    public String addRoom(@ModelAttribute("newRoom") Room room, Errors errors) {
        validator.validate(room,errors);
        if(errors.hasErrors()){
            return "rooms";
        }
        roomService.save(room);
        return "redirect:/rooms/" + room.getHotelId();
    }
}

