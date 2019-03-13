
/*
 * This class defines all present variables in a term of multivariate
 * polynomial.
 * 
 */
public  class Variable {
	private char var;
	private int power;

	public Variable(char variable, int power) {
		this.var = variable;
		this.power = power;
	}

	public char getVariable() {
		return var;
	}

	public void setVariable(char variable) {
		this.var = variable;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	
	
}