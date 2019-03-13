import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Console {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
        
        File file = new File("src/input.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(file));
        NestedListOperation nestedOperations = new NestedListOperation(jsonObject);
        nestedOperations.createNestedList();

        int choice = 0;
        long result;
        while (choice != 9) {
            System.out.println("1 Get Sum");
            System.out.println("2 Get Max");
            System.out.println("3 find Value");
            System.out.println("9 Exit");
            
            choice = getValidInteger();
            switch (choice) {
            case 1:
                result = nestedOperations.sumOfAllValues();
                System.out.println("sum : " + result);
                break;
            case 2:
                result = nestedOperations.largestValue();
                System.out.println("max : " + result);
                break;
            case 3:
                System.out.println("Enter the value to be searched: ");
                int value = getValidInteger();
                if (nestedOperations.searchValue(value)) {
                    System.out.println(value + " Found!!!");
                } else
                    System.out.println(value + " Not found!!!");
                break;
            case 9:
                choice = 9;
                break;
            default:
                System.out.println("Enter a Valid choice");
                break;
            }
        }
        sc.close();

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

}
