package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllByHotelId(Long hotelId);
    Room delete(Long id);
    void save(Room room);
    Room getById(Long id);
}
