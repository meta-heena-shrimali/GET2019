package UndirectedWeightedGraph;
/**
 * class to contain information about Edges of the graph
 */
import java.util.Comparator;

public class Edge {
    int source;
    int destination;
    int weight;
    /*
     * @param source of type int represent source vertex 
     * @param destination of type int represent destination vertex
     * @param weight of type int represent weight of edge to move from source vertex to destination vertex
     */
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    /*
     * @return weight of edge
     */
    public int getWeight(){
    	return this.weight;
    }
    
    /*
     * @return source vertex
     */
    public int getSource(){
    	return this.source;
    }
    
    /*
     * @return destination vertex 
     */
    public int getDestination(){
    	return this.destination;
    }
    
    // implementation of Comparator to sort ArrayList of edges in ascending order by their weight
    public static Comparator<Edge> EdgeWeight = new Comparator<Edge>() {

    	public int compare(Edge e1, Edge e2) {

    	   int weight1 = e1.getWeight();
    	   int weight2 = e2.getWeight();
    	   return weight1-weight2;
       }};
    
    
    @Override   
    public String toString(){
    	return (" source : "+source+" desination : "+destination+" weight : "+weight);
    }
    
    // Overridden equals method to help contains method of ArrayList to check existance and compare Edges 
   @Override
    public boolean equals(Object obj) {
	   Edge e=(Edge) obj;
	   if(e.destination == this.destination && e.source == this.source)
		   return true;
	   return false;
    }
}
