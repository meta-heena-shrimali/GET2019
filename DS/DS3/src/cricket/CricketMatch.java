package cricket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CricketMatch {

	private List<Bowler> bowlersList = new ArrayList<Bowler>();
	private List<Bowler> bowlerOrder = new ArrayList<Bowler>();
	private int numOfBallsToBePlayed;
	private int numOfBowlers;
	Scanner s=new Scanner(System.in);

	/*
	 * @param numOfBallsToBePlayed, number of balls to be played by the player
	 * @param numOfBowlers, total number of the bowlers
	 */
	public CricketMatch(Integer numOfBallsToBePlayed, Integer numOfBowlers)throws Exception
	{
		if( numOfBallsToBePlayed == null || numOfBowlers == null)
			throw new Exception("null value passed as parameter");
		if (numOfBallsToBePlayed <= 0 || numOfBowlers <= 0) 
			throw new Exception("Balls cannot be negative"); 
		this.numOfBallsToBePlayed = numOfBallsToBePlayed;
		this.numOfBowlers = numOfBowlers;
		
	}


	/*
	 * Method to add bowlers to the bowlersList
	 * @param bowler object consisting of bowler's details
	 * @throws BowlerOutOfBoundException if number of bowlers exceed the given size
	 */
	public void addBowler(String name, Integer balls) throws Exception {
		if( name == null || balls == null )
			throw new Exception(" null value passed in as Bowler arguments ");
		if( name.length() == 0)
			throw new Exception(" empty string passed for bowler name");
		if( balls <= 0 )
			throw new Exception(" invalid balls entered for bowlers ");
		Bowler bowler= new Bowler(name, balls);
		if (bowlersList.size() < this.numOfBowlers) {
			this.bowlersList.add(bowler);
		} else {
			throw new Exception("Cannot add more bowlers limit exceeded");
		}
	}

	/*
	 * Method to make bowlers order so as to win the match
	 * @return the ordered list of the bowlers
	 * 
	 */
	public List<Bowler> chooseBowler() throws Exception {

		int totalBalls = totalBalls();
		if (totalBalls < numOfBallsToBePlayed) {
			throw new Exception("Number of balls to be thrown is less than number of balls to be played by the player");
		}
		
		while (numOfBallsToBePlayed != 0) 
		{
			int turn = maxBalls();
			Bowler bowler = bowlersList.get(turn);
			if(numOfBallsToBePlayed >= bowler.getNumOfBalls())
			{	
				bowlerOrder.add(new Bowler(bowler.getName(),bowler.getNumOfBalls()));
				numOfBallsToBePlayed -= bowler.getNumOfBalls();
				bowler.setNumOfBalls(0);
			}
			else
			{
				bowlerOrder.add(new Bowler(bowler.getName(), numOfBallsToBePlayed));
				bowler.setNumOfBalls(bowler.getNumOfBalls() - numOfBallsToBePlayed);
				numOfBallsToBePlayed=0;
			}
		}
		return bowlerOrder;
	}

	/*
	 * find the total sum of the balls of all the bowlers
	 * @return totalBalls
	 */
	private int totalBalls() {
		int totalBalls = 0;
		for (Bowler bowler : bowlersList) {
			totalBalls += bowler.getNumOfBalls();
		}
		return totalBalls;
	}

	/*
	 * find the index of the bowler who has maximum balls left to bowl
	 * @return index of the bowler
	 */
	private int maxBalls() {
		int max = 0;
		int index = 0;
		int count = 0;
		for (Bowler bowler : bowlersList) {
			if (max < bowler.getNumOfBalls())
			{
				max = bowler.getNumOfBalls();
				index = count;
			}
			count++;
		}
		return index;
	}
}
