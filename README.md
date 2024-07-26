# apptware-map-app

Objective: Develop a Java application to generate and display a random map of 100 cities with roads connecting them, using GraphStream for visualization.
Requirements:

City:

Attributes: name (String), latitude (double), longitude (double).
Road:

Attributes: city1 (City), city2 (City), lanes.
Lane types:
4 lanes: National Highways
3 lanes: Inter-State Highways
2 lanes: Highways
1 lane: Main Roads
Map:

SubTasks:
Generate 100 random city names with random latitude and longitude values.
Print the list of cities with their names and coordinates.
Ensure the output varies with each run using randomization.
Road Connections:

Establish connections between cities:
Max of 4 National Highways (4 lanes).
Inter-State Highways (3 lanes) can connect to National Highways.
Highways (2 lanes) can connect to Inter-State Highways.
Main Roads (1 lane) can connect to Highways.
Ensure each city is connected to at least one other city.
Graph Visualization:

Use GraphStream (https://graphstream-project.org/) to display the map:
Cities as nodes.
Roads as edges, with visual differentiation based on the number of lanes.

Software Requirements:
1. Java 8
2. Apache Maven 3.9.x

Functional Requirements-
1. App.java - To run the app. The objects are created here and the graph is displyed.
2. City.java - Create cities as per the requirement and make sure relevant lanes are added between two cities.
3. Road.java - To create road between two cities as per requirement.
4. GenerateGraph.java - To add Nodes and edges to the graph. Also, graph attributes are added.

Graph Legends:
Main Road: "mr", color: black 
Highway: "h", color: yellow
Inter-State Highways: "ish", color: green
National Highways: "nh", color: blue
Nodes: Represented by City Name, Latitude and Logitude with color: red

Tools & Technologies used.
1. Build Automation Tool - Maven
2. Software Language - Java
3. Runtime Environment - JRE 8
4. IDE - Eclipse

How to run?
1. Clone the project.
2. Using IDE
   a. Import the Project.
   b. Run as Java App
3. Using Command Prompt/Terminal:
   a. Run mvn compile
   b. Run mvn exec:java -Dexec.mainClass=com.apptware.app.App

Navigate Graph:
1. To zoom in or out use page up or page down. In Mac, fn + up/down arrow.
2. Use arrow keys to move accross the map.

   
