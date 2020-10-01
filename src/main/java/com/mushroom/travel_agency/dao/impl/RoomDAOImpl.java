package com.mushroom.travel_agency.dao.impl;

import com.mushroom.travel_agency.dao.RoomDAO;
import com.mushroom.travel_agency.entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {
    private final SessionFactory sessionFactory;

    public RoomDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Room> getAllByHotelId(Long hotelId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from Room r where r.hotelId = :hotelId", Room.class)
                .setParameter("hotelId", hotelId)
                .list();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Room r where r.id = : id")
        .setParameter("id",id)
        .executeUpdate();
    }

    @Override
    public void save(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(room);
    }

    @Override
    public Room getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from Room r where r.id=:id",Room.class)
                .setParameter("id",id)
                .uniqueResult();
    }
}
