package UndirectedWeightedGraph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testNullValuePassedInConstructor() {
		 try {
			 new Graph(null);
		 }
		 catch (Exception e) {
			 assertEquals(" null value passed as vertices ", e.getMessage());
		 }
	}
	@Test
	public void testInvalidVertaxValuePassedInConstructor() {
		 try {
			 new Graph(-9);
		 }
		 catch (Exception e) {
			 assertEquals("number of vertices should be greater than zero", e.getMessage());
		 }
	}
	@Test
	public void testInvalidVertaxValueButWantToAddEdge() {
		 try {
			 new Graph(1).addEgde(1, 1, 1);
			 
		 }
		 catch (Exception e) {
			 assertEquals("number of vertices should be greater than 1 to add edge", e.getMessage());
		 }
	}
	@Test
	public void testNullValuePassedToAddEdge() {
		 try {
			 new Graph(3).addEgde(null,null,null);
			 
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as parameter for edge", e.getMessage());
		 }
	}
	@Test
	public void testInvalidSourceValuePassedToAddEdge() {
		 try {
			 new Graph(3).addEgde(6,1,3);
			 
		 }
		 catch (Exception e) {
			 assertEquals("Invalid input for source vertax ", e.getMessage());
		 }
	}
	@Test
	public void testInvalidDestinationValuePassedToAddEdge() {
		 try {
			 new Graph(3).addEgde(1,-3,3);
			 
		 }
		 catch (Exception e) {
			 assertEquals("Invalid input for destination vertax", e.getMessage());
		 }
	}
	@Test
	public void testSameSourceAndDestinationValuePassedToAddEdge() {
		 try {
			 new Graph(3).addEgde(1,1,3);
			 
		 }
		 catch (Exception e) {
			 assertEquals(" source and destination cant be same ", e.getMessage());
		 }
	}
	@Test
	public void testInvalidWeightValuePassedToAddEdge() {
		 try {
			 new Graph(3).addEgde(1,2,0);
			 
		 }
		 catch (Exception e) {
			 assertEquals("Weight can't be less than 1 ", e.getMessage());
		 }
	}
	
	
	@Test
	public void testNullValuePassedToShortestPath() {
		 try {
			 Graph g= new Graph(3);
			 g.addEgde(2,1,3);
			 g.shortestPath(null, null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as parameter to Shortestpath", e.getMessage());
		 }
	}
	@Test
	public void testInvalidDestinationValuePassedToShortestPath() {
		 try {
			 Graph g= new Graph(3);
			 g.addEgde(2,1,3);
			 g.shortestPath(0, -1);
		 }
		 catch (Exception e) {
			 assertEquals("Invalid input for destination vertax", e.getMessage());
		 }
	}
	@Test
	public void testInvalidSourceValuePassedToShortestPath() {
		 try {
			 Graph g= new Graph(3);
			 g.addEgde(2,1,3);
			 g.shortestPath(7, 1);
		 }
		 catch (Exception e) {
			 assertEquals("Invalid input for source vertax ", e.getMessage());
		 }
	}
	
	@Test
	public void testAddEdge() throws Exception {
			Graph g = new Graph(7);
			g.addEgde(0, 1, 2);
			g.addEgde(0, 2, 3);
			g.addEgde(2, 3, 1);
			g.addEgde(2, 4, 5);
			g.addEgde(3, 4, 8);
			g.addEgde(5, 6, 4);
			g.printGraph();
			 		 
	}
	@Test
	public void testIsConnectedTrue() throws Exception {
		 	Graph g = new Graph(5);
			g.addEgde(0, 1, 2);
			g.addEgde(0, 2, 3);
			g.addEgde(2, 3, 1);
			g.addEgde(2, 4, 5);
			g.addEgde(3, 4, 8);
			
			assertTrue(g.isConnected());
	
	}
	@Test
	public void testIsConnectedFalse() throws Exception {
		 	Graph g = new Graph(7);
			g.addEgde(0, 1, 2);
			g.addEgde(0, 2, 3);
			g.addEgde(2, 3, 1);
			g.addEgde(2, 4, 5);
			g.addEgde(3, 4, 8);
			g.addEgde(5, 6, 4);
			
			assertFalse(g.isConnected());
	
	}
	@Test
	public void testNullValuePassedToReachable() {
		 try {
			 new Graph(3).reachable(null);
			 
		 }
		 catch (Exception e) {
			 assertEquals(" Null Value passed ", e.getMessage());
		 }
	}
	@Test
	public void testInvalidVertaxValuePassedToReachable() {
		 try {
			 new Graph(3).reachable(6);
			 
		 }
		 catch (Exception e) {
			 assertEquals(" Invalid Vertax value passed as parameter ", e.getMessage());
		 }
	}
	@Test
	public void testReachable() throws Exception {
		 	Graph g = new Graph(7);
			g.addEgde(0, 1, 2);
			g.addEgde(0, 2, 3);
			g.addEgde(2, 3, 1);
			g.addEgde(2, 4, 5);
			g.addEgde(3, 4, 8);
			ArrayList<Integer> actual = g.reachable(2);
			ArrayList<Integer> expected = new ArrayList<Integer>();
			expected.add(0);
			expected.add(3);
			expected.add(4);			
			assertEquals(actual, expected);
	}
	@Test
	public void testReachableWhenNothingReachable() throws Exception {
		 	Graph g = new Graph(7);
			g.addEgde(0, 1, 2);
			ArrayList<Integer> actual = g.reachable(2);
			ArrayList<Integer> expected = new ArrayList<Integer>();
			assertEquals(actual, expected);
	}
	
	@Test
	public void testMst() throws Exception {
		Graph g = new Graph(5);
		g.addEgde(0, 1, 2);
		g.addEgde(0, 2, 3);
		g.addEgde(0, 2, 1);
		g.addEgde(2, 3, 1);
		g.addEgde(2, 4, 5);
		g.addEgde(3, 4, 8);
		
		LinkedList<Edge> [] expectedMstList , mstList;
		expectedMstList = new LinkedList[5];
		for (int i = 0; i <5 ; i++) 
			expectedMstList[i] = new LinkedList<>();
		expectedMstList[0].add(new Edge(0, 2, 1)); 
		expectedMstList[0].add(new Edge(0, 1, 2));
		expectedMstList[1].add(new Edge(1, 0, 2)); 
		expectedMstList[2].add(new Edge(2, 0, 1)); 
		expectedMstList[2].add(new Edge(2, 3, 1)); 
		expectedMstList[2].add(new Edge(2, 4, 5)); 
		expectedMstList[3].add(new Edge(3, 2, 1)); 
		expectedMstList[4].add(new Edge(4, 2, 5)); 
		
		
		Graph MST= g.mininmumSpanningTree();
		mstList = MST.getGraph();
		for (int i = 0; i <5 ; i++) {
            LinkedList<Edge> actualList = mstList[i];
            LinkedList<Edge> expectedList = expectedMstList[i];
            
            for (int j = 0; j <expectedList.size() ; j++) {
            	assertEquals(expectedList.get(j).getSource(),actualList.get(j).getSource());
            	assertEquals(expectedList.get(j).getDestination(),actualList.get(j).getDestination());
            	assertEquals(expectedList.get(j).getWeight(),actualList.get(j).getWeight());
            	
            }
        }
	}
	@Test
	public void testShortestPath() throws Exception {
		Graph g = new Graph(5);
		g.addEgde(0, 1, 2);
		g.addEgde(0, 2, 3);
		g.addEgde(2, 3, 1);
		g.addEgde(2, 4, 5);
		g.addEgde(3, 4, 8);
        assertEquals(10,g.shortestPath(1, 4));
	}
}
