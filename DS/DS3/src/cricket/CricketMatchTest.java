package cricket;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class CricketMatchTest {
	
	@Test
	public void testNullValuePassedInConstructor() {
		 try {
			 new CricketMatch(null,null);
		 }
		 catch (Exception e) {
			 assertEquals("null value passed as parameter", e.getMessage());
		 }
	}
	
	@Test
	public void testInvalidValuePassedInConstructor() {
		try {
			 new CricketMatch(-4,-6);
		 }
		 catch (Exception e) {
			 assertEquals("Balls cannot be negative", e.getMessage());
		 }
	}
	@Test
	public void testPassNullValueInAddBowler(){
		try{
			CricketMatch cm= new CricketMatch(15,3);
			cm.addBowler(null , null);
		}
		
		catch(Exception e)
		{
			 assertEquals(" null value passed in as Bowler arguments ", e.getMessage());
		}
		
	}
	@Test
	public void testEmptyStringvalueInAddBowler(){
		try{
			CricketMatch cm= new CricketMatch(15,3);
			cm.addBowler("", 6);
		}
		
		catch(Exception e)
		{
			 assertEquals(" empty string passed for bowler name", e.getMessage());
		}
		
	}
	@Test
	public void testNegativeValueInAddBowler(){
		try{
			CricketMatch cm= new CricketMatch(15,3);
			cm.addBowler("a", -6);
		}
		
		catch(Exception e)
		{
			 assertEquals(" invalid balls entered for bowlers ", e.getMessage());
		}
		
	}
	@Test
	public void testAddBowlerMoreThanMaximumBowlers(){
		try{
			CricketMatch cm= new CricketMatch(15,3);
			cm.addBowler("a", 7);
			cm.addBowler("b", 4);
			cm.addBowler("c", 8);
			cm.addBowler("d", 10);
		}
		
		catch(Exception e)
		{
			 assertEquals("Cannot add more bowlers limit exceeded", e.getMessage());
		}
		
	}
	
	@Test
	public void testTotalBowlsOfBowlersLessThanBowlToBePlayed(){
		try{
			CricketMatch cm= new CricketMatch(15,3);
			cm.addBowler("a", 1);
			cm.addBowler("b", 4);
			cm.addBowler("c", 8);
			cm.chooseBowler();
		}
		
		catch(Exception e)
		{
			 assertEquals("Number of balls to be thrown is less than number of balls to be played by the player", e.getMessage());
		}
		
	}
	
	@Test
	public void testBowlerOrder() throws Exception{
		
			CricketMatch cm= new CricketMatch(12,3);
			cm.addBowler("a", 6);
			cm.addBowler("b", 9);
			cm.addBowler("c", 3);
			List<Bowler> actualResult =cm.chooseBowler();
			
			List<Bowler> expectedResult = new ArrayList<Bowler>();
			expectedResult.add(new Bowler("b", 9));			
			expectedResult.add(new Bowler("a", 3));
			for (int count = 0; count < actualResult.size(); count++) 
			{
				assertEquals(expectedResult.get(count).getName(),actualResult.get(count).getName());
				assertEquals(expectedResult.get(count).getNumOfBalls(),actualResult.get(count).getNumOfBalls());
			}
		
	}
	
}
