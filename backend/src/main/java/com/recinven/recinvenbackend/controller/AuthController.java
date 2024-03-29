package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.UserModelAssembler;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.payload.request.LoginRequest;
import com.recinven.recinvenbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserModelAssembler userModelAssembler;
    private final UserService userService;

    @Autowired
    public AuthController(UserModelAssembler userModelAssembler, UserService userService) {
        this.userModelAssembler = userModelAssembler;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword()));
    }

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody User user) {
        if (userService.existsByEmail(user.getEmail()) && user.getEmail() != null) {
            return ResponseEntity.badRequest().body("There is already an account registered with that email.");
        }

        if (userService.existsByPhone(user.getPhone()) && user.getPhone() != null) {
            return ResponseEntity.badRequest().body("There is already an account registered with that phone number.");
        }

        EntityModel<User> userEntityModel = userModelAssembler.toModel(userService.create(user));
        return ResponseEntity.created(userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(userEntityModel);
    }
}
