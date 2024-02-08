package com.travel.management.bean;

public class TaxiInfo {
	
	private int id;
	private String carModel;
	private String licensePlate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	@Override
	public String toString() {
		return "TaxiDef [id=" + id + ", carModel=" + carModel + ", licensePlate=" + licensePlate + "]";
	}
}
