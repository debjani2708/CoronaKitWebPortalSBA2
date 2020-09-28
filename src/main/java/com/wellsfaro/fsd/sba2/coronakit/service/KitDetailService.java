package com.wellsfaro.fsd.sba2.coronakit.service;

import java.util.List;

import com.wellsfaro.fsd.sba2.coronakit.entity.KitDetail;
import com.wellsfaro.fsd.sba2.coronakit.exception.CoronaKitException;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem) throws CoronaKitException;
	public KitDetail getKitItemById(int itemId) throws CoronaKitException;
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) throws CoronaKitException;
}
