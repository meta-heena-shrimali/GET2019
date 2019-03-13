package Question4;

public class StudentNode {

    private String name;
    private String[] data;

    public StudentNode(String name, String[] data) {
        this.name = name;
        this.data = data;
    }

    public String[] getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

}