/**
 * Design a class to implement following mathematical problems using recursion.
    LCM
    HCF
 * @author Admin
 *
 */
public class LcmHcf {
	
	/*
	 * @param num1 and @param num2 are two positive integers whose hcf is to be calculated
	 * @return returns hcf of num1 and num2
	 */
	public int findHcf(int num1, int num2) throws Exception {
		if(num2==0)
			return num1;
		else if(num1==0&&num2==0)
			throw new Exception("Divide By Zero");
		return findHcf(num2,num1%num2);  
	}
	
	/*
	 * @param num1 and @param num2 are two positive integers whose lcm is to be calculated
	 * @return returns lcm of num1 and num2
	 */
	public int findLcm(int num1, int num2) throws Exception {
		int hcf=(int)findHcf(num1,num2);
		if(hcf==0)
			throw new Exception("Divide By Zero");
		return ((num1*num2)/hcf);  
	}
}

