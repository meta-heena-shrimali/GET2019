import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zone {
    
    private static int count = 0;
    private String zoneName;
    private int zoneID;
    private final int maxCage;
    private boolean hasPark;
    private boolean hasCanteen;
    private ArrayList<Cage> cageList = new ArrayList<Cage>();
    private String category;
    private Scanner sc = new Scanner(System.in);
    
    public Zone(String name ,boolean hasPark, Boolean hasCanteen, int maxCage ,String category){
        count++;
        zoneID = count;
        this.zoneName = name;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
        this.maxCage = maxCage;
        this.category = category;
    }
    
    /*
     *@param animalToBeAdded of type Animal which is to be added to the cage
     *@returns true if cage is of the same animal type and the cage is not full   
     */
    public boolean addAnimalToCage(Animal animalToBeAdded){
        boolean cagefound = false;
            for(Cage x:getCageList()) {
                if(x.getAnimalType() == animalToBeAdded.getType() && (! x.isFull()))  {
                    x.addAnimal(animalToBeAdded);
                     cagefound = true;
                     return true;
                }
            }
            if(! cagefound) {
                System.out.println("Cage not Found :");
                if(addCage(animalToBeAdded.getType()))
                    if(addAnimalToCage(animalToBeAdded))
                        return true;
                else
                    return false;
            }
        return false;
    }
    
    public int getZooID() {  
    	return zoneID; 
   	}
    
    public boolean hasPark() {
    	return hasPark; 
   	}
    
    public boolean hasCanteen() {
    	return hasCanteen; 
    }
    
    public String getCategory(){    
    	return category; 
    }
    
    /*
     * @param type of String type to add cage of specified type
     * @returns true if zone cage capacity is not reached
     */
    public boolean addCage(String type){       
        if(maxCage != getCageList().size()){
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
    
    public void display(){
        System.out.println("details Of Zone :" +zoneID +"  "+zoneName);
        System.out.println("Cage id  cage Animal Type  Cage Capacity  No of Animal In Cage" );
        for(Cage c: cageList)
            System.out.println(c.getCageId() +" "+ c.getAnimalType() +" "+ c.getCapacity() +" " +c.getNoOfAnimal());
    }


}
