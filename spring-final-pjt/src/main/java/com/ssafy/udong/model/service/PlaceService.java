package com.ssafy.udong.model.service;

import java.util.List;

import com.ssafy.udong.model.dto.Place;

public interface PlaceService {

	//장소 등록(API에서 받아와서 DB에 저장)
	void insertPlace(Place place);
	
	//장소 목록 전체 조회
	List<Place> getPlaces();

	//상세 장소 조회
	Place getPlace(int placeId);

}
