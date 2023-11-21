package com.ssafy.udong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.udong.model.dto.Equipment;
import com.ssafy.udong.model.dto.Place;
import com.ssafy.udong.model.dto.SearchCondition;
import com.ssafy.udong.model.service.EquipmentService;


@RestController
@RequestMapping("/api")
public class EquipmentController {
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";
	
	@Autowired
	private EquipmentService equipmentService;
	
	//해시태그로 검색 시 해당하는 운동기구 정보 및 운동장소 보여줌
	//해당하는 운동기구 몇개씩 있는지 count 해서 보여줌
	//검색기능
	@GetMapping("/equipment/search/{hashtag}")
	public ResponseEntity<?> search(@PathVariable String hashtag){
		
		List<Equipment> list = equipmentService.searchByHashtag(hashtag);
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Equipment>>(list, HttpStatus.OK);
	}
}
