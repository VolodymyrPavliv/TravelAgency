package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.UserDAO;
import com.mushroom.travel_agency.entity.Role;
import com.mushroom.travel_agency.entity.User;
import com.mushroom.travel_agency.service.RoleService;
import com.mushroom.travel_agency.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void save(User user) {
        encodeUsersPassword(user);
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleService.getByName("CUSTOMER"));
        userDAO.save(user);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public User getByEmail(String email) {
        return userDAO.getByEmail(email).orElse(null);
    }

    @Override
    @Transactional
    public void changeRole(User user) {
        if(user.getRoles().stream().anyMatch(r-> r.getName().equals("MANAGER"))) {
            user.getRoles().clear();
            user.getRoles().add(roleService.getByName("CUSTOMER"));
        }else {
            user.getRoles().clear();
            user.getRoles().add(roleService.getByName("MANAGER"));
        }
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }

    private void encodeUsersPassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
