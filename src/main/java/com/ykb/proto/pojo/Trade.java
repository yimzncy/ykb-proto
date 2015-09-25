package com.ykb.proto.pojo;

import com.ykb.proto.pojo.enums.TradeType;

public class Trade {
	
	private TradeType tradeType;
	private long date;
	private double price;
	private int amount;
	private double commission;
	private double stampTax;
	
	public TradeType getTradeType() {
		return tradeType;
	}
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public double getStampTax() {
		return stampTax;
	}
	public void setStampTax(double stampTax) {
		this.stampTax = stampTax;
	}

}
