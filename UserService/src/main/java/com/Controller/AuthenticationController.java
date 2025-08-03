package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.RegisterRequest;
import com.DTO.UserResponse;
import com.Service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v1/auth")
@Tag(name = "Authentication APIS", description = "All API related to authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService as;

	@Operation(summary = "Register a new user", description = "Registered sucessfully")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "User registered sucessfully") })
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody RegisterRequest registerRequest) {

		log.debug("Register Request: " + registerRequest);

		return ResponseEntity(as.registerUser(registerRequest), HttpStatus.OK);

	}

	private ResponseEntity<?> ResponseEntity(UserResponse registerUser, HttpStatus ok) {
		// TODO Auto-generated method stub
		return null;
	}

}
