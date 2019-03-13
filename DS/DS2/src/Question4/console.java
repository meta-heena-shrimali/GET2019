package Question4;

import java.io.IOException;

public class console {
    
    public static void main(String[] args) throws IOException {
        Counselling c = new Counselling();
        c.programs();
        c.addStudents();
        c.allocate();
        c.updateExcel();
    }
}
