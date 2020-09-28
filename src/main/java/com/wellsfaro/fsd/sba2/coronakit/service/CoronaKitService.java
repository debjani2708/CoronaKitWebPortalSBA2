package com.wellsfaro.fsd.sba2.coronakit.service;

import com.wellsfaro.fsd.sba2.coronakit.entity.CoronaKit;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

public interface CoronaKitService {
	
	public CoronaKit saveKit(CoronaKit kit) throws CoronaKitException;
	public CoronaKit getKitById(int kitId) throws CoronaKitException;
}
