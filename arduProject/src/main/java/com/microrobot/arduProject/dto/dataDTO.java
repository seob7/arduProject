package com.microrobot.arduProject.dto;

public class dataDTO {	
	private double temp; //온도
	private double humid; //습도
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getHumid() {
		return humid;
	}
	public void setHumid(double humid) {
		this.humid = humid;
	}
	@Override
	public String toString() {
		return "dataDTO [temp=" + temp + ", humid=" + humid + "]";
	}
}
