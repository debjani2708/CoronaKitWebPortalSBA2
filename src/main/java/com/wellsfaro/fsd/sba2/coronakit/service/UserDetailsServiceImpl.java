package com.wellsfaro.fsd.sba2.coronakit.service;


import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfaro.fsd.sba2.coronakit.dao.UserRepository;
import com.wellsfaro.fsd.sba2.coronakit.entity.Users;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository appUserRepo;
	
	@Autowired
	private PasswordEncoder penc;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails userDetails;
		Users user=appUserRepo.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("No Such User Found  ");
		}
		
		
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));		
		userDetails = (UserDetails) new User(
				user.getUsername(),
				user.getEncodedPassword(),
				authorities);
		
		
		return userDetails;
	}
	
	public Users save(Users user) {		
		user.setEncodedPassword(penc.encode(user.getPassword()));
		return appUserRepo.save(user);
	}

}
