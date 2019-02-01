
public class Lion extends Mammal{

    public static final String LION = "Lion";
    
    public Lion(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    public String makeSound() {
        return "Roar";
    }
    
    @Override
    public String getType() { 
    	return LION; 
    }
}

