
public class Snake extends Reptile{

    public static final String SNAKE = "Snake";
    public Snake(String name, int age, float Weigtht) {
        super(name, age, Weigtht);
    }

    @Override
    public String makeSound() {
        return "hissss";
    }
    
    @Override
    public String getType() { 
    	return SNAKE;
    }
}

