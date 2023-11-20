package com.ssafy.udong.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.udong.model.dao.EquipmentDao;
import com.ssafy.udong.model.dto.Equipment;
import com.ssafy.udong.model.dto.SearchCondition;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentDao equipmentDao;



	

}
