package com.apptware.app;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Road {
	City city1;
	City city2;
	int lanes;

	Road() {

	}

	Road(City city1, City city2, int lanes) {
		this.city1 = city1;
		this.city2 = city2;
		this.lanes = lanes;
	}

	ArrayList<Road> addRoads(int max_national_highways, List<City> cities) {
		// NAtional highway
		Random rand = new Random();
		// Get a random value between 1 and max_national_highways number
		max_national_highways = rand.nextInt(max_national_highways) + 1;
		ArrayList<Road> roads = new ArrayList<>();
		// Connect the cities with National Highways
		for (int i = 0; i < max_national_highways; i++) {
			City city1 = cities.get(rand.nextInt(cities.size()));
			City city2 = cities.get(rand.nextInt(cities.size()));
			while (city2.getInLane() != 0 && city2.getOutLane() != 0) {
				city1 = cities.get(rand.nextInt(cities.size()));
			}
			while (city1.equals(city2) || (city2.getInLane() != 0 && city2.getOutLane() != 0)) { // Ensure different
																									// cities
				city2 = cities.get(rand.nextInt(cities.size()));
			}
		

			city1.setOutLane(4);
			city2.setInLane(4);

			roads.add(new Road(city1, city2, 4));

		}

		// Establish connections between other cities based on the outLane/inLane
		// Ensures each city is connected atleast once
		for (City city : cities) {
			// if there is not outLane from the source city
			if (city.getOutLane() == 0) {
				// Select a random target city
				City targetCity = cities.get(rand.nextInt(cities.size()));

				while ((city.getName() == targetCity.getName())) {
					// Ensure different cities
					targetCity = cities.get(rand.nextInt(cities.size()));
				}

				// check the outlane
				int outLane = targetCity.getOutLane();

				// determine outlane type
				int laneType = targetCity.determineLaneType(outLane);
				city.setOutLane(laneType);
				targetCity.setInLane(laneType);
				roads.add(new Road(city, targetCity, laneType));

			}
			// if there is not inLane from the source city
			else if (city.getInLane() == 0) {
				// make current city as target city
				City targetCity = city;

				// choose a source city
				City source = cities.get(rand.nextInt(cities.size()));
				while (source.equals(targetCity)) { // Ensure different cities
					source = cities.get(rand.nextInt(cities.size()));
				}

				// check the inlane of source
				int inLane = source.getInLane();

				// determine outLane type
				int laneType = source.determineLaneType(inLane);
				source.setOutLane(laneType);
				targetCity.setInLane(laneType);
				roads.add(new Road(source, targetCity, laneType));

			}

		}

		return roads;
	}

	String getLaneClass(int lanes) {
		switch (lanes) {
		case 1:
			return "mr";
		case 2:
			return "h";
		case 3:
			return "ish";
		case 4:
			return "nh";
		default:
			return "mr";
		}
	}

}
