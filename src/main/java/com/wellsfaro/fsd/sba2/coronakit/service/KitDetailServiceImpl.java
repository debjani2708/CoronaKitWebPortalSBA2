package com.wellsfaro.fsd.sba2.coronakit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfaro.fsd.sba2.coronakit.dao.KitDetailRepository;
import com.wellsfaro.fsd.sba2.coronakit.entity.KitDetail;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	public KitDetail addKitItem(KitDetail kitItem) throws CoronaKitException {
		if (kitItem!=null)			
		{
			repository.save(kitItem);
		}
		return kitItem;
	}

	@Override
	public KitDetail getKitItemById(int itemId) throws CoronaKitException {
		return repository.findById(itemId).orElse(null);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) throws CoronaKitException {
		return repository.findAllCoronaKitId(kitId);		
	}

}
