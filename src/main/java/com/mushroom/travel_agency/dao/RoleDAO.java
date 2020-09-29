package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.Role;

public interface RoleDAO {
    Role getByName(String name);
}
