package com.apptware.app;

import java.util.List;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

public class GenerateGraph {
	GenerateGraph() {

	}

	// Add cities to graph
	Graph addCities(List<City> cities, Graph graph) {
		for (City city : cities) {

			Node node = graph.addNode(city.getName());
			node.setAttribute("ui.label", city);
		}
		return graph;
	}

	// Add Edges to graphs
	Graph addRoads(List<Road> roads, Graph graph) {
		for (Road road : roads) {
			String edgeId = road.city1.getName() + "-" + road.city2.getName();
			String edgeId1 = road.city2.getName() + "-" + road.city1.getName();

			if (graph.getEdge(edgeId) == null && graph.getEdge(edgeId1) == null) {
				Edge edge = graph.addEdge(edgeId, road.city1.getName(), road.city2.getName());
				edge.setAttribute("ui.label", road.getLaneClass(road.lanes));
				edge.setAttribute("ui.class", road.getLaneClass(road.lanes));
				edge.setAttribute("layout.weight", 20.0);
			}
		}

		return graph;
	}

	Graph addAttributes(Graph graph) {
		graph.setAttribute("ui.stylesheet",
				"node { fill-color: red; size: 15px; text-size: 10px;z-index: 0; }"
						+ "edge.nh {size: 3px; fill-color: blue; }" + "edge.ish {size: 1.5px; fill-color: green; }"
						+ "edge.h {size: 0.9px; fill-color: yellow; }" + "edge.mr { size: 0.5px;fill-color: black; }");
		graph.setAttribute("ui.quality");
		graph.setAttribute("ui.antialias");
		return graph;
	}

}
