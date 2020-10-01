package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.Order;
import dto.BookingRoom;

import java.util.List;

public interface OrderService {
    List<Order> getAllByUserId(Long userId);
    void save(BookingRoom bookingRoom, Long userId);
}
