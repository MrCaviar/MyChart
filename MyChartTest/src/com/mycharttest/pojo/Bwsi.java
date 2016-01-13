package com.mycharttest.pojo;

import java.sql.Date;

public class Bwsi {
	private int wsi_id;
	private String sec_name; 		//证券简称
	private String trade_code;		//证券代码
	private Date time;				//时刻
	private float open;				//开盘价
	private float high;				//最高价
	private float low;				//最低价
	private float close;			//收盘价
	private float volume;			//成交量
	private float amt;				//成交额
	private float average;			//均价
	
	public int getWsi_id() {
		return wsi_id;
	}
	public void setWsi_id(int wsi_id) {
		this.wsi_id = wsi_id;
	}
	public String getSec_name() {
		return sec_name;
	}
	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}
	public String getTrade_code() {
		return trade_code;
	}
	public void setTrade_code(String trade_code) {
		this.trade_code = trade_code;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Bwsi [wsi_id=" + wsi_id + ", sec_name=" + sec_name + ", trade_code=" + trade_code 
				+ ", time=" + time + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", volume=" + volume + ", amt=" + amt + ", average=" + average + "]";
	}
}
