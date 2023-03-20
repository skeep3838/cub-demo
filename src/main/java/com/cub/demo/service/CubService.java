package com.cub.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cub.demo.DTO.CoindeskDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CubService {
	protected static final ObjectMapper mapper = new ObjectMapper();

	public CoindeskDTO coindesk() {

		CoindeskDTO coindeskResp = new CoindeskDTO();
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<>();
		ResponseEntity<String> responseEntity = restTemplate
				.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
		try {
			coindeskResp = mapper.readValue(responseEntity.getBody(), CoindeskDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return coindeskResp;
	}
}
