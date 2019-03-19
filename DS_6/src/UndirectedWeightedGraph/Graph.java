package UndirectedWeightedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
/**
 * class represents a graph data structure having functions like addEdge, isConnected , reachable ,printGraph ,
 * minimumSpanningTree , shortest path;
 * @author Admin
 *
 */
public class Graph {
   // total no. of vertices in the graph
	int vertices;
	// Edge List representation via linked list to store the edges of the graph
    LinkedList<Edge> [] adjacencylist;
   
    /*
    * @param vertices of type integer to initialize graph 
    */
    Graph(Integer vertices) throws Exception {
    	if(vertices == null)
			throw new Exception(" null value passed as vertices ");
    	
    	if (vertices < 1)
    		throw new Exception("number of vertices should be greater than zero"); 
    	
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }
    
    /*
     * @return adjacencyList of type LinkedListed<Edge>
     */
    public LinkedList<Edge>[] getGraph(){
    	return adjacencylist;
    }
    
    /*
     * @param source of type int represent source vertex 
     * @param destination of type int represent destination vertex
     * @param weight of type int represent weight of edge to move from source vertex to destination vertex
     */
    public void addEgde(Integer source, Integer destination, Integer weight) throws Exception {
    	
    	if (this.vertices < 2)
			throw new Exception("number of vertices should be greater than 1 to add edge");
		
    	if (source == null || destination == null || weight == null) 
			throw new Exception("null value passed as parameter for edge");
		
    	if (source < 0 || source >= this.vertices ) 
			throw new Exception("Invalid input for source vertax ");
		
    	if (destination < 0 || destination >= this.vertices) 
			throw new Exception("Invalid input for destination vertax");
    	
    	if (destination == source) 
			throw new Exception(" source and destination cant be same ");
		
    	if (weight < 1) 
			throw new Exception("Weight can't be less than 1 ");
    	
    	//adds both edges eg (1,0) and (0,1) as undirected graph
    	Edge edge = new Edge(source, destination, weight);
    	adjacencylist[source].add(edge); 
        edge = new Edge(destination, source, weight);
        adjacencylist[destination].add(edge); 
    }
    
