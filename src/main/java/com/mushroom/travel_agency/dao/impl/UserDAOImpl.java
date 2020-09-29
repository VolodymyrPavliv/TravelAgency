package com.mushroom.travel_agency.dao.impl;

import com.mushroom.travel_agency.dao.UserDAO;
import com.mushroom.travel_agency.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", email)
                .uniqueResultOptional();

    }
}
