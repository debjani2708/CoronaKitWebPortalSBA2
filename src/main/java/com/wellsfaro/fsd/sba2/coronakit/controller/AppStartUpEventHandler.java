package com.wellsfaro.fsd.sba2.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfaro.fsd.sba2.coronakit.dao.UserRepository;
import com.wellsfaro.fsd.sba2.coronakit.entity.Users;



@Component
public class AppStartUpEventHandler {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired	
	private PasswordEncoder penc;
	
	
	@EventListener
	public void onAppStartup(ApplicationReadyEvent event) {
		if(!userRepo.existsByUsername("admin")) {
			userRepo.save(new Users("admin", "admin",penc.encode("admin"),true,"admin@gmail.com","1234567890" , "ADMIN"));
		}
		
		if(!userRepo.existsByUsername("usera")) {
			userRepo.save(new Users("usera", "1234",penc.encode("1234"),true,"First@gmail.com","1234567890" , "USER"));
		}
		if(!userRepo.existsByUsername("userb")) {
			userRepo.save(new Users("userb", "1234",penc.encode("1234"),true,"Second@gmail.com","1234567890" , "USER"));
		}
	}
}