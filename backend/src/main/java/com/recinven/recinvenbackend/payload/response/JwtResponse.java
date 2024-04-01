package com.recinven.recinvenbackend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private final String tokenType = "Bearer";
    private String accessToken;
    private Long userId;
    //private String email;
}
