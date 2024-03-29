package com.recinven.recinvenbackend.security;

import com.recinven.recinvenbackend.security.services.UserDetailsImpl;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Supplier;

@Component
public class UserSecurity implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authenticationSupplier, RequestAuthorizationContext ctx) {
        Long userId = Long.parseLong(ctx.getVariables().get("userId"));
        Authentication authentication = authenticationSupplier.get();
        return new AuthorizationDecision(hasUserId(authentication, userId));
    }

    public boolean hasUserId(Authentication authentication, Long userId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Objects.equals(userDetails.getId(), userId);
    }
}
