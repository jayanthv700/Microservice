package com.feignuser.service;

import com.feignuser.dto.UserRequest;
import com.feignuser.model.UserEntity;

public interface UserService
{
	public UserEntity createUser(UserRequest request);

	public UserEntity getUserById(Long id);
}
