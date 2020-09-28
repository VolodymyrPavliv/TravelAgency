package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.HotelDAO;
import com.mushroom.travel_agency.entity.Hotel;
import com.mushroom.travel_agency.service.HotelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;

    public HotelServiceImpl(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    @Transactional
    public List<Hotel> getAll() {
        return hotelDAO.getAll();
    }

    @Override
    @Transactional
    public List<Hotel> getAllByCountryName(String countryName) {
        if(countryName==null)
            return getAll();
        return hotelDAO.getAllByCountryName(countryName);
    }
}
