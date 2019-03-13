package com.metacube.question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest {

	
	UniqueCharacter uc= new UniqueCharacter();

	 @Test
		public void testNullValueInput() {
			 try {
				 uc.numberOfUniqueCharacter(null);
			 }
			 catch (Exception e) {
				 assertEquals("Null value passed as input", e.getMessage());
			 }
		}
	 @Test
		public void testEmptyStringInput() {
			 try {
				 uc.numberOfUniqueCharacter("");
			 }
			 catch (Exception e) {
				 assertEquals("Empty string passed as input", e.getMessage());
			 }
		}
	@Test
	public void uniqueCharTest1() throws Exception {
		assertEquals(5,uc.numberOfUniqueCharacter("minal"));	
		assertEquals(3,uc.numberOfUniqueCharacter("amita"));
		assertEquals(1,uc.numberOfUniqueCharacter("mamta"));
		assertEquals(1,uc.numberOfUniqueCharacter("mamta"));
		assertEquals(5,uc.numberOfUniqueCharacter("minal"));	
		assertEquals(3,uc.numberOfUniqueCharacter("amita"));
		assertEquals(0,uc.numberOfUniqueCharacter("alphaalphaalpha"));
		assertEquals(6,uc.numberOfUniqueCharacter("alphabut"));
		assertEquals(11,uc.numberOfUniqueCharacter("alphabetagamaradiation"));
	}
	
}
