package com.derun.jczb.model;

public class Storage {
	
	private long jarCode;
	private String stationID;
	private int oilType;
	private String collectionDate;
	private String collectionTime;
	private double oilHigh;
	private double waterHigh;
	private double Temperature;
	private double oilCubage;
	private double oilWeight;
	private double jarCubage;

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}

	public long getJarCode() {
		return jarCode;
	}

	public void setJarCode(long jarCode) {
		this.jarCode = jarCode;
	}

	public double getJarCubage() {
		return jarCubage;
	}

	public void setJarCubage(double jarCubage) {
		this.jarCubage = jarCubage;
	}

	public double getOilCubage() {
		return oilCubage;
	}

	public void setOilCubage(double oilCubage) {
		this.oilCubage = oilCubage;
	}

	public double getOilHigh() {
		return oilHigh;
	}

	public void setOilHigh(double oilHigh) {
		this.oilHigh = oilHigh;
	}

	public int getOilType() {
		return oilType;
	}

	public void setOilType(int oilType) {
		this.oilType = oilType;
	}

	public double getOilWeight() {
		return oilWeight;
	}

	public void setOilWeight(double oilWeight) {
		this.oilWeight = oilWeight;
	}

	public String getStationID() {
		return stationID;
	}

	public void setStationID(String stationID) {
		this.stationID = stationID;
	}

	public double getTemperature() {
		return Temperature;
	}

	public void setTemperature(double temperature) {
		Temperature = temperature;
	}

	public double getWaterHigh() {
		return waterHigh;
	}

	public void setWaterHigh(double waterHigh) {
		this.waterHigh = waterHigh;
	}
}
