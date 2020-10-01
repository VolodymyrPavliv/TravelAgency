package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.OrderDAO;
import com.mushroom.travel_agency.entity.Order;
import com.mushroom.travel_agency.service.OrderService;
import com.mushroom.travel_agency.service.RoomService;
import com.mushroom.travel_agency.service.UserService;
import dto.BookingRoom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;
    private final RoomService roomService;
    private final UserService userService;

    public OrderServiceImpl(OrderDAO orderDAO, RoomService roomService, UserService userService) {
        this.orderDAO = orderDAO;
        this.roomService = roomService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public List<Order> getAllByUserId(Long userId) {
        return orderDAO.getAllByUserId(userId);
    }

    @Override
    @Transactional
    public void save(BookingRoom bookingRoom, Long userId) {
        Order order =new Order();
        order.setCheckIn(bookingRoom.getFrom());
        order.setCheckOut(bookingRoom.getUntil());
        order.setRoom(roomService.getById(bookingRoom.getRoomId()));
        order.setUser(userService.getById(userId));
        orderDAO.save(order);
    }
}
