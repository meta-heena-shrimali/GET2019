import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	LinkedList list= new LinkedList();
	@Test
	public void testLinkedListNullValuePushed() {
		 try {
			 new LinkedList().push(null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed node can't be created", e.getMessage());
		 }
	}
	
	@Test
	public void testLinkedListTraverseEmptyList() throws Exception {
		 try {
			 new LinkedList().traverse();
		 }
		 catch (Exception e) {
			 assertEquals("Empty List can't traverse", e.getMessage());
		 }
	}

	@Test
	public void testLinkedListNullValueInputToCreateLoop() throws Exception {
		 try {
			 new LinkedList().createLoop(null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed loop can't be created ", e.getMessage());
		 }
	}
	@Test
	public void testLinkedListDetectLoopInEmptyList() throws Exception {
		 try {
			 new LinkedList().detectLoop();
		 }
		 catch (Exception e) {
			 assertEquals("Empty List can't detect loop", e.getMessage());
		 }
	}
	@Test
	public void testLinkedListCreateLoop() throws Exception {
			 list.push(10);
			 list.push(20);
			 list.push(30);
			 list.push(40);
			 assertTrue(list.createLoop(20));
		
	}
	@Test
	public void testLinkedListCreateLoopWhenLoopExist(){
			try{
				 list.push(10);
				 list.push(20);
				 list.push(30);
				 list.push(40);
				 list.createLoop(20);
				 list.createLoop(30);
			}
			catch(Exception e)
			{
				assertEquals("loop already exist", e.getMessage());
			}
	}
	@Test
	public void testLinkedListCreateLoopWithDataNotInList() throws Exception {
			try{
				 list.push(10);
				 list.push(20);
				 list.push(30);
				 list.push(40);
				 list.createLoop(15);
			}
			catch(Exception e)
			{
				assertEquals("No Such Element In List before the last element", e.getMessage());
			}
	}
	@Test
	public void testLinkedListDetectLoopWhenNoLoopExist() throws Exception {
			 list.push(10);
			 list.push(20);
			 list.push(30);
			 list.push(40);
			 assertFalse(list.detectLoop());	
	}
	@Test
	public void testLinkedListDetectLoopWhenLoopExist() throws Exception {
			 list.push(10);
			 list.push(20);
			 list.push(30);
			 list.push(40);
			 list.createLoop(20);
			 assertTrue(list.detectLoop());	
	}
	
}
