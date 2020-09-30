package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User getByEmail(String email);
    List<User> getAll();
    User getById(Long id);
    void changeRole(String roleName, User user);
    void delete(Long id);
}
