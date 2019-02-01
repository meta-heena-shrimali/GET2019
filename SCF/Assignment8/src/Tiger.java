
public class Tiger extends Mammal{

    public static final String TIGER = "Tiger";

    public Tiger(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    public String makeSound() {
        return "Roar";
    }
    
    @Override
    public String getType() {
    	return TIGER;
    }   
}

