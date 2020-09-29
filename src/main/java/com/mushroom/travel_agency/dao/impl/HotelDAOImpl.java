package com.mushroom.travel_agency.dao.impl;

import com.mushroom.travel_agency.dao.HotelDAO;
import com.mushroom.travel_agency.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDAOImpl implements HotelDAO {
    private SessionFactory sessionFactory;

    public HotelDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Hotel> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select h from Hotel h",Hotel.class)
                .list();
    }

    @Override
    public List<Hotel> getAllByCountryName(String countryName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select h from Hotel h where h.country = :countryName", Hotel.class)
                .setParameter("countryName", countryName)
                .list();
    }

    @Override
    public void save(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(hotel);
    }

    @Override
    public Hotel getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select h from Hotel h where h.id = : id",Hotel.class)
                .setParameter("id",id)
                .uniqueResult();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Hotel h where h.id=:id")
        .setParameter("id",id)
        .executeUpdate();
    }
}
