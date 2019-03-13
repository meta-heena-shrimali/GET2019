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
			 assertEquals("Cant traverse empty list", e.getMessage());
		 }
	}

	@Test
	public void testLinkedListEmptyListRotation() throws Exception {
		 try {
			 new LinkedList().rotate(2,4,5);
		 }
		 catch (Exception e) {
			 assertEquals("Cant rotate empty list", e.getMessage());
		 }
	}

	@Test
	public void testLinkedListRotationWithOneNode(){
			try{
				 list.push(10);
				 list.rotate(1, 1, 1);
			}
			catch(Exception e)
			{
				 assertEquals("Cant rotate only one node in the list", e.getMessage());
			}
	}
	@Test
	public void testLinkedListNullValueInputToRotate() throws Exception {
			try{
				 list.push(10);
				 list.push(20);
				 list.push(30);
				 list.push(40);
				 list.rotate(null,null,null);
			}
			catch(Exception e)
			{
				assertEquals("Null value passed as parameter in method rotate", e.getMessage());
			}
	}
	@Test
	public void testLinkedListInvalidParameterForSublist() throws Exception {
		try{
			 list.push(10);
			 list.push(20);
			 list.push(30);
			 list.push(40);
			 list.rotate(-4,20,5);
		}
		catch(Exception e)
		{
			assertEquals("Out Of Bound Left Right Parameter For SubList", e.getMessage());
		}	
	}
	@Test
	public void testLinkedListInvalidParameterForRotations() throws Exception {
		try{
			 list.push(10);
			 list.push(20);
			 list.push(30);
			 list.push(40);
			 list.rotate(2,4,-3);
		}
		catch(Exception e)
		{
			assertEquals("invalid number of rotations", e.getMessage());
		}	
	}
	@Test
	public void testLinkedListRotate() throws Exception {
			 list.push(10);
			 list.push(20);
			 list.push(30);
			 list.push(40);
			 list.push(50);
			 list.push(60);
			 
			 list.rotate(2,5,2);
			 String result=list.getList();
			 assertEquals("null60 --> 30 --> 20 --> 50 --> 40 --> 10 --> ", result);
	}

}
