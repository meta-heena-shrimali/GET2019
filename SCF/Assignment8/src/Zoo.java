/**
 * Implement a Zoo Management System where all the animals will be allocated to zones
 * based on their characteristics. 
 * @author Admin
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private static Scanner sc = new Scanner(System.in);
    private static List<Zone> zoneList = new ArrayList<Zone>();
 
    /*
     *  method to add animal to the zone and cage
     * @returns true if animal is added to the zone and allocated a cage  
     */
    public static boolean addAnimal(String name,Integer age,Float weight,String type) throws Exception {
       Animal newAnimal = null;
       boolean zoneExist = false;
       if(name == null){
    	   throw new NullPointerException("Null Value Passed In Parameter Name");   
       }
       else if(name.length() == 0){
    	   throw new Exception("Empty String Passed In Parameter Name");   
       }
       else if(age == null){
    	   throw new NullPointerException("Null Value Passed In Parameter Age");
       }
       else if(age == 0){
    	   throw new Exception("Zero Value Passed In Parameter Age");
       }
       else if(age < 0 || age > 200){ 
    	   throw new Exception("Invalid Value Passed In Parameter Age");
       }
       else if(weight == null){ 
    	   throw new NullPointerException("Null Value Passed In Parameter weight");
       }
       else if(weight == 0){ 
    	   throw new Exception("Zero Value Passed In Parameter weight");
       }
       else if(weight < 0){ 
    	   throw new Exception("Negative Value Passed In Parameter weight");
       }
       else if(type == null){
    	   throw new NullPointerException("Null Value Passed In Parameter Type");   
       }
       else if(type.length() == 0){
    	   throw new Exception("Empty String Passed In Parameter Type");   
       }
        switch(type){
            case "Lion":
                newAnimal = new Lion(name, age, weight);
                break;
            case "Tiger":
                newAnimal = new Tiger(name, age, weight);
                break;
            case "Snake":
                newAnimal = new Snake(name, age, weight);
                break;
            case "Sparrow":
                newAnimal = new Sparrow(name, age, weight);
                break;
            default:
                throw new Exception("Invalid Value Passed In Parameter Type");        
            }
        //checking if zone exist for given animal category
        for(Zone zone : zoneList) {
            if(zone.getCategoryOfAnimalSupported() == newAnimal.getAnimalCategory()){
                zoneExist = true;
                break;
            }
        }
        //if zone doesn't exist create new zone for the animal category 
        if(! zoneExist) {
            System.out.println("There is no zone Available for :" + newAnimal.getAnimalCategory());
            System.out.println("Please create a zone first");            
            return false;
        }
        //allocate cage  
        for(Zone zone : zoneList) {
            if(zone.getCategoryOfAnimalSupported() == newAnimal.getAnimalCategory()) {
                if(zone.addAnimalToCage(newAnimal)) {
                    System.out.println("Animal Allocated a Cage");
                    return true;
                }
            }
        }
        System.out.println("sorry!!! Animal not allocated a cage");
        return false;
    }
      
    /*
     * Method to delete animal from zoo
     * @returns true if the animal exist in the zone and is deleted 
     */
    public static boolean deleteAnimal(){
        System.out.println("List Of animals are :");
        boolean bol = false;
        boolean result = false;
        Zone zoneOfAnimalToDelete = null;
        Cage cageOfAnimalToDelete = null;
        
        outerMostLoop:for(Zone zone : zoneList){
             for(Cage cage : zone.getCageList()){
                for(Animal animal : cage.getAllAnimalsInCage()){
                    System.out.println(animal.getAnimalId() +" "+ animal.getAnimalname());
                    System.out.println("want to delete ?(true/false)");
                    try{
                    	bol = sc.hasNextBoolean();
                    }
                    catch(InputMismatchException e){
                    	System.out.println("Invalid Value Passed As Input In Response To Delete Animal");                 	  
                    }
                    if(bol){
                        cage.getAllAnimalsInCage().remove(animal);
                        zoneOfAnimalToDelete = zone;
                        cageOfAnimalToDelete = cage;
                        result = true;
                        break outerMostLoop;
                    }      
                }
            }
        }
        if(bol && cageOfAnimalToDelete.getAllAnimalsInCage().size() == 0){
            zoneOfAnimalToDelete.getCageList().remove(cageOfAnimalToDelete);
            result = true;
        }
        return result;
    }
    
    /*
     * function is used to create new zone
     * @returns return boolean value true if zone is created
     */
    public static boolean createZone(String category) throws Exception {
    	boolean hasPark;
    	boolean hasCanteen;
    	Integer maxCages;
    	if(category == null){
     	   throw new NullPointerException("Null Value Passed In Parameter Category");   
        }
        else if(category.length() == 0){
     	   throw new Exception("Empty String Passed In Parameter Category");   
        }    
    	switch(category){
            case "Mammal":
                category = Mammal.CATEGORY;
                break;
            case "Reptile":
                category = Reptile.CATEGORY;
                break;
            case "Bird":
                category = Bird.CATEGORY;
                break;
            default:
            	throw new Exception("Invalid Value Passed In Parameter Category");              
        }
        
	    try{ 
	        System.out.println("Zone has Park? (true/false) ");
	        hasPark = sc.nextBoolean();
	        System.out.println("Zone has Canteen? (true/false) ");
	        hasCanteen = sc.nextBoolean();        
	        System.out.println("Maximum No of cages : ");
	        
	        maxCages = sc.nextInt();
	        if(maxCages == null){
	        	throw new NullPointerException("Null Value Inputed For Parameter Maximum Cage Of Zone");
	        }
	        else if(maxCages == 0){ 
	     	   throw new Exception("Zero Value Passed In Parameter Maximum Cage Of Zone");
	        }
	        Zone z = new Zone(hasPark,hasCanteen,maxCages,category);
	        zoneList.add(z);    
	        return true;
	    }
	    catch(InputMismatchException e){
	    	System.out.println("Invalid Value Passed In Zone Details");
	    }
	    catch(NullPointerException e){
	    	System.out.println(e);
	    }
	    catch(Exception e){
	    	System.out.println(e);
	    }
		return false;     
    }
}
