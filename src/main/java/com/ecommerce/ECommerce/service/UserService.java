package com.ecommerce.ECommerce.service;

import com.ecommerce.ECommerce.api.model.RegistrationBody;
import com.ecommerce.ECommerce.exception.UserAlreadyExistsException;
import com.ecommerce.ECommerce.model.LocalUser;
import com.ecommerce.ECommerce.model.dao.LocalUserDAO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;
//constructor
    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        //TODO: Encrypt passwords!!
        user.setPassword(registrationBody.getPassword());
        user=localUserDAO.save(user);
        return localUserDAO.save(user);
    }
}
