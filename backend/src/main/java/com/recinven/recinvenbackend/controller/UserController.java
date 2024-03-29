package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.UserModelAssembler;
import com.recinven.recinvenbackend.dto.UserDto;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserModelAssembler userModelAssembler;
    private final UserService userService;

    @Autowired
    UserController(UserModelAssembler userModelAssembler, UserService userService) {
        this.userModelAssembler = userModelAssembler;
        this.userService = userService;
    }

    // tag::get-aggregate-root[]
    @GetMapping
    public ResponseEntity<?> all() {
        List<EntityModel<User>> users = userService.findAll().stream()
                .map(userModelAssembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel()));
    }
    // end::get-aggregate-root[]

    @GetMapping("/{userId}")
    public ResponseEntity<?> one(@PathVariable Long userId) {
        User user = userService.findById(userId);

        return ResponseEntity.ok(userModelAssembler.toModel(user));
    }

    @PutMapping("/{userId}")
    ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserDto dto) {
        User updatedUser = userService.updateById(userId, dto);

        EntityModel<User> userEntityModel = userModelAssembler.toModel(updatedUser);
        return ResponseEntity.created(userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(userEntityModel);
    }

    @DeleteMapping( "/{userId}")
    ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }
}
