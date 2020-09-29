package com.mushroom.travel_agency.validation;
import com.mushroom.travel_agency.entity.Hotel;
import com.mushroom.travel_agency.service.CountryService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class HotelValidator implements Validator {
    private final CountryService countryService;

    public HotelValidator(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Hotel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Hotel hotel = (Hotel) o;
        String hotelCountry = hotel.getCountry().trim();
        String hotelName = hotel.getName().trim();
        if (hotelName.length() < 6) {
            errors.rejectValue("name", "error.hotel_name");
        }
        if (countryService.getByName(hotelCountry)==null) {
            errors.rejectValue("country", "error.hotel_country");
        }
    }
}
