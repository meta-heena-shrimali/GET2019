
abstract public class Animal {

    private static int count = 0;
    private int animalIid;
    private String animalName;
    private int animalAge;
    private float animalWeight;
    
    public Animal(String name,int age, float Weigtht){
        count++;
        this.animalIid = count;
        this.animalName = name;
        this.animalAge = age;
        this.animalWeight = Weigtht;
    }
    
    public int getAnimalId(){  
    	return animalIid;  
    }
    
    public String getAnimalname(){ 
    	return animalName; 
    }
    
    public int getAnimalAge(){   
    	return animalAge;
    }
    
    public float getAnimalWeight(){ 
    	return animalWeight;
    }
    
    abstract public String getCategory();
    
    abstract public String makeSound();
    
    abstract public String getType();
    
}
