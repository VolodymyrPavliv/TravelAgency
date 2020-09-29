package com.mushroom.travel_agency.security;

import com.mushroom.travel_agency.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsFactory {
    UserDetails create(User user);
}
