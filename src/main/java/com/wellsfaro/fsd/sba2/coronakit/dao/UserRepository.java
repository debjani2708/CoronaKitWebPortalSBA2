package com.wellsfaro.fsd.sba2.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfaro.fsd.sba2.coronakit.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, String>{
	boolean existsByUsername(String username); 
	Users findByUsername(String username); 
}
