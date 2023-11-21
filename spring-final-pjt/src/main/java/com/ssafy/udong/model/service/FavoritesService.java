package com.ssafy.udong.model.service;

import java.util.List;

import com.ssafy.udong.model.dto.Favorites;

public interface FavoritesService {

	//즐겨찾기 등록
	void addFavorites(int userId, int placeId) throws Exception;

	//즐겨찾기 목록 조회
	List<Favorites> getList(int userId);

	//즐겨찾기 삭제
	boolean removeFavorites(int userId, int placeId);


}
