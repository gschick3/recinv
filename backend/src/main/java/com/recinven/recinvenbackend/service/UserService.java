package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.UserDto;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.exceptions.exception.UserNotFoundException;
import com.recinven.recinvenbackend.mapper.UserMapper;
import com.recinven.recinvenbackend.payload.response.JwtResponse;
import com.recinven.recinvenbackend.repository.UserRepository;
import com.recinven.recinvenbackend.security.jwt.JwtUtils;
import com.recinven.recinvenbackend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper mapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Transactional
    public User updateById(Long userId, UserDto dto) {
        if (dto.password != null) {
            dto.password  = passwordEncoder.encode(dto.password);
        }
        return userRepository.findById(userId)
                .map(user -> {
                    mapper.updateCustomerFromDto(dto, user);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public JwtResponse authenticate(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return new JwtResponse(jwt, userDetails.getId());
                //userDetails.getUsername());
    }

    @Transactional
    public User create(User user) {
        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
