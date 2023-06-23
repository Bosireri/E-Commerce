package com.ecommerce.ECommerce.api.controller.auth;

import com.ecommerce.ECommerce.api.model.LoginBody;
import com.ecommerce.ECommerce.api.model.LoginResponse;
import com.ecommerce.ECommerce.api.model.RegistrationBody;
import com.ecommerce.ECommerce.exception.UserAlreadyExistsException;
import com.ecommerce.ECommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;
//constructor
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.loginUser(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
          LoginResponse response = new LoginResponse();
          response.setJwt(jwt);
          return ResponseEntity.ok(response);
        }
    }
}
