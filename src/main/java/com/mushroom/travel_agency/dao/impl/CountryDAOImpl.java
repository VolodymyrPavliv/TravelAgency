package com.mushroom.travel_agency.dao.impl;

import com.mushroom.travel_agency.dao.CountryDAO;
import com.mushroom.travel_agency.entity.Country;
import com.mushroom.travel_agency.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO {
    private SessionFactory sessionFactory;

    public CountryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Country> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Country c",Country.class)
                .list();
    }

    @Override
    public Country getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select c from Country c where c.name=:name", Country.class)
                .setParameter("name", name)
                .uniqueResult();
    }

}
