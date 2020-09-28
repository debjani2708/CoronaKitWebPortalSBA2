package com.wellsfaro.fsd.sba2.coronakit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfaro.fsd.sba2.coronakit.dao.UserRepository;
import com.wellsfaro.fsd.sba2.coronakit.entity.Users;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public Users getUserDetails(String username) throws CoronaKitException{
		return repo.findByUsername(username);
	}

}
