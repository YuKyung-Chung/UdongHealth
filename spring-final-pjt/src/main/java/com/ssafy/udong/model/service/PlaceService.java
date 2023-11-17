package com.ssafy.udong.model.service;

import java.util.List;

import com.ssafy.udong.model.dto.Place;

public interface PlaceService {

	void insertPlace(Place place);
	
	List<Place> getPlaces();

}
