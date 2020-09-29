package com.mushroom.travel_agency.service;

import com.mushroom.travel_agency.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();
    List<Hotel> getAllByCountryName(String countryName);
    void save(Hotel hotel);
    Hotel getById(Long id);
    void delete(Long id);
}
