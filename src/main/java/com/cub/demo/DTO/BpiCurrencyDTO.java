package com.cub.demo.dto;

public class BpiCurrencyDTO {

	String code;
	String cname;
	String symbol;
	String rate;
	String description;
	Float rate_float;

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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

}
