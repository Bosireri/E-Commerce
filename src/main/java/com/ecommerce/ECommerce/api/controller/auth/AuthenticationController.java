package com.ecommerce.ECommerce.api.controller.auth;

import com.ecommerce.ECommerce.api.model.RegistrationBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationBody registrationBody){
    }
}
