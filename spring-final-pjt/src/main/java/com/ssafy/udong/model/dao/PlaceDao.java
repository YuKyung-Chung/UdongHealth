package com.ssafy.udong.model.dao;

import java.util.List;

import com.ssafy.udong.model.dto.Place;

public interface PlaceDao {
	//장소 등록
	void insertPlace(Place place);

	//전체 장소 목록 조회
	List<Place> getPlaces();

	//상세 장소 조회
	Place getPlace(int placeId);

}
