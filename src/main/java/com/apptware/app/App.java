package com.apptware.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

public class App {
	private static final int NUM_CITIES = 100;
    private static final int MAX_NATIONAL_HIGHWAYS = 4;
    private static City city = new City();
    private static GenerateGraph generateGraph = new GenerateGraph();
    private static Road road = new Road();
    

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        
        Graph graph = new MultiGraph("MultiGraph");
        

        Random rand = new Random();
        List<City> cities = new ArrayList<>();
        List<Road> roads = new ArrayList<>();

        // Generate 100 random cities
        cities = city.generateCities(NUM_CITIES);
        
        
        
        for (City city : cities) {
            System.out.println(city);
        }

        roads = road.addRoads(MAX_NATIONAL_HIGHWAYS, cities);
        
        graph = generateGraph.addCities(cities, graph);
        
        graph = generateGraph.addRoads(roads, graph);
        
        graph = generateGraph.addAttributes(graph);

        
        Viewer viewer = graph.display(true);
        View view = viewer.getDefaultView();
        view.getCamera().setViewCenter(2, 3, 4);

        

    }

    
}

