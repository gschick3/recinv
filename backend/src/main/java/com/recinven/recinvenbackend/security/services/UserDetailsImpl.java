package com.recinven.recinvenbackend.security.services;

import com.recinven.recinvenbackend.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private final Long id;

    private final String username;

    @Getter
    private final String password;

    public UserDetailsImpl(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getUserId(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // This method is required, but we aren't implementing user roles
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
