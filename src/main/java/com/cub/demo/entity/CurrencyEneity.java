package com.cub.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class CurrencyEneity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "cname", nullable = true)
	private String cname;
	
	@Column(name = "code", nullable = true)
	private String code;

	@Column(name = "symbol", nullable = true)
	private String symbol;

	@Column(name = "rate", nullable = true)
	private String rate;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "rateFloat", nullable = true)
	private Float rate_float;
	
	@Column(name = "updatedTime", nullable = true)
	private Date updatedTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getRate_float() {
		return rate_float;
	}

	public void setRate_float(Float rate_float) {
		this.rate_float = rate_float;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}


}
