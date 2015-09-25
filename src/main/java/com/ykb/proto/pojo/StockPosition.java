package com.ykb.proto.pojo;

import java.util.List;

public class StockPosition {
	
	private Stock stock;
	private List<Trade> trades;
	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public List<Trade> getTrades() {
		return trades;
	}
	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

}
