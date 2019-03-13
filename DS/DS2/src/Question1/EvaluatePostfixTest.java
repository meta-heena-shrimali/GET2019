package Question1;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvaluatePostfixTest {
  
	@Test
	public void testSingleValueDigit(){
		EvaluatePostfix evaluate = new EvaluatePostfix("2 3 1 * + 9 -");
		double result = evaluate.evaluatePostfixExpression();
		assertEquals(-4, result,0);
	}
		
	@Test
	public void testMultiValueDigit()   {
		EvaluatePostfix evaluate = new EvaluatePostfix("100 200 + 2 / 5 * 7 +");
		double result = evaluate.evaluatePostfixExpression();
		assertEquals(757,result,0);
	}
	
	@Test(expected = AssertionError.class)
	public void testDivideByZero()   {
		EvaluatePostfix evaluate = new EvaluatePostfix("100 200 + 0 / 5 * 7 +");
		double result = evaluate.evaluatePostfixExpression();
	}
		
	@Test(expected = AssertionError.class)
	public void testInvalidOperator()   {
		EvaluatePostfix evaluate = new EvaluatePostfix("100 200 + 2 / 5 * 7 &");
		double result = evaluate.evaluatePostfixExpression();
	}
}
