package com.mushroom.travel_agency.controller;
import com.mushroom.travel_agency.entity.Room;
import com.mushroom.travel_agency.security.CustomerDetails;
import com.mushroom.travel_agency.service.OrderService;
import com.mushroom.travel_agency.service.RoomService;
import com.mushroom.travel_agency.validation.BookingRoomValidator;
import dto.BookingRoom;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    private final RoomService roomService;
    private final OrderService orderService;
    private final BookingRoomValidator bookingRoomValidator;
    private final Environment environment;

    public BookingController(RoomService roomService, OrderService orderService, BookingRoomValidator bookingRoomValidator, Environment environment) {
        this.roomService = roomService;
        this.orderService = orderService;
        this.bookingRoomValidator = bookingRoomValidator;
        this.environment = environment;
    }

    @GetMapping("/{hotelId}")
    public String bookingForm( Model model,
                            @PathVariable Long hotelId,
                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate until) {
        List<Room> availableRooms = roomService.getAllByPeriod(hotelId, from, until);
        if (availableRooms.isEmpty()) {
            model.addAttribute("message", environment.getRequiredProperty("error.rooms.empty"));
            return "period";
        }
        if (from == null || until == null) {
            return "period";
        }
        if (from.isAfter(until)) {
            model.addAttribute("message", environment.getRequiredProperty("error.room.date"));
            return "period";
        }

        model.addAttribute("bookingRoom", new BookingRoom(from, until, null));
        model.addAttribute("availableRooms", availableRooms);
        return "booking";
    }

    @PostMapping("/{roomId}")
    public String bookingRoom(Model model,
                       @ModelAttribute("bookingRoom") BookingRoom bookingRoom,
                       Errors errors, @PathVariable("roomId") Long roomId) {
        bookingRoom.setRoomId(roomId);
        bookingRoomValidator.validate(bookingRoom, errors);
        if (errors.hasErrors()) {
            model.addAttribute("message", environment.getRequiredProperty("error.room.not_available"));
            return "period";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        orderService.save(bookingRoom, customerDetails.getUserId());
        return "redirect:/";
    }

}
