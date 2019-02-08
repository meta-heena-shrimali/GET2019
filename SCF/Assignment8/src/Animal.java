/**
 *  implements a class to Create a hierarchy of animal where Animal is the base class 
 *  and its subclasses could be various categories of animals like Mammal, Reptile, Bird, etc.
 *  @author Admin
 */

 abstract public class Animal {
	//count is used to assign Internal id automatically.
    private static int count = 0;
    private int animalIid;
    private String animalName;
    private int animalAge;
    private float animalWeight;
    
    /*
     * @param name is a unique animal name
     * @param age and @param weight are the properties of the animal 
     */
    public Animal(String name,int age, float weigtht){
        count++;
        this.animalIid = count;
        this.animalName = name;
        this.animalAge = age;
        this.animalWeight = weigtht;
    }
    
    /*
     * @returns return the internal animal id of integer type 
     */
    public int getAnimalId(){  
    	return animalIid;  
    }
    
    /*
     * @returns return the animal name of String type
     */
    public String getAnimalname(){ 
    	return animalName; 
    }
    
    /*
     * @returns return age of the animal of integer type
     */
    public int getAnimalAge(){   
    	return animalAge;
    }
    
    /*
     * @returns return weight of animal of float type
     */
    public float getAnimalWeight(){ 
    	return animalWeight;
    }
    
    /*
     * declares an abstract method to get category of the animal  - Reptile, mammal , birds etc.
     * @returns return the Category of animal of String type
     */
    abstract public String getAnimalCategory();
    
    /*
     * declares an abstract method to get sound made by the animal
     * @returns return the sound of animal of String type
     */
    abstract public String makeSound();
    
    /*
     * declares an abstract method to get type of the animal  - lion , tiger, snake etc.
     * @returns return the type of animal of String type
     */
    abstract public String getAnimalType();
    
}
