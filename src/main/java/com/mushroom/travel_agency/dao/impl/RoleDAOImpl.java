package com.mushroom.travel_agency.dao.impl;

import com.mushroom.travel_agency.dao.RoleDAO;
import com.mushroom.travel_agency.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private final SessionFactory sessionFactory;

    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from Role r where r.name=:name",Role.class)
                .setParameter("name",name)
                .uniqueResult();
    }
}
