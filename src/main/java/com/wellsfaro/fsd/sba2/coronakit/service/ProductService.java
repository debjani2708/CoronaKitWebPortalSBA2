package com.wellsfaro.fsd.sba2.coronakit.service;

import java.util.List;

import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws CoronaKitException;
	public List<ProductMaster> getAllProducts() throws CoronaKitException;
	public boolean deleteProduct(int productId) throws CoronaKitException;
	public ProductMaster getProductById(int productId) throws CoronaKitException;
}
