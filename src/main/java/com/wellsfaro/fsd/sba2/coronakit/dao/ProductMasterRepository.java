package com.wellsfaro.fsd.sba2.coronakit.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer>{
	
	boolean existsByProductName(String productName);
	
}