	/*
	 * print graph
	 */
    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println("vertex-" + i + " is connected to " +
                        list.get(j).destination + " with weight " +  list.get(j).weight);
            }
        }
    }
    
    /*
     * to check if graph is connected or disconnected
     * implemented using depth first search
     * logic : if after traversing graph using DFS , Visited edges equals total vertices then grapgh is connected  
     * @returns true if graph is connected
     */
    public boolean isConnected(){
    	Stack<Integer> stack = new Stack<Integer>();
    	ArrayList<Integer> visited = new ArrayList<Integer>();
    	LinkedList<Edge> list;
    	int vertax,i;
    	stack.push(0);
    	while( !stack.empty() ) {
    		vertax = stack.pop();
    		visited.add(vertax);
    		list = adjacencylist[vertax];
    		for(i = 0; i< list.size() ; i++)
    			if( !visited.contains(list.get(i).destination) && !stack.contains(list.get(i).destination))
    				stack.push(list.get(i).destination);    	
    	}
    	if(visited.size() == vertices)
    		return true;
    	else 
    		return false;
    }
    
    /*
     * @param vertex of type integer for which all reachable vertices are to be found
     * @returns ArrayList of integer type holding the vertices reachable from a given vertex
     */
    public ArrayList<Integer> reachable(Integer vertex) throws Exception{
    	ArrayList<Integer> canBeVisited = new ArrayList<Integer>();
    	if( vertex == null )
    		throw new Exception(" Null Value passed ");
    	else if ( vertex < 0 || vertex > vertices )
    		throw new Exception(" Invalid Vertax value passed as parameter ");
    	
    	for(int i=0; i < adjacencylist[vertex].size() ;i++)
    		canBeVisited.add(adjacencylist[vertex].get(i).destination);
		return canBeVisited;
    }
    
    /*
     * to find minimum spanning tree for the graph
     * implemented using prims algorithm : the greedy approach
     * @returns a graph that is the minimum spanning tree
     */
    public Graph mininmumSpanningTree() throws Exception{
    	//contains edges that are accessible currently
    	ArrayList<Edge> edgesAccessable = new ArrayList<Edge>();
    	//contains edges that are to be added to the minimum spanning tree
    	ArrayList<Edge> mst = new ArrayList<Edge>();
    	int count=0 , i;
    	Edge e;
    	//for adding edges initially to edgesAccessible with the vertices accessible from first vertex (0) 
    	for(i=0; i < adjacencylist[0].size() ;i++)
    		{
    			// add edge only its not present already 
    			if(!edgesAccessable.contains(adjacencylist[0].get(i)))
    				edgesAccessable.add(adjacencylist[0].get(i)); 
    			else
    				for(int j=0; j<edgesAccessable.size();j++)
    				{
    					//adding edge only if new edge have  weight less than the previous one that already exist 
    					if(edgesAccessable.get(j).getSource() == adjacencylist[0].get(i).getSource() &&
    							edgesAccessable.get(j).getDestination() == adjacencylist[0].get(i).getDestination() &&
    							edgesAccessable.get(j).getWeight() > adjacencylist[0].get(i).getWeight())
    					{
    						//remove the previous edge 
    						edgesAccessable.remove(j);
    						// add the new edge
    						edgesAccessable.add(adjacencylist[0].get(i));
    					}
    						
    				}
    		}
    	//sort the accessible edge on basis of their weight 		   	
    	Collections.sort(edgesAccessable,Edge.EdgeWeight);
    	//add the lightest weighing edge to mst
    	mst.add(edgesAccessable.get(0));
    	// remove that edge from accessible edge now
    	edgesAccessable.remove(0);
    	//loop until all vertices are covered by an edge
    	while(mst.size() != vertices-1){
    		//opening edges from the last added edge
    		for(i=0; i < adjacencylist[mst.get(count).destination].size() ;i++)
        	{	
    			e= new Edge(adjacencylist[mst.get(count).destination].get(i).destination ,
						adjacencylist[mst.get(count).destination].get(i).source ,
						adjacencylist[mst.get(count).destination].get(i).weight);
    			//add edge to mst only if mst does not contains it eg:
    			//1,0 is some edge to be added then it checks if mst does not contain 1,0 and 0,1 both  
    			if(!mst.contains(e) && !mst.contains(adjacencylist[mst.get(count).destination].get(i)))
    				edgesAccessable.add(adjacencylist[mst.get(count).destination].get(i));
        	}    		
    		Collections.sort(edgesAccessable,Edge.EdgeWeight);
    		mst.add(edgesAccessable.get(0));
        	edgesAccessable.remove(0);
        	count++;
    	}   	
    	
    	// creating Minimum spanning tree 
    	Graph g= new Graph(vertices);
    	for(Edge edge:mst)
    		g.addEgde(edge.getSource(),edge.getDestination(),edge.getWeight());
    	return g;
    }
    
    /*
     * to find shortest path from source vertex to destination vertex
     * implemented using dijsktra's algorithm
     * 
     */
    public int shortestPath(Integer source,Integer destination) throws Exception{
    	int i;
    	// stores all edges accessible currently 
    	ArrayList<Edge> edgesAccessable = new ArrayList<Edge>();
    	// to store shortest path from source to all other vertices
    	HashMap<Integer , Integer> shortestPath = new HashMap<Integer, Integer>();
    	// stores the vertices visited
    	ArrayList<Integer> visited = new ArrayList<Integer>();

    	if (source == null || destination == null ) 
			throw new Exception("null value passed as parameter to Shortestpath");
		
    	if (source < 0 || source >= this.vertices ) 
			throw new Exception("Invalid input for source vertax ");
		
    	if (destination < 0 || destination >= this.vertices) 
			throw new Exception("Invalid input for destination vertax");
    	
    	//initialing map for the first time
		for(i=0 ; i<vertices; i++){
			if(i==source)
				shortestPath.put(i,0);
			else
				shortestPath.put(i, Integer.MAX_VALUE);
		}
		
		// adding initial edges from source
    	for(i=0 ; i < adjacencylist[source].size() ; i++)
    		edgesAccessable.add(adjacencylist[source].get(i));
    	
    	Collections.sort(edgesAccessable, Edge.EdgeWeight);
    	
    	//adding vertices to visited by choosing the lightest edge first
    	visited.add(edgesAccessable.get(0).getDestination());
    	visited.add(source);
    	shortestPath.replace(edgesAccessable.get(0).getDestination(), 
						edgesAccessable.get(0).getWeight());
    	//opening edges
    	while(visited.size() != vertices){
    		
    		for(i=0 ; i < adjacencylist[edgesAccessable.get(0).getDestination()].size() ; i++){
    		if(!visited.contains(adjacencylist[edgesAccessable.get(0).getDestination()].get(i).destination) ||
        		
        				!visited.contains(adjacencylist[edgesAccessable.get(0).getDestination()].get(i).source))
        		{
        			edgesAccessable.add(adjacencylist[edgesAccessable.get(0).getDestination()].get(i));
        			
        		}
        	}
    		//remove the edge which was already opened
    		edgesAccessable.remove(0);    			
    		Collections.sort(edgesAccessable, Edge.EdgeWeight);
    		if(shortestPath.get(edgesAccessable.get(0).getDestination()) > 
        	(shortestPath.get(edgesAccessable.get(0).getSource()) + edgesAccessable.get(0).getWeight())){
        		//adding vertices to visited by choosing the lightest edge first
        		visited.add(edgesAccessable.get(0).getDestination());
        		//change the distance with minimum distance
        		if(shortestPath.get(edgesAccessable.get(0).getSource()) != Integer.MAX_VALUE)
        		shortestPath.replace(edgesAccessable.get(0).getDestination(), 
        				(shortestPath.get(edgesAccessable.get(0).getSource()) + edgesAccessable.get(0).getWeight()));
        		else
        			shortestPath.replace(edgesAccessable.get(0).getDestination(), 
            				 edgesAccessable.get(0).getWeight());
            		
        	}
    	}
    	return shortestPath.get(destination);
    }
    
}