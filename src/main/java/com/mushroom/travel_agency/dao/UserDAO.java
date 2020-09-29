package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> getByEmail(String email);
    void save(User user);
}
