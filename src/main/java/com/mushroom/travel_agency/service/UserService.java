package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.User;

public interface UserService {
    void save(User user);
    User getByEmail(String email);
}
