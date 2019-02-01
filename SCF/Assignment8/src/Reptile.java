
abstract public class Reptile extends Animal {

    public static final String RAPTILE = "Raptile";
    public Reptile(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    abstract public String makeSound();
    
    @Override
    public String getCategory() {   
    	return RAPTILE; 
    }
    
    @Override
    abstract public String getType();
}
