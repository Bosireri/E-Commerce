package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.api.model.RegistrationBody;
import com.ecommerce.ECommerce.model.LocalUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public LocalUser registerUser(RegistrationBody registrationBody) {
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        //TODO: Encrypt passwords!!
        user.setPassword(registrationBody.getPassword());

    }
}
