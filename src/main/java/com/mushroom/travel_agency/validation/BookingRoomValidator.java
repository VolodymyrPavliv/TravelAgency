package com.mushroom.travel_agency.validation;

import com.mushroom.travel_agency.service.RoomService;
import dto.BookingRoom;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class BookingRoomValidator implements Validator {
    private final RoomService roomService;

    public BookingRoomValidator(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BookingRoom.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        BookingRoom bookRoomRequest = (BookingRoom) o;
        Long roomId = bookRoomRequest.getRoomId();
        LocalDate from = bookRoomRequest.getFrom();
        LocalDate until = bookRoomRequest.getUntil();
        if (roomService.checkOrders(roomId, from, until)) {
            errors.rejectValue("roomId", "error.room.busy");
        }
    }

}
