package com.wellsfaro.fsd.sba2.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfaro.fsd.sba2.coronakit.dao.ProductMasterRepository;
import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;
	
	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws CoronaKitException {
		if (product!=null) {	
			if(repository.existsByProductName(product.getProductName())) {
				throw new CoronaKitException("Product already exists");
			}
			repository.save(product);
		}
		return product;
	}

	@Override
	public List<ProductMaster> getAllProducts() throws CoronaKitException {
		return repository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteProduct(int productId) throws CoronaKitException {
		System.out.println(repository.existsById(productId));
		if(!repository.existsById(productId)) {
			
			throw new CoronaKitException("Product id doesn't exists");
		}
		repository.deleteById(productId);
		
		return true;
	}

	@Override
	public ProductMaster getProductById(int productId) throws CoronaKitException {
		return repository.findById(productId).orElse(null);
	}

}
