package com.metacube.question3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Chemical {	
	//stack for storing atom
	Stack<Character> stack = new Stack<Character>();

	/*
	 * @param d character
	 * @param time,how many time character will push
	 */
	private void pushn(Character d, int times) {
		while(times>0) {
			stack.push(d);
			times--;
		}
	}


	/*
	 * @param times, 
	 * poping elements and pushing back them in stack 
	 */
	private void pushBracket(int times) {
		List<Character> listOfCompound= new ArrayList<Character>();
		char d=this.stack.peek();
		while(d!='(') {
			d=this.stack.pop();
			if(d!='(') {
				listOfCompound.add(d); }
		}

		for(Character c:listOfCompound) {
			pushn(c,times);
		}
	}


	public int solveCompound(String formula) throws Exception {
		if( formula == null)
			throw new Exception("Null value passed as input");
		if(formula.length() == 0)
			throw new Exception("Empty string passed as input");
		stack.push(formula.charAt(0));

		for(int index=1;index<formula.length();index++) {

			char d=formula.charAt(index);

			if(Character.isDigit(d)) {
				int index2=index;

				while(index2<formula.length()) {
					if(Character.isDigit(formula.charAt(index2)))
						index2++;
					else
						break;
				}

				String s=formula.substring(index,index2);

				index=index2-1;

				int n=Integer.parseInt(s);

				char firstElement=stack.pop();
				pushn(firstElement,n);
			}

			else if(d==')') {


				int tempIndex=index+1;
				while(tempIndex<formula.length()) {
					if(Character.isDigit(formula.charAt(tempIndex)))
						tempIndex++;
					else
						break;
				}

				String s=formula.substring(index+1,tempIndex);
				int n=Integer.parseInt(s);

				index=tempIndex-1;

				pushBracket(n);
			}
			else {
				this.stack.push(d);
			}

		}

		return calculate();
	}

	


	/*
	 * @return result
	 */
	private int calculate() {
		int result=0;
		while(!this.stack.isEmpty()) {
			char d=this.stack.pop();
			if(d=='C')
				result+=12;
			else if(d=='H')
				result+=1;
			else if(d=='O')
				result+=16;
			else
				result=result;
		}
		return result;
	}

}
