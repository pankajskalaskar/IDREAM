package com.Service;

import org.springframework.util.MultiValueMap;

import com.DTO.RegisterRequest;
import com.DTO.UserResponse;

public interface AuthenticationService {

	UserResponse registerUser(RegisterRequest registerRequest);

}
