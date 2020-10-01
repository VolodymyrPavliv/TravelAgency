package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    List<Room> getAllByHotelId(Long hotelId);
    Room delete(Long id);
    void save(Room room);
    Room getById(Long id);
    List<Room> getAllByPeriod(Long hotelId, LocalDate checkIn, LocalDate checkOut);
    boolean checkOrders(Long roomId, LocalDate checkIn, LocalDate checkOut);
}
