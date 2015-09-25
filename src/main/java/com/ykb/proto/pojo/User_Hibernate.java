package com.ykb.proto.pojo;

import java.util.List;

public class User_Hibernate {
	
	// The no-argument constructor is a requirement for all persistent classes.
	public User_Hibernate() {};

	// Hibernate identifier.
	private long id;
	
	public long getId() {
		return id;
	}
	// Only Hibernate will assign identifiers when an object is saved.
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
	
	private String name;
	private double capital;
	private double defaultCommission;
	private double defaultStampTax;
	private List<StockPosition> stockPositions;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
