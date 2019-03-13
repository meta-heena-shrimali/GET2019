package Question2;


import java.util.Stack;


public class InfixToPostfix {
	String infixExp;
	Stack<String> stack = new Stack<String>();

	public InfixToPostfix(String infixExp) {
		this.infixExp = infixExp;
	}

	/*
	 * Method to find the postfix expression
	 * 
	 * @return postfix expression
	 * 
	 * @throws StackException
	 */
	String findPostfixExpression() {
		StringBuilder postfix = new StringBuilder();
		String infix[] = infixExp.split("\\s+");

		for (int i = 0; i < infix.length; i++) {

			// add operand to the expression
			if (infix[i].matches("[a-z]*[A-Z]*[0-9]*")) {
				postfix.append(infix[i]);
			}

			// if ( in encounter add it to the stack
			if ("(".equals(infix[i])) {
				stack.push(infix[i]);
			}
			// if ) is encounter pop operators from stack till ) encounter
			else {
				if (")".equals(infix[i]) && !(stack.isEmpty())) {

					while (!(stack.isEmpty()) && !("(".equals(stack.peek()))) {
						postfix.append(stack.pop());
					}
					if (!(stack.isEmpty()) && "(".equals(stack.peek())) {
						stack.pop();
					} else if (stack.isEmpty()) {

						System.err.println("Empty stack");
						throw new AssertionError(
								"invalid expression: open paranthasis not found for close paranthasis");
					}

				} else {
					if (isOperator(infix[i])) {
						if (stack.isEmpty()) {
							stack.push(infix[i]);
						} else {
							if (((getPrecedence(infix[i])) < (getPrecedence(stack
									.peek())))) {
								stack.push(infix[i]);
							} else {
								while (!(stack.isEmpty())
										&& (getPrecedence(infix[i]) >= getPrecedence(stack
												.peek()))
										&& !("(".equals(stack.peek()))) {
									postfix.append(stack.pop());
								}
								stack.push(infix[i]);
							}
						}

					}

				}
			}
		}
		while (!(stack.isEmpty())) {
			if ("(".equals(stack.peek())) {
				throw new AssertionError(
						"invalid expression: close paranthasis not found for open paranthasis");
			}
			postfix.append(stack.pop());
		}
		return postfix.toString();

	}

	/*
	 * private helper function to check if a current token is an operator or not
	 * 
	 * @param checkToken, current token to check
	 * 
	 * @return true if a token is operator else false
	 */
	private boolean isOperator(String checkToken) {
		switch (checkToken) {
		case "!":
		case "*":
		case "/":
		case "+":
		case "-":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
		case "(":
		case ")":
			return true;
		default:
			return false;
		}
	}

	/*
	 * private helper function to calculate the precedence of a operator
	 * 
	 * @param operator, input operator
	 * 
	 * @return precendence of the operators
	 */
	private int getPrecedence(String operator) {
		switch (operator) {
		case "!":
		case "(":
		case ")":
			return 1;
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "==":
		case "!=":
			return 5;
		case "&&":
			return 6;
		case "||":
			return 7;
		}
		return -1;
	}
}
