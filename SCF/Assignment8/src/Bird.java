/**
 *  Implements a class Bird with Animal class as parent class  
 *  having subclasses representing the specific types of animal like sparrow etc. 
 *  @author Admin
 */

abstract public class Bird extends  Animal{
	
    public static final String CATEGORY = "Bird";
    /*
     * @param name is a unique animal name
     * @param age and @param weight are the properties of the animal
     * which are passed to the parent class constructor 
     */
    public Bird(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }
    
    /*
     * overrides an abstract method of parent class to get category of the animal as bird
     * @returns return the Category of animal of String type
     */
    public String getAnimalCategory() { 
    	return CATEGORY; 
    }
}
