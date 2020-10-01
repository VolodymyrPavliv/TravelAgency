package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllByUserId (Long userId);
    void save(Order order);
}
