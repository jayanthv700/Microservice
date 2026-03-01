package com.feignuser.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feignuser.dto.UserRequest;
import com.feignuser.model.UserEntity;
import com.feignuser.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService
{
	@Autowired
	UserRepository repository;

	@Override
	public UserEntity createUser(UserRequest request)
	{
		log.info("Inside createUser method");
		UserEntity entity = new UserEntity();
		entity.setName(request.getName());
		entity.setEmail(request.getEmail());

		return repository.save(entity);
	}

	@Override
	public UserEntity getUserById(Long id)
	{
		log.info("Inside getUserById method");
		Optional<UserEntity> response = repository.findById(id);
		if (response.isEmpty())
		{
			log.info("There is run time exception in response", new RuntimeException("not data found"));
		}

		UserEntity resultResponse = response.get();
		return resultResponse;
	}

}
