
abstract public class Mammal extends Animal {
    
    public static final String MAMMAL = "Mammal";
  
    
    public Mammal(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    abstract public String makeSound();

    public String getCategory() {   
    	return MAMMAL; 
    }
    
    @Override
    abstract public String getType();
}

