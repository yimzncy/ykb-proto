package com.ykb.proto.pojo;

import java.util.List;

public class User {
	
	private long id;
	private String name;
	private String password;
	private double capital;
	private double defaultCommission;
	private double defaultStampTax;
	private List<StockPosition> stockPositions;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public double getDefaultCommission() {
		return defaultCommission;
	}
	public void setDefaultCommission(double defaultCommission) {
		this.defaultCommission = defaultCommission;
	}
	public double getDefaultStampTax() {
		return defaultStampTax;
	}
	public void setDefaultStampTax(double defaultStampTax) {
		this.defaultStampTax = defaultStampTax;
	}
	public List<StockPosition> getStockPositions() {
		return stockPositions;
	}
	public void setStockPositions(List<StockPosition> stockPositions) {
		this.stockPositions = stockPositions;
	}

}
