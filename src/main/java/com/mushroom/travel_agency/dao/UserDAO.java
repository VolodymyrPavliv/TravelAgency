package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    Optional<User> getByEmail(String email);
    void save(User user);
    List<User> getAll();
    User getById(Long id);
    void delete(Long id);
}
