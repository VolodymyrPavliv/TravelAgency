package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.Country;

import java.util.List;

public interface CountryDAO {
    List<Country> getAll();
    Country getByName(String name);
}
