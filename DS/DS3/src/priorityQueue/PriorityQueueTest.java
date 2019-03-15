package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void testNullValuePassedInConstructor() {
		 try {
			 new PriorityQueue(null,null);
		 }
		 catch (Exception e) {
			 assertEquals(" Null value passed in constructor", e.getMessage());
		 }
	}
	
	@Test
	public void testInvalidValuePassedInConstructor() {
		try {
			 new PriorityQueue(-2,-3);
		 }
		 catch (Exception e) {
			 assertEquals(" Invalid value passed in constructor", e.getMessage());
		 }
	}
	@Test
	public void testEnqueueNullvalue(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.enqueue("p1", "priority1", null);
		}
		
		catch(Exception e)
		{
			 assertEquals(" Null value passed as input", e.getMessage());
		}
		
	}
	@Test
	public void testEnqueueInvalidValue(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.enqueue("p1", "priority1", -5);
		}
		
		catch(Exception e)
		{
			 assertEquals(" Invalid value passed as priority", e.getMessage());
		}
		
	}
	@Test
	public void testEnqueueEmptyStringPassed(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.enqueue("p1", "", 2);
			
		}
		
		catch(Exception e)
		{
			 assertEquals(" Empty string passed as input", e.getMessage());
		}
		
	}
	@Test
	public void testEnqueueOverflow(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.enqueue("p1", "priority1", 1);
			p.enqueue("p2", "priority1", 1);
			p.enqueue("p3", "priority1", 1);
			p.enqueue("p4", "priority1", 1);
			p.enqueue("p5", "priority1", 1);
			p.enqueue("p6", "priority1", 1);
			
		}
		
		catch(Exception e)
		{
			 assertEquals("Queue of Priority 1 overflow ", e.getMessage());
		}
		
	}
	@Test
	public void testEnqueue() throws Exception{		
			PriorityQueue p= new PriorityQueue(5,3);
			assertTrue(p.enqueue("p1", "priority1", 1));
	}
	

	@Test
	public void testDequeueNullvalue(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.dequeue(null);
		}
		
		catch(Exception e)
		{
			 assertEquals(" Null value passed as input for priority", e.getMessage());
		}
		
	}
	@Test
	public void testDequeueInvalidValue(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.dequeue(-5);
		}
		
		catch(Exception e)
		{
			 assertEquals(" Invalid value passed as priority", e.getMessage());
		}
		
	}
	
	@Test
	public void testDequeueUnderflow(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			 p.dequeue(1);
			
		}
		
		catch(Exception e)
		{
			 assertEquals("Queue of Priority 1 underflow ", e.getMessage());
		}
		
	}
	@Test
	public void testDequeue() throws Exception{		
			PriorityQueue p= new PriorityQueue(5,3);
			Process expected=new Process("p1","priority1");
			p.enqueue("p1", "priority1", 1);
			Process actual = p.dequeue(1);
			assertEquals(expected.toString(), actual.toString());
			
	}
	@Test
	public void testTraverseNullvalue(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.traverse(null);
		}
		
		catch(Exception e)
		{
			 assertEquals(" Null value passed as input for priority", e.getMessage());
		}
		
	}
	@Test
	public void testTraverseInvalidValue(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			p.traverse(-5);
		}
		
		catch(Exception e)
		{
			 assertEquals(" Invalid value passed as priority", e.getMessage());
		}
		
	}
	
	@Test
	public void testTraverseUnderflow(){
		try{
			PriorityQueue p= new PriorityQueue(5,3);
			 p.traverse(1);
			
		}
		
		catch(Exception e)
		{
			 assertEquals("Queue of Priority 1 underflow ", e.getMessage());
		}
		
	}
}
