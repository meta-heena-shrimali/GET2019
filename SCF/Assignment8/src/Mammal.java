/**
 *  Implements a class Mammal with Animal class as parent class  
 *  having subclasses representing the specific types of animal like Lion , Tiger etc. 
 *  @author Admin
 */

abstract public class Mammal extends Animal {
    
    public static final String CATEGORY = "Mammal";
  
    /*
     * @param name is a unique animal name
     * @param age and @param weight are the properties of the animal
     * which are passed to the parent class constructor 
     */
    public Mammal(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }
    
    /*
     * overrides an abstract method of parent class to get category of the animal as mammal
     * @returns return the Category of animal of String type
     */
    public String getAnimalCategory() {   
    	return CATEGORY; 
    }
}

