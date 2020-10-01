package com.mushroom.travel_agency.dao.impl;

import com.mushroom.travel_agency.dao.OrderDAO;
import com.mushroom.travel_agency.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    private final SessionFactory sessionFactory;

    public OrderDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> getAllByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select o from Order o where o.user.id = :userId",Order.class)
                .setParameter("userId",userId)
                .list();
    }
}
