package com.cub.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cub.demo.dto.CoindeskDTO;
import com.cub.demo.entity.CurrencyEneity;
import com.cub.demo.repository.CurrencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CurrencyService {
	protected static final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	CurrencyRepository currencyRepository;

	/**
	 * 打coindesk API 並新增
	 * 
	 * @return
	 */
	@Transactional
	public List<CurrencyEneity> coindeskAndAdd() {

		List<CurrencyEneity> currencyList = new ArrayList<>();
		CoindeskDTO coindeskResp = new CoindeskDTO();
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate
				.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);

		try {
			coindeskResp = mapper.readValue(responseEntity.getBody(), CoindeskDTO.class);
			Date time = df1.parse(coindeskResp.getTime().getUpdatedISO());
			coindeskResp.getBpi().forEach((key, value) -> {
				CurrencyEneity entity = new CurrencyEneity();
				entity.setCname(value.getCname());
				entity.setCode(value.getCode());
				entity.setDescription(value.getDescription());
				entity.setRate(value.getRate());
				entity.setRate_float(value.getRate_float());
				entity.setSymbol(value.getSymbol());
				entity.setUpdatedTime(time);
				currencyList.add(entity);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currencyRepository.saveAllAndFlush(currencyList);
	}

	/**
	 * 新增幣別
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional
	public CurrencyEneity addCoindesk(CurrencyEneity entity) {
		try {
			entity.setUpdatedTime(new Date());
			currencyRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * 查詢所有幣別
	 * 
	 * @return
	 */
	public List<CurrencyEneity> selectAllCoindesk() {
		return currencyRepository.findAll();
	}

	/**
	 * 更新幣別
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional
	public CurrencyEneity updateCoindesk(CurrencyEneity entity) {
		Optional<CurrencyEneity> query = currencyRepository.findById(entity.getId());
		if (query.isEmpty()) {
			return null;
		}
		entity.setUpdatedTime(new Date());
		return currencyRepository.save(entity);
	}

	/**
	 * 刪除幣別
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Boolean deleteCoindesk(Integer id) {
		currencyRepository.deleteById(id);
		return true;
	}
}
