package com.ykb.proto.pojo;

import com.ykb.proto.pojo.enums.StockMarket;

public class Stock {
	
	private StockMarket stockMarket;
	private String code;
	private String name;
	
	public StockMarket getStockMarket() {
		return stockMarket;
	}
	public void setStockMarket(StockMarket stockMarket) {
		this.stockMarket = stockMarket;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}