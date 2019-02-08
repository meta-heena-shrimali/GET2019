/**
 * implements a class Zone representing Zone in a zoo 
 * each zone can accommodate specific category of animal like mammal, reptile etc.
 * each zone can have attributes like hasCanteen ,hasPark 
 * and Cage class as composition
 *  @author Admin
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zone {
	//count is used to assign Internal id automatically.
    private static int count = 0;
    private int zoneID;
    private final int maximumCage;
    private boolean hasPark;
    private boolean hasCanteen;
    private ArrayList<Cage> cageList = new ArrayList<Cage>();
    private String categoryOfAnimalSupported;
    private Scanner sc = new Scanner(System.in);
    
    /*
     * @param hasPark of type boolean is true if Zone has park in it
     * @param hasCanteen of type boolean is true if Zone has canteen in it
     * @param maxcage of type integer represents the maximum no. of cages the zone can have
     * @param category of type String represents the Category of animal supported by the zone
     */
    public Zone(boolean hasPark, Boolean hasCanteen, int maxCage ,String category){
        count++;
        zoneID = count;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
        this.maximumCage = maxCage;
        this.categoryOfAnimalSupported = category;
    }
    
    /*
     *@param animalToBeAdded of type Animal which is to be added to the cage
     *@returns true if cage is of the same animal type and the cage is not full   
     */
    public boolean addAnimalToCage(Animal animalToBeAdded){
        boolean cagefound = false;
            for(Cage cage:getCageList()) {
            	//to check if cage of animal exist with capacity not full 
                if(cage.getAnimalType() == animalToBeAdded.getAnimalType() && (! cage.isFull()))  {
                    cage.addAnimal(animalToBeAdded);
                    cagefound = true;
                    return true;
                }
            }
            if(! cagefound) {
            	//if there is no cage for the animal then add a new cage and then add the animal to it
                if(addCage(animalToBeAdded.getAnimalType()))
                    if(addAnimalToCage(animalToBeAdded))
                        return true;
                //in case the zone has reached its maximum cage capacity return false 
                else
                    return false;
            }
        return false;
    }
    
    /*
     * @returns return zoneID of type integer
     */
    public int getZooID() {  
    	return zoneID; 
   	}
    
    /*
     * @returns return boolean value as true if zone has park in it
     */
    public boolean hasPark() {
    	return hasPark; 
   	}
    
    /*
     * @returns return boolean value as true if zone has canteen in it
     */
    public boolean hasCanteen() {
    	return hasCanteen; 
    }
    
    /*
     * @returns return String value as category of animal supported by the cage
     */
    public String getCategoryOfAnimalSupported(){    
    	return categoryOfAnimalSupported; 
    }
    
    /*
     * @param type of String type to add cage of specified type
     * @returns true if zone cage capacity is not reached
     */
    public boolean addCage(String type){       
        if(maximumCage != getCageList().size()){
            System.out.println("Enter the Capacity Of New Cage :");
            int capacity = getValidInteger();
            Cage c = new Cage(capacity,type);
            getCageList().add(c);
            return true;
        }
        System.out.println("zone have reaches maximum no of cage Capacity");
        System.out.println("please Create a new Zone");
      
        return false;
        
    }
    
    
    /*
     * @return :an integer passed by user with exception handling
     */
    public int getValidInteger(){
        int value=0;
        boolean continueInput=true; 
        do {
            try{
                value=sc.nextInt();
                continueInput = false;
                }
            catch (InputMismatchException ex) {
                System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                sc.nextLine();
                }
            }
        while(continueInput);
        return value;
    }

    /*
     *@returns cagelist  of ArrayList Type
     */
    public ArrayList<Cage> getCageList() {
        return cageList;
    }
    
    public void displayZone(){
        System.out.println("details Of Zone :" +zoneID);
        System.out.println("Cage id  cage Animal Type  Cage Capacity  No of Animal In Cage" );
        for(Cage c: cageList)
            System.out.println(c.getCageId() +" "+ c.getAnimalType() +" "+ c.getCapacity() +" " +c.getNoOfAnimal());
    }


}
