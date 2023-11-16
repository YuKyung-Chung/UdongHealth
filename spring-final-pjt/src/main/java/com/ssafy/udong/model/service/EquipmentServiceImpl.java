package com.ssafy.udong.model.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EquipmentServiceImpl {
	public void fetchDataAndProcess() {
		String baseUrl = "api.odcloud.kr/api";
		
		// WebClient 객체 생성
        WebClient webClient = WebClient.create(baseUrl);

        // API 호출 및 데이터 수신
        webClient.get()
                .retrieve()
                .bodyToMono(String.class) //API 응답 Mono로 변환
                .subscribe(responseData -> { //데이터 비동기적 처리
                    // 받아온 데이터를 여기서 처리
                    System.out.println(responseData);
                    // 이후 원하는 작업 수행
                });
	}

}
