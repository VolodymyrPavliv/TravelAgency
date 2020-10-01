package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.OrderDAO;
import com.mushroom.travel_agency.entity.Order;
import com.mushroom.travel_agency.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public List<Order> getAllByUserId(Long userId) {
        return orderDAO.getAllByUserId(userId);
    }
}
