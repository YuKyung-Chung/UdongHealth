package com.ssafy.udong.model.dao;

import java.util.List;

import com.ssafy.udong.model.dto.Place;

public interface PlaceDao {
	void insertPlace(Place place);

	List<Place> getPlaces();

}
