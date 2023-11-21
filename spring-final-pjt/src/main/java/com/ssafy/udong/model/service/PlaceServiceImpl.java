package com.ssafy.udong.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.udong.model.dao.PlaceDao;
import com.ssafy.udong.model.dto.Place;
import com.ssafy.udong.model.dto.SearchCondition;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceDao placeDao;

	@Transactional
	@Override
	public void insertPlace(Place place) {
		
		//전체 주소를 구, 동, 상세주소로 나눠서 저장
		//구
		place.setAddressGu(place.getAddress().split(" ")[1]);
		//동
		place.setAddressDong(place.getAddress().split(" ")[2]);
		//상세 주소
		if(place.getAddress().split(" ").length > 3) {
			String str = "";
			int index = 3;
			while(index < place.getAddress().split(" ").length) {
				str += place.getAddress().split(" ")[index]+ " ";
				index++;
			}
			place.setAddressDetail(str);
		}
		
		
		placeDao.insertPlace(place);	
	}

	//장소 전체 목록 조회
	@Override
	public List<Place> getPlaces() {
		return placeDao.getPlaces();
	}

	//상세 장소 조회
	@Override
	public Place getPlace(int placeId) {
		return placeDao.getPlaceById(placeId);
	}

	//검색 기능
	@Override
	public List<Place> search(SearchCondition condition) {
		return placeDao.search(condition);
	}

	//현재 위치에서 가장 가까운 4곳 조회
	@Override
	public List<Place> findNearPlaces(double latitude, double longitude) {
		return placeDao.findNearPlaces(latitude, longitude);
	}
	
	
	

	
}
