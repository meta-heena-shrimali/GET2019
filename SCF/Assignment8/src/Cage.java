/**
 * implements a class Cage representing cage in a given zone  
 * having Zone class as the parent class.
 * and animal class as composition
 * each cage can have specific type of animal like sparrow, lion etc.
 *  @author Admin
 */
import java.util.ArrayList;

public class Cage {
	
	//count is used to assign Internal id automatically.
    private static int count = 0;
    private final int cageId;
    private final int cageMaximumCapacity;
    private String typeOfAnimalInCage;
    private int noOfAnimalInCage;
    private ArrayList<Animal> animalList = new ArrayList<Animal>();
    
    /*
     * @param capacity is the maximum capacity of the cage - Integer type
     * @param animalType is the type of animal which can be allocated in the cage - String type
     */
    public Cage(int capacity, String animalType){
        count++;
        this.cageId = count;
        this.cageMaximumCapacity = capacity;
        this.typeOfAnimalInCage = animalType; 
        this.noOfAnimalInCage = 0;
    }
    
    /*
     * @returns true if no. of animals in the cage has reached cage's maximum capacity - boolean type
     */
    public Boolean isFull(){
        if(cageMaximumCapacity == noOfAnimalInCage)
            return true;
        return false;
    }
    
    /*
     * @param animalToBeAdded of type Animal which has to be added to the cage
     * @returns true if the animal type is same as in the cage and cage has not reached its maximum capacity   
     */
    public boolean addAnimal(Animal animalToBeAdded){
        if(cageMaximumCapacity != noOfAnimalInCage && typeOfAnimalInCage == animalToBeAdded.getAnimalType()){
        	getAllAnimalsInCage().add(animalToBeAdded);
            noOfAnimalInCage++;
            return true;
        }
        else
            return false;
    }

    /*
     * @returns return cage id - type integer
     */
    public int getCageId() {
    	return cageId; 
    }
    
    /*
     * @returns return type of animal that can be allocated in the cage - String type
     */
    public String getAnimalType() {
    	return typeOfAnimalInCage;   
    }

    /*
     * @returns return the maximum capacity of the cage - Integer type
     */
    public int getCapacity(){   
    	return cageMaximumCapacity;    
    }
    
    /*
     * @returns return the no. of animals currently in cage - Integer type
     */
    public int getNoOfAnimal(){    
    	return noOfAnimalInCage;   
    }

    /*
     * @returns Arraylist of Animal type that is the list of all animals in cage 
     */
    public ArrayList<Animal> getAllAnimalsInCage() {
        return animalList;
    }
}
