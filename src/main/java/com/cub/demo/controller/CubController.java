package com.cub.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cub.demo.entity.CurrencyEneity;
import com.cub.demo.service.CurrencyService;

@RestController
@RequestMapping("cub")
public class CubController {

	@Autowired
	CurrencyService cubService;

	/**
	 * 打coindesk API 並新增
	 * @param request
	 * @return
	 */
	@GetMapping("/coindeskApi")
	public List<CurrencyEneity> coindeskAndAdd(HttpServletRequest request) {
		return cubService.coindeskAndAdd();
	}

	/**
	 * 查詢所有幣別
	 * @param request
	 * @return
	 */
	@GetMapping("/currency")
	public List<CurrencyEneity> selectAllCoindesk(HttpServletRequest request) {
		return cubService.selectAllCoindesk();
	}

	/**
	 * 新增幣別
	 * @param request
	 * @param currency
	 * @return
	 */
	@PostMapping("/currency")
	public CurrencyEneity saveCoindesk(HttpServletRequest request, @RequestBody CurrencyEneity currency) {
		return cubService.addCoindesk(currency);
	}
	
	/**
	 * 更新幣別
	 * @param request
	 * @param entity
	 * @return
	 */
	@PutMapping("/currency")
	public CurrencyEneity updateCoindesk(HttpServletRequest request, @RequestBody CurrencyEneity entity) {
		return cubService.updateCoindesk(entity);
	}
	
	/**
	 * 刪除幣別
	 * @param request
	 * @param id
	 * @return
	 */
	@DeleteMapping("/currency/{id}")
	public Boolean deleteCoindesk(HttpServletRequest request,  @PathVariable("id") Integer id) {
		return cubService.deleteCoindesk(id);
	}
}
