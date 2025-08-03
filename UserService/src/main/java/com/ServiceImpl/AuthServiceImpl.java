package com.ServiceImpl;

import java.util.function.Supplier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.DTO.RegisterRequest;
import com.DTO.UserResponse;
import com.Entity.User;
import com.Enums.UserStatusEnum;
import com.Enums.kycStatusEnum;
import com.Exceptions.ResourceFoundException;
import com.Repository.UserRepo;
import com.Service.AuthenticationService;

public class AuthServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepo ur;

	@Override
	public UserResponse registerUser(RegisterRequest registerRequest) {

		User user = ur.findByEmail(registerRequest.getEmail())
				.orElseThrow(() -> new ResourceFoundException("User Already Exist"));

		user.setKycStatus(kycStatusEnum.PENDING);
		user.setStatus(UserStatusEnum.ACTIVE);
		User u = ur.save(user);

		UserResponse ur = new UserResponse();

		ur.setEmail(user.getEmail());
		ur.setFirstname(user.getFirstName());
		ur.setMiddlename(user.getMiddleName());
		ur.setLastname(user.getLastName());
		ur.setMobilenumber(user.getMiddleName());
		ur.setPassword(user.getPassword());
		ur.setUsername(user.getUsername());
		
		ModelMapper model = new ModelMapper();
		
		UserResponse UserResponse = model.map(u, UserResponse.class);

		System.out.println(user);

		return ur;
	}

}
