package com.ssafy.udong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.udong.model.dto.Equipment;
import com.ssafy.udong.model.dto.SearchCondition;
import com.ssafy.udong.model.service.EquipmentService;


@RestController
@RequestMapping("/api")
public class EquipmentController {
	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";
	
	@Autowired
	private EquipmentService equipmentService;
	
	
}
