abstract public class Bird extends  Animal{

    public static final String BIRD = "Bird";
    public Bird(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    abstract public String makeSound();
    
    public String getCategory() { 
    	return BIRD; 
    }

    @Override
    abstract public String getType();
}
