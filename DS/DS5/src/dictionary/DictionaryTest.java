package dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	BST bst ;
	@Test
	public void testNullValuePassedAsJsonFilePathInConstructor() {
		 try {
			 new BST(null);
		 }
		 catch (Exception e) {
			 assertEquals(" Null Json file path passed ", e.getMessage());
		 }
	}
	
	@Test
	public void testEmptyJsonFilePathPassedInConstructor() {
		 try {
			 new BST("");			 
		 }
		 catch (Exception e) {
			 assertEquals(" Empty Json file path passed ", e.getMessage());
		 }
	}
	
	@Test
	public void testNullValuePassedInAddNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").add(null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as node", e.getMessage());
		 }
	}
	
	@Test
	public void testNullValuePassedInDeleteNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").delete(null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as key", e.getMessage());
		 }
	}
	
	@Test
	public void testEmptyValuePassedInDeleteNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").delete("");
		 }
		 catch (Exception e) {
			 assertEquals("empty value passed as key", e.getMessage());
		 }
	}
	
	@Test
	public void testNullValuePassedInGetValueNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").getValue(null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as key", e.getMessage());
		 }
	}
	
	@Test
	public void testEmptyValuePassedInGetValueNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").getValue("");
		 }
		 catch (Exception e) {
			 assertEquals("empty value passed as key", e.getMessage());
		 }
	}
	@Test
	public void testNullValuePassedInSortNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").getSortedList(null, null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as key", e.getMessage());
		 }
	}
	
	@Test
	public void testEmptyValuePassedInSortNode() {
		 try {
			 new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json").getSortedList("", "");
		 }
		 catch (Exception e) {
			 assertEquals("empty value passed as key", e.getMessage());
		 }
	}
	
	@Test
	public void testGetSortedList() throws Exception {
		 bst = new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json");
		String expected = "[abrupt : sudden, boycott : refuse, cogent : weighty, demolish : destroy, embrace  : accept, fragile : damagable, gracious : calm , hectic : busy, ignite : burning, jealous : careful]";
		assertEquals(expected, bst.getSortedList().toString());
		
	}
	
	@Test
	public void testGetSortedListBoundKey() throws Exception {
		bst = new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json");
		
		String exp1="[boycott : refuse, cogent : weighty, demolish : destroy]";
		assertEquals(exp1, bst.getSortedList("boycott", "demolish").toString());
		
	}
	
	@Test
	public void testGetValue() throws Exception {
		bst = new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json");
		
		assertEquals("burning", bst.getValue("ignite"));
		
	}
	
	@Test
	public void testDelete() throws Exception {
		bst = new BST("C:\\Users\\HP\\workspace\\DS5\\src\\dictionary\\map.json");
		
		assertTrue(bst.delete("fragile"));
		assertFalse(bst.delete("glorious"));
		assertTrue(bst.delete("demolish"));
	}

}
