package com.ssafy.udong.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.udong.model.dto.Place;
import com.ssafy.udong.model.service.PlaceService;

@RestController
@RequestMapping("/api")
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	@Value("${api-key}")
	String APIKey;
	
	//API 호출하여 DB에 저장하는 메서드
	@GetMapping("")
    private void callOpenApi() throws IOException {
    	int page = 1; //현재 페이지 수
        int perPage = 161; //한 페이지 당 보여줄 데이터

        	StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15037929/v1/uddi:4302b579-6efd-4c38-9c39-bd04bc752435");
            urlBuilder.append("?page=" + page);
            urlBuilder.append("&perPage=" + perPage);
            urlBuilder.append("&serviceKey="+APIKey);

            URL url = new URL(urlBuilder.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {


            	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder responseBody = new StringBuilder();

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responseBody.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(responseBody.toString());
                JsonNode dataArray = rootNode.get("data");

                if (dataArray.isArray()) {
                    for (JsonNode node : dataArray) {
                        Place place = objectMapper.treeToValue(node, Place.class);
                        placeService.insertPlace(place);
                    }
                }
            }
        
    }
	
}
