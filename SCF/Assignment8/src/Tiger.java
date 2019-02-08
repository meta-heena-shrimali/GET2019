/**
 * Implements a class Sparrow representing the specific types of animal
 * having parent class Bird
 * @author Admin
 */
public class Tiger extends Mammal{

    public static final String TYPE = "Tiger";

    /*
     * @param name is a unique animal name
     * @param age and @param weight are the properties of the animal
     * which are passed to the parent class constructor 
     */
    public Tiger(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    /*
     * overrides the abstract method of parent class to get sound made by animal
     * @returns return the sound of tiger - String type
     */
    @Override
    public String makeSound() {
        return "Roar";
    }
    
    /*
     * overrides the abstract method of parent class to get specific type of animal
     * @returns return the type of animal - String type
     */
    @Override
    public String getAnimalType() { 
    	return  TYPE;
    } 
}

