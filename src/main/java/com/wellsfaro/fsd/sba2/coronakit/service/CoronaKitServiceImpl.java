package com.wellsfaro.fsd.sba2.coronakit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfaro.fsd.sba2.coronakit.dao.CoronaKitRepository;
import com.wellsfaro.fsd.sba2.coronakit.entity.CoronaKit;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitRepository repository;
	
	@Override
	public CoronaKit saveKit(CoronaKit kit) throws CoronaKitException{
		if (kit!=null)
		{
			repository.save(kit);
		}
		return kit;
	}

	@Override
	public CoronaKit getKitById(int kitId) throws CoronaKitException{
		return repository.findById(kitId).orElse(null);
	}

}
