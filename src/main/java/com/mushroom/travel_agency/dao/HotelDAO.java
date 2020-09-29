package com.mushroom.travel_agency.dao;

import com.mushroom.travel_agency.entity.Hotel;

import java.util.List;

public interface HotelDAO {
    List<Hotel> getAll();
    List<Hotel> getAllByCountryName(String countryName);
    void save(Hotel hotel);
    Hotel getById(Long id);
    void delete(Long id);
}
