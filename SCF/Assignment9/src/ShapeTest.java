import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ShapeTest {

    Screen screen = new Screen(100, 100);
    Shape shape1,shape2,shape3,shape4;
    Double area;
    Point point1,point2;
    int result;
    boolean res;
    
  //null value test for addShape()
    @Test
    public void nullPointerExceptionInAddShape(){
    	 try {
    		  screen.addShape(null, Shape.ShapeType.CIRCLE, new Point(3, 4),
    				  new ArrayList<Double>(Arrays.asList(5.0)));
 		 }
 		 catch (Exception e) {
 			 assertEquals("null value passed in input", e.getMessage());
 		 }
    }
    
    //create shape with invalid ID
    @Test
    public void IdAlreadyExistErrorInAddShape(){
    	 try {
    		  screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(3, 4),
    				  new ArrayList<Double>(Arrays.asList(5.0)));
    		  screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(3, 4), 
    				  new ArrayList<Double>(Arrays.asList(5.0)));
    	        
 		 }
 		 catch (Exception e) {
 			 assertEquals("Id already exist!!", e.getMessage());
 		 }
    }
    
    //create shape with invalid Origin Point as they go beyond screen
    @Test
    public void InvalidCoordinateInputsErrorInAddShape(){
    	 try {
    		  screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(-3, -4),
    				  new ArrayList<Double>(Arrays.asList(5.0))); 	        
 		 }
 		 catch (Exception e) {
 			 assertEquals("Invalid Origin Point!!", e.getMessage());
 		 }
    }
    
  //create shape with invalid no. of parameter list
    @Test
    public void InvalidParametersInputsErrorInAddShape(){
    	 try {
    		  screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(3, 4), 
    				  new ArrayList<Double>(Arrays.asList(5.0,9.0))); 	        
 		 }
 		 catch (Exception e) {
 			 assertEquals("Invalid parameters passed!!", e.getMessage());
 		 }
    }
    
  //create shape with invalid parameters as coordinates go beyond screen
    @Test
    public void InvalidParametersInputsCoordinatesOutOfBoundErrorInAddShape(){
    	 try {
    		 screen.addShape(2, Shape.ShapeType.SQUARE, new Point(2, 1),
    				 new ArrayList<Double>(Arrays.asList(140.0)));
         }
 		 catch (Exception e) {
 			 assertEquals("Invalid Coordinates!!", e.getMessage());
 		 }
    }
    
    // create shape Circle
    @Test
    public void testCreateShapeCircle() throws Exception{
        shape1 = screen.addShape(1, Shape.ShapeType.CIRCLE, new Point(3, 4),
        		new ArrayList<Double>(Arrays.asList(5.0)));
        area = shape1.getArea();
        assertEquals(Math.PI *25, area, 0);
    }
    
    //create shape square
    @Test
    public void testCreateShapeSquare() throws Exception{
        shape1 = screen.addShape(2, Shape.ShapeType.SQUARE, new Point(2, 1), 
        		new ArrayList<Double>(Arrays.asList(4.0)));
        area = shape1.getPerimeter();
        assertEquals(16, area, 0);
    }

    //create shape rectangle
    @Test
    public void testCreateShapeRectangle() throws Exception{
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2.0, 2.0),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        assertEquals(1, shape1.getId());
    }
    
    // create shape triangle
    @Test
    public void testCreateShapeTriangle() throws Exception{
        shape1 = screen.addShape(1, Shape.ShapeType.TRIANGLE, new Point(0, 0),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
        area = shape1.getArea();
        assertEquals(6, area, 0);
    }
    
    // test null value input in deleteAllShapeType() 
    @Test
    public void testNullValueInputInDeleteAllShape() throws Exception{
    	try{
    		result = screen.deleteAllShapeType(null);
    	}
    	catch(Exception e){
    		 assertEquals("null value passed in input", e.getMessage());
    	}

    }
    // delete all shape with same type
    @Test
    public void testDeleteAllShape() throws Exception{
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2, 1),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape2 = screen.addShape(2, Shape.ShapeType.RECTANGLE, new Point(3, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape3 = screen.addShape(3, Shape.ShapeType.RECTANGLE, new Point(2, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape4 = screen.addShape(4, Shape.ShapeType.SQUARE, new Point(2, 1),
        		new ArrayList<Double>(Arrays.asList(4.0)));
        result = screen.deleteAllShapeType(Shape.ShapeType.RECTANGLE);
        assertEquals(3, result);

    }
 // delete all shape with same type
    @Test
    public void testDeleteShapeWhenIdDoesNotExist(){
    	try{
	        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2, 1),
	                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
	        result = screen.deleteShape(Shape.ShapeType.RECTANGLE, 5);
    	}
    	catch(Exception e){
    		 assertEquals("Invalid id no such id exist!!", e.getMessage());
    	}

    }
 // test null value input in getShapesEnclosingPoint()
    @Test
    public void testNullValueInputInGetShapesEnclosingPoint() throws Exception{
    	try{
    		screen.getShapesEnclosingPoint(null);
    	}
    	catch(Exception e){
    		 assertEquals("null value passed in input", e.getMessage());
    	}

    }
    
 // test null value input in deleteShape() 
    @Test
    public void testNullValueInputInDeletShape() throws Exception{
    	try{
    		result = screen.deleteShape(null,null);
    	}
    	catch(Exception e){
    		 assertEquals("null value passed in input", e.getMessage());
    	}

    }
    // delete specific shape
    @Test
    public void testDeleteShape() throws Exception{
        shape1 = screen.addShape(1, Shape.ShapeType.RECTANGLE, new Point(2, 1),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape2 = screen.addShape(2, Shape.ShapeType.RECTANGLE, new Point(3, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape3 = screen.addShape(3, Shape.ShapeType.RECTANGLE, new Point(2, 2),
                new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
        shape4 = screen.addShape(4, Shape.ShapeType.SQUARE, new Point(2, 1), 
                new ArrayList<Double>(Arrays.asList(4.0)));
        result = screen.deleteShape(Shape.ShapeType.RECTANGLE, 3);
        assertEquals(3, result);
    }

    // sort Shape by area
    @Test
    public void testSortByArea() throws Exception {
        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        shape1 = screen.addShape(1, type1, point1, parameters1);
        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(1, 1);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        shape2 = screen.addShape(2, type2, point2, parameters2);
        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByArea();
        assertEquals(expectedresult, actualresult);
    }

    // sort Shape by Distance from origin(0,0) of screen to origin of Shape Object 
    @Test
    public void testSortByDistance() throws Exception {

        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        shape1 = screen.addShape(1, type1, point1, parameters1);

        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(2, 2);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        Shape shape2 = screen.addShape(2, type2, point2, parameters2);

        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByDistance();
        assertEquals(expectedresult, actualresult);
    }

    // sort Shape by Perimeter of Shape  
    @Test
    public void testSortByPerimeter() throws Exception{

        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        Shape shape1 = screen.addShape(1, type1, point1, parameters1);

        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(1, 1);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        Shape shape2 = screen.addShape(2, type2, point2, parameters2);

        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByPerimeter();
        assertEquals(expectedresult, actualresult);
    }

    // sort Shape by Time of creation
    @Test
    public void testSortByTimestamp() throws Exception{

        Shape.ShapeType type1 = Shape.ShapeType.CIRCLE;
        Point point1 = new Point(1, 1);
        List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
        shape1 = screen.addShape(1, type1, point1, parameters1);

        Shape.ShapeType type2 = Shape.ShapeType.CIRCLE;
        Point point2 = new Point(1, 1);
        List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
        shape2 = screen.addShape(2, type2, point2, parameters2);

        List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
        List<Shape> actualresult = new ArrayList<Shape>();
        actualresult = screen.sortByTime();
        assertEquals(expectedresult, actualresult);
    }
    
    //  to find the list of shape that have a point enclosed in that shape
    @Test
    public void testShapesEnclosingPoint() throws Exception {

    shape1 = screen.addShape(1,Shape.ShapeType.RECTANGLE, new Point(50, 50),
            new ArrayList<Double>(Arrays.asList(6.0, 4.0)));
    System.out.println(shape1.getId());
    shape2 = screen.addShape(2,Shape.ShapeType.RECTANGLE, new Point(5, 5),
            new ArrayList<Double>(Arrays.asList(10.0, 14.0)));
    System.out.println(shape2.getId());
    shape3 = screen.addShape(3,Shape.ShapeType.RECTANGLE, new Point(2, 2),
            new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
    System.out.println(shape3.getId());
    shape4 = screen.addShape(4,Shape.ShapeType.SQUARE, new Point(10, 10),
            new ArrayList<Double>(Arrays.asList(4.0)));
    List<Shape> actualResult = new ArrayList<Shape>();
    actualResult = screen.getShapesEnclosingPoint(new Point(3.0, 4.0));
    List<Shape> expectedResult = new ArrayList<Shape>(Arrays.asList(shape3, shape4));
    assertEquals(expectedResult, actualResult);
    }

}