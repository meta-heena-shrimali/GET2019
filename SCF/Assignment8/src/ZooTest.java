import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTest {
	//test null value input in parameter name of method addAnimal()
	@Test
	public void testNullValueInParameterNameOfAnimal() {
		 try {
			Zoo.addAnimal(null,2,30.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Null Value Passed In Parameter Name", e.getMessage());
		 }
	}
	
	//test empty string input in parameter name of method addAnimal()
	@Test
	public void testEmptyNameOfAnimal() {
		 try {
			 Zoo.addAnimal("",2,30.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Empty String Passed In Parameter Name", e.getMessage());
		 }
	}
	
	//test null value input in parameter age of method addAnimal()
	@Test
	public void testNullValueInParameterAgeOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",null,30.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Null Value Passed In Parameter Age", e.getMessage());
		 }
	}
	
	//test zero value input in parameter age of method addAnimal()
	@Test
	public void testZeroValueInParameterAgeOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",0,30.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Zero Value Passed In Parameter weight", e.getMessage());
		 }
	}
	
	//test invalid input in parameter age of method addAnimal()
	@Test
	public void testInvalidValueInParameterAgeOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",500,30.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Invalid Value Passed In Parameter Age", e.getMessage());
		 }
	}
	
	//test null value input in parameter weight of method addAnimal()
	@Test
	public void testNullValueInParameterWeightOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",2,null,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Null Value Passed In Parameter weight", e.getMessage());
		 }
	}
	
	//test zero value input in parameter weight of method addAnimal()
	@Test
	public void testZeroValueInParameterWeightOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",2,0.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Zero Value Passed In Parameter Weight", e.getMessage());
		 }
	}
	
	//test Invalid value input in parameter weight of method addAnimal()
	@Test
	public void testInvalidValueInParameterWeightOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",5,-3000.0f,"Lion");
		 }
		 catch (Exception e) {
			 assertEquals("Negative Value Passed In Parameter Weight", e.getMessage());
		 }
	}
	
	//test null value input in parameter type of method addAnimal()
	@Test
	public void testNullValueInParameterTypeOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",2,30.0f,null);
		 }
		 catch (Exception e) {
			 assertEquals("Null Value Passed In Parameter Type", e.getMessage());
		 }
	}
	
	//test empty string input in parameter type of method addAnimal()
	@Test
	public void testEmptyTypeOfAnimal() {
		 try {
			 Zoo.addAnimal("alpha",2,30.0f,"");
		 }
		 catch (Exception e) {
			 assertEquals("Empty String Passed In Parameter Type", e.getMessage());
		 }
	}
	
	//test Invalid value input in parameter name of method addAnimal()
	@Test
	public void testInvalidValueInParameterTypeOfAnimal() {
		 try {
			Zoo.addAnimal("alpha",5,30.0f,"Alaska");
		 }
		 catch (Exception e) {
			 assertEquals("Invalid Value Passed In Parameter Type", e.getMessage());
		 }
	}
	
	//test null value input in parameter category of method createZone()
	@Test
	public void testNullValueInParameterCategoryOfAnimalInZone() {
		 try {
			 Zoo.createZone(null);
		 }
		 catch (Exception e) {
			 assertEquals("Null Value Passed In Parameter Category", e.getMessage());
		 }
	}
	
	//test empty string input in parameter category of method createZone()
	@Test
	public void testEmptyCategoryOfAnimal() {
		 try {
			 Zoo.createZone("");
		 }
		 catch (Exception e) {
			 assertEquals("Empty String Passed In Parameter Category", e.getMessage());
		 }
	}
	
	//test invalid input in parameter category of method createZone()
	@Test
	public void testInvalidValueInParameterCategoryOfAnimal() {
		 try {
			 Zoo.createZone("Alasak");
		 }
		 catch (Exception e) {
			 assertEquals("Invalid Value Passed In Parameter Category", e.getMessage());
		 }
	}
	
	//test for all positive inputs in addAnimal()
	@Test
	public void testForAllPositiveInputToAddAnimal() throws Exception {
		assertTrue( Zoo.addAnimal("alpha",5,30.0f,"Snake"));
	}
	
	//test for positive inputs in createZone()
	@Test
	public void testForAllPositiveInputToCreateZone() throws Exception {
		assertTrue( Zoo.createZone("Mammal"));
	}
	
}
