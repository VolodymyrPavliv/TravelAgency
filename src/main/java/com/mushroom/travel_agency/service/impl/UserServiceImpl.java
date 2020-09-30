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
import java.util.stream.Collectors;

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
        addRole("CUSTOMER", user);
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
    public void changeRole(String roleName, User user) {
        if (hasRole(user, roleName)) {
            detachRole(roleName, user);
        } else {
            addRole(roleName, user);
        }
        save(user);
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
    private boolean hasRole(User user, String roleName) {
        return user.getRoles()
                .stream()
                .anyMatch(role -> role.getName().equals(roleName));
    }

    private void addRole(String roleName, User user) {
        List<Role> roles = user.getRoles();
        Role desiredRole = roleService.getByName(roleName);
        roles.add(desiredRole);
        user.setRoles(roles);
    }


    private void detachRole(String roleName, User user) {
        List<Role> currentRoles = user.getRoles();
        List<Role> filteredRoles = currentRoles
                .stream()
                .filter(role -> !role.getName().equals(roleName))
                .collect(Collectors.toList());
        user.setRoles(filteredRoles);
    }
}
