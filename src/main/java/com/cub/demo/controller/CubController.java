package com.cub.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cub.demo.DTO.CoindeskDTO;
import com.cub.demo.service.CubService;

@RestController
@RequestMapping("cub")
public class CubController {

	@Autowired
	CubService cubService;
	
	@GetMapping("/coindesk")
	public CoindeskDTO coindesk(HttpServletRequest request) {
		CoindeskDTO coindesk = new CoindeskDTO();
		coindesk = cubService.coindesk();
		
		return coindesk;
	}
	

}
