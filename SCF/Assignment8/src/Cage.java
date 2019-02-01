import java.util.ArrayList;

public class Cage {
    
    private static int count = 0;
    private int cageId;
    private final int cageCapacity;
    private String animalType;
    private int noOfAnimalInCage;
    private ArrayList<Animal> animalList = new ArrayList<Animal>();
    
    public Cage(int capacity, String animal){
        count++;
        this.cageId = count;
        this.cageCapacity = capacity;
        this.animalType = animal; 
        this.noOfAnimalInCage = 0;
    }
    
    /*
     * @returns true if no. of animals in the cage has reached cage's maximum capacity
     */
    public Boolean isFull(){
        if(cageCapacity == noOfAnimalInCage)
            return true;
        return false;
    }
    
    /*
     * @param toBeAdded of type Animal which has to be added to the cage
     * @returns true if the animal type is same as in the cage and cage has nnot reached its maximum capacity   
     */
    public boolean addAnimal(Animal toBeAdded){
        if(cageCapacity != noOfAnimalInCage && animalType == toBeAdded.getType()){
            getAnimalList().add(toBeAdded);
            noOfAnimalInCage++;
            return true;
        }
        else
            return false;
    }

    public int getCageId() {
    	return cageId; 
    }
    
    public String getAnimalType() {
    	return animalType;   
    }

    public int getCapacity(){   
    	return cageCapacity;    
    }
    
    public int getNoOfAnimal(){    
    	return noOfAnimalInCage;   
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }
}
