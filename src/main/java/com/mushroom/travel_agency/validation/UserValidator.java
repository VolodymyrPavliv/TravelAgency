package com.mushroom.travel_agency.validation;

import com.mushroom.travel_agency.entity.User;
import com.mushroom.travel_agency.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if(user.getPassword().length()<6) {
            errors.rejectValue("password","error.password");
        }

        if(userService.getByEmail(user.getEmail())!=null) {
            errors.rejectValue("email","error.email.already_exist");
        }

        if(user.getName().length()==0) {
            errors.rejectValue("name","error.username");
        }

        if(user.getEmail().length()==0) {
            errors.rejectValue("email","error.email.null");
        }
    }
}
