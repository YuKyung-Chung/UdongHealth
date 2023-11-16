package com.ssafy.udong.config;

import org.springframework.web.reactive.function.client.WebClient;

public class APICaller {
	public void callAPI() {
		String baseUrl = "api.odcloud.kr/api";
		
		//WebClient 객체 생성
		WebClient webClient = WebClient.create(baseUrl);
	
		//API 호출 및 데이터 수신
		webClient.get()
		.retrieve()
		.bodyToMono(String.class)
		.subscribe(response -> {
			System.out.println(response);
		});
	}
}
