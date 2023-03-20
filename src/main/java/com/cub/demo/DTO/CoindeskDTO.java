package com.cub.demo.DTO;

import java.util.HashMap;
import java.util.Map;

public class CoindeskDTO {

	String disclaimer;
	String chartName;
	Map<String, BpiCurrencyDTO> bpi = new HashMap<>();
	TimeDTO time = new TimeDTO();

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public Map<String, BpiCurrencyDTO> getBpi() {
		return bpi;
	}

	public void setBpi(Map<String, BpiCurrencyDTO> bpi) {
		this.bpi = bpi;
	}

	public TimeDTO getTime() {
		return time;
	}

	public void setTime(TimeDTO time) {
		this.time = time;
	}

}
