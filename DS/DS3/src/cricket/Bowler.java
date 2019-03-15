package cricket;

public class Bowler implements Comparable<Bowler> {

	private String name;
	private int numOfBalls;

	public Bowler(String name, Integer balls) throws Exception {
		
		this.name = name;
		this.numOfBalls = balls;
	}

	public String getName() {
		return name;
	}	

	public int getNumOfBalls() {
		return numOfBalls;
	}

	public void setNumOfBalls(int numOfBalls) {
		this.numOfBalls = numOfBalls;
	}

	@Override
	public int compareTo(Bowler o) {
		
		return numOfBalls - o.getNumOfBalls();
	}
}
