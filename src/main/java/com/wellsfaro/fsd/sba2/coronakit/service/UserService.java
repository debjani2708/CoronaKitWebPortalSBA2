package com.wellsfaro.fsd.sba2.coronakit.service;


import com.wellsfaro.fsd.sba2.coronakit.entity.Users;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

public interface UserService {

	public Users getUserDetails(String username) throws CoronaKitException;
}
