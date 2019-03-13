

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int choice = 0;
       
        List<Term> termList = new ArrayList<Term>();

        while (choice != 9) {
            System.out.println("1 Enter new term ");
            System.out.println("2 visualize");
            System.out.println("9 Exit");

            choice = getValidInteger();

            switch (choice) {

            case 1:
                System.out.println("coefficient (double): ");
                double coefficient = getValidDouble();
                System.out.println("variable (character): ");
                char var=getValidVariable();
                System.out.println("Power (int): ");
                int power = getValidInteger();
                
                Variable variable = new Variable(var++, power);
                Term term = new Term(coefficient, variable);
                termList.add(term);
                break;
            case 2:
                MultiVariate multiVariateObject = new MultiVariate(termList);
                System.out.println(multiVariateObject.visualisedMultivariatePolynomial());
                break;
            case 9:
                choice = 9;
                break;
            default:
                System.out.println("Enter a Valid Choice");
            }
        }
    }
    /*
     * @return an Character passed by user with exception handling
     */
    private static char getValidVariable() {
    	 char var = 0;
         boolean continueInput = true;
         do {
             try {
            	 var = sc.next().trim().charAt(0);
            	 if(!Character.isAlphabetic(var))
            		 throw new Exception("Input mismatch");
                 continueInput = false;
             } catch (Exception ex) {
                 System.out.println("Try again. (Incorrect input: an single character (a-z) is required)");
                 sc.nextLine();
             }
            
         } while (continueInput);
         return var;
	}

	/*
     * @return an integer passed by user with exception handling
     */
    public static int getValidInteger() {
        int value = 0;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextInt();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }


    /*
     * @return an double passed by user with exception handling
     */
    public static double getValidDouble() {
        double value = 0;
        boolean continueInput = true;
        do {
            try {
                value = sc.nextDouble();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect double: an double is required)");
                sc.nextLine();
            }
        } while (continueInput);
        return value;
    }
}
