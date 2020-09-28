package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();
    List<Hotel> getAllByCountryName(String countryName);
}
