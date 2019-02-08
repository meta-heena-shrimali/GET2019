/**
 *  Implements a class Reptile with Animal class as parent class  
 *  having subclasses representing the specific types of animal like snake etc. 
 *  @author Admin
 */
abstract public class Reptile extends Animal {

    public static final String CATEGORY= "Reptile";
   
    /*
     * @param name is a unique animal name
     * @param age and @param weight are the properties of the animal
     * which are passed to the parent class constructor 
     */
    public Reptile(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    /*
     * overrides an abstract method of parent class to get category of the animal as reptile 
     * @returns return the Category of animal of String type
     */
    @Override
    public String getAnimalCategory() {   
    	return CATEGORY; 
    }
    
   
}
