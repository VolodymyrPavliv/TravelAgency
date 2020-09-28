package com.mushroom.travel_agency.service.impl;

import com.mushroom.travel_agency.dao.CountryDAO;
import com.mushroom.travel_agency.entity.Country;
import com.mushroom.travel_agency.service.CountryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryDAO countryDAO;

    public CountryServiceImpl(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    @Transactional
    public List<Country> getAll() {
        return countryDAO.getAll();
    }
}
