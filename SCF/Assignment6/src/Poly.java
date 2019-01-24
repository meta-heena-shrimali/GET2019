/**
 * Implement the immutable class Poly using an array to represent single variable polynomial
 * @author HP
 */
public final class Poly {
	private final int polynomial[][];
	
	/*
	 * @param poly is an array of coefficients
	 */
	public Poly(int poly[]) throws Exception {
	
		if(poly.length==0)
			throw new Exception("Empty Polynomial Array");
		int i, count = 0;
		for( i = 0; i < poly.length ; i++ )
			if(poly[i]!=0){
				count++;
			}
		polynomial = new int[count][2];
		count=0;
		for( i = 0; i < poly.length ; i++ ){
			if(poly[i]!=0){
				polynomial[count][0]=i;
				polynomial[count][1]=poly[i];
				count++;
			}
		}
	}
	
	/*
	 * @param valueOfX is an integer value that is used as value of x in the polynomial evaluation
	 * @return returns the value of polynomial equation after evaluation 
	 */
	float evaluate(float valueOfX){
		float value=0;
		for(int i=0; i < polynomial.length ;i++)
		value += java.lang.Math.pow(valueOfX,polynomial[i][0]) * polynomial[i][1];
		return value;
	}
	
	/*
	 * @returns return the maximum degree of the polynomial equation
	 */
	int degree()
	{
		int degreeOfPolynomial=polynomial[polynomial.length-1][0];		
		return degreeOfPolynomial;
	}
	
	/*
	 * @param index is an integer value that is used to see if there exist any X^index in the equation
	 * @returns return an integer value that indicate that the power of x exist in the equation
	 */
	private int getIndexOf(int index)
	{
		int x = -1;
		for(int i = 0; i < polynomial.length ; i++ )
			if(polynomial[i][0]==index)
				x = polynomial[i][0];
		return x;
	}
	
	/*
	 * @param index is an integer value that is used to see if there exist any X^index in the equation
	 * @returns return an integer value that is the coefficient value of x at x^index in the equation
	 */
	private int getValueOf(int index)
	{
		int x = -1;
		for(int i = 0; i < polynomial.length ; i++ )
			if(polynomial[i][0]==index)
				x = polynomial[i][1];
		return x;
	}
	/*
	 * @param p1 and @param p2 are the two objects of Poly class representing two polynomial equation
	 * @returns return the addition of the two Poly objects 
	 */
	int[] addPoly(Poly p1, Poly p2){ 
		int i, maxDegree = p1.degree() > p2.degree() ? p1.degree() + 1 : p2.degree() + 1  ;
		int sum[] = new int[ maxDegree] ;
		for(i = 0; i < maxDegree ; i++){
			if(p1.getIndexOf(i) == p2.getIndexOf(i))
				sum[i] = p1.getValueOf(i) + p2.getValueOf(i);
			else if(-1 == p2.getIndexOf(i))
				sum[i] = p1.getValueOf(i);
			else if(-1 == p1.getIndexOf(i))
				sum[i] = p2.getValueOf(i);
			else
				sum[i] = 0;
		}		
		return (sum);
	}
	
	/*
	 * @param p1 and @param p2 are the two objects of Poly class representing two polynomial equation
	 * @returns return the Multiplication of the two Poly objects 
	 */
	int[] multiplyPoly(Poly p1, Poly p2){ 
		int i, j, maxDegree = (p1.degree() * p2.degree())+1 ;
		int multiply[] = new int[ maxDegree] ;
		for(i = 0; i <= p1.degree() ; i++){
			for(j = 0; j <= p2.degree() ; j++){
				{
					if(p1.getIndexOf(i) > -1 && p2.getIndexOf(j) > -1)
				
					multiply[p1.getIndexOf(i) + p2.getIndexOf(j)] += p1.getValueOf(i) * p2.getValueOf(j);
				}	
			}
		}		
		return (multiply);
	}
	
	/*
	 * prints the polynomial equation 
	 */
	void print()
	{
		int i = 0;
		for(i = polynomial.length-1 ; i >= 0 ; i--){
			if(polynomial[i][0] == 0)
				System.out.print(polynomial[i][1] + " ");
			else
				System.out.print(polynomial[i][1] + "X^" + polynomial[i][0]);
			
			if(i == 0)
				continue;
			else
				System.out.print(" + ");
		}
		System.out.println("  ");
	}
}
