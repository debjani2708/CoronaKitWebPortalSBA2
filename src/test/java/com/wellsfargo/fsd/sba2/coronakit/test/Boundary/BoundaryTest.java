package com.wellsfargo.fsd.sba2.coronakit.test.Boundary;

import static com.wellsfargo.fsd.sba2.coronakit.test.utils.TestUtils.*;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.wellsfargo.fsd.sba2.coronakit.test.utils.MasterData;
import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;

public class BoundaryTest {
	 private Validator validator;
	 
	 @Before
    public void setUp() throws IOException
    {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	 
	@Test
    public void testProductNameBoundary() throws IOException
    {
    	ProductMaster product = MasterData.getProduct();
    	product.setProductName(null);
        Set<ConstraintViolation<ProductMaster>> violations = validator.validate(product);
        
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);

        
    } 
	
	@Test
    public void testProductDescriptionBoundary() throws IOException
    {
    	ProductMaster product = MasterData.getProduct();
    	product.setProductDescription(null);
        Set<ConstraintViolation<ProductMaster>> violations = validator.validate(product);
        
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
       
    } 
	
	@Test
    public void testProductCostBoundary() throws IOException
    {
    	ProductMaster product = MasterData.getProduct();
    	product.setCost(0.0);
        Set<ConstraintViolation<ProductMaster>> violations = validator.validate(product);
        
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
       
    } 
}
