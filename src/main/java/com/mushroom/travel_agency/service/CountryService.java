package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAll();
    Country getByName(String name);
}
