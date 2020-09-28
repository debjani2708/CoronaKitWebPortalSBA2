package com.wellsfargo.fsd.sba2.coronakit.test.utils;

import com.wellsfaro.fsd.sba2.coronakit.entity.ProductMaster;

public class MasterData {

	public static ProductMaster getProduct() {
		ProductMaster product = new ProductMaster(1, "First", 200,"First Product");
		return product;
	}
}
