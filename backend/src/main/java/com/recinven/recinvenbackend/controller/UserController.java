package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.UserModelAssembler;
import com.recinven.recinvenbackend.dto.UserDto;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.mapper.UserMapper;
import com.recinven.recinvenbackend.repository.UserRepository;
import com.recinven.recinvenbackend.exceptions.exception.UserNotFoundException;
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
    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserModelAssembler assembler;

    UserController(UserRepository repository, UserMapper mapper, UserModelAssembler assembler) {
        this.repository = repository;
        this.mapper = mapper;
        this.assembler = assembler;
    }

    // tag::get-aggregate-root[]
    @GetMapping
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = repository.findAll().stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping
    ResponseEntity<?> newUser(@RequestBody User user) {
        EntityModel<User> userEntityModel = assembler.toModel(repository.save(user));
        return ResponseEntity.created(userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(userEntityModel);
    }

    @GetMapping(path = "/{userId}")
    public EntityModel<User> one(@PathVariable Long userId) {
        User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        return assembler.toModel(user);
    }

    @PutMapping(path = "/{userId}")
    ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserDto dto) {
        User updatedUser = repository.findById(userId)
                .map(user -> {
                    mapper.updateCustomerFromDto(dto, user);
                    return repository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(userId));

        EntityModel<User> userEntityModel = assembler.toModel(updatedUser);
        return ResponseEntity.created(userEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(userEntityModel);
    }

    @DeleteMapping(path = "/{userId}")
    ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        repository.deleteById(userId);

        return ResponseEntity.noContent().build();
    }
}
