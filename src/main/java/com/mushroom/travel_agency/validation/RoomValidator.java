package com.mushroom.travel_agency.validation;

import com.mushroom.travel_agency.entity.Room;
import com.mushroom.travel_agency.service.RoomService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class RoomValidator implements Validator {
    private final RoomService roomService;

    public RoomValidator(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Room.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Room room = (Room) o;
        if (alreadyExists(room.getRoomNumber(), room.getHotelId())) {
            errors.rejectValue("roomNumber", "error.room.room_number");
        }
        if (room.getType().length()<6) {
            errors.rejectValue("type", "error.room.type");
        }
        if (room.getPrice()==0.0) {
            errors.rejectValue("price", "error.room.price");
        }
    }

    private boolean alreadyExists(Long roomNumber, Long hotelId) {
        List<Room> roomsByGivenHotel = roomService.getAllByHotelId(hotelId);
        return roomsByGivenHotel
                .stream()
                .anyMatch(room -> room.getRoomNumber().equals(roomNumber));
    }

}

