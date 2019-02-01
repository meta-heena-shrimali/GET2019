
public class Sparrow extends Bird{

    public static final String SPARROW = "Sparrow";

    public Sparrow(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    public String makeSound() {
        return "chirr-up";
    }
    
    @Override
    public String getType() { 
    	return SPARROW;
    }
}

