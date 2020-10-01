package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> getAllByHotelId(Long hotelId);
    void delete(Long id);
    void save(Room room);
    Room getById(Long id);
}
