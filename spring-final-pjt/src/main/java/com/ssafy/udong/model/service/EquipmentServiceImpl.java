package com.ssafy.udong.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.udong.model.dao.EquipmentDao;
import com.ssafy.udong.model.dao.PlaceDao;
import com.ssafy.udong.model.dto.Equipment;
import com.ssafy.udong.model.dto.Place;
import com.ssafy.udong.model.dto.SearchCondition;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentDao equipmentDao;
	
	@Autowired
	private PlaceDao placeDao;
	
	@Override
	public List<Equipment> searchByHashtag(String hashtag) {
		List<Place> placeList = placeDao.getPlaces();
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		
		if(hashtag.equals("온몸")) {
			
		} else if(hashtag.equals("상체")) {
			
			
		} else if(hashtag.equals("하체")) {
			
			
		} else if(hashtag.equals("지구력")) {
			
			
		} else if(hashtag.equals("웨이트")) {
			
			
		} else if(hashtag.equals("유산소")) {
			
			
		} else if(hashtag.equals("스트레칭")) {
			
			
		} else if(hashtag.equals("유연성")) {
			
			
		} 
		//기타
		else {
			
		}
		return null;
	}



	

}
