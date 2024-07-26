package com.apptware.app;

import java.util.ArrayList;
import java.util.Random;

public class City {
	private String name;
	private double latitude;
	private double longitude;
	private int outLane;
	private int inLane;

	public int getOutLane() {
		return outLane;
	}

	public void setOutLane(int outLane) {
		this.outLane = outLane;
	}

	public int getInLane() {
		return inLane;
	}

	public void setInLane(int inLane) {
		this.inLane = inLane;
	}

	City() {

	}

	City(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	int determineLaneType(int laneType) {

		Random rand = new Random();

		switch (laneType) {

		case 2:
			return rand.nextBoolean() ? 3 : 1;
		case 3:
			return 2;
		default:
			return rand.nextBoolean() ? 1 : 2;
		}
	}

	ArrayList<City> generateCities(int city_count) {
		ArrayList<City> cities = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < city_count; i++) {
			String name = "City " + i;
			double latitude = -90 + 180 * rand.nextDouble(); // Random latitude between -90 and 90
			double longitude = -180 + 360 * rand.nextDouble(); // Random longitude between -180 and 180
			City city = new City(name, latitude, longitude);
			cities.add(city);
		}
		return cities;

	}

	@Override
	public String toString() {
		return String.format("%s (%f, %f)", name, latitude, longitude);
	}
}
