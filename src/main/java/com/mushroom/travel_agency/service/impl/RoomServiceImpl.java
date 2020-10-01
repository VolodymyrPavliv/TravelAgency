package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.RoomDAO;
import com.mushroom.travel_agency.entity.Room;
import com.mushroom.travel_agency.service.HotelService;
import com.mushroom.travel_agency.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomDAO roomDAO;
    private final HotelService hotelService;

    public RoomServiceImpl(RoomDAO roomDAO, HotelService hotelService) {
        this.roomDAO = roomDAO;
        this.hotelService = hotelService;
    }

    @Override
    @Transactional
    public List<Room> getAllByHotelId(Long hotelId) {
        return roomDAO.getAllByHotelId(hotelId);
    }

    @Override
    @Transactional
    public Room delete(Long id) {
        Room room = getById(id);
        roomDAO.delete(id);
        return room;
    }

    @Override
    @Transactional
    public void save(Room room) {
        room.setHotel(hotelService.getById(room.getHotelId()));
        roomDAO.save(room);
    }

    @Override
    @Transactional
    public Room getById(Long id) {
        return roomDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Room> getAllByPeriod(Long hotelId, LocalDate checkIn, LocalDate checkOut) {
        List<Room> roomsByPeriod = roomDAO.getAllByPeriod(hotelId, checkIn, checkOut);
        return roomsByPeriod;
    }

    @Override
    @Transactional
    public boolean checkOrders(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        return roomDAO.checkOrders(roomId, checkIn, checkOut);

    }
}
