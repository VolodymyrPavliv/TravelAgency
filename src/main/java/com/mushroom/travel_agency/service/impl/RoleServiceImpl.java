package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.RoleDAO;
import com.mushroom.travel_agency.entity.Role;
import com.mushroom.travel_agency.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public Role getByName(String name) {
        return roleDAO.getByName(name);
    }

}
