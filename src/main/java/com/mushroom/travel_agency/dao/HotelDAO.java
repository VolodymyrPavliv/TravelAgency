package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.Hotel;

import java.util.List;

public interface HotelDAO {
    List<Hotel> getAll();
    List<Hotel> getAllByCountryName(String countryName);
}
