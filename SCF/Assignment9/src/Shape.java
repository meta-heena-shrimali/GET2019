/**
 * Implement hierarchy of Shape Abstract Data Type where Shape is an interface 
 * that will expose certain basic APIs like getArea, getPerimeter, getOrigin and isPointEnclosed. 
 * Shape interface will have ShapeType enum that will list all the supported type of shapes by the system.
 */
import java.util.Date;

public interface Shape {

    /*
     * Enum ShapeType to store the type of the shapes it supports 
     */
    public enum ShapeType { RECTANGLE, SQUARE, TRIANGLE, CIRCLE }

    /*
     * Method to calculate the perimeter of the shape
     * @return perimeter of the shape of type double
     */
    public double getPerimeter();
    

    /*
     * Method to calculate the area enclosed by the shape
     * @return area, enclosed by the shape of type double
     */
    public double getArea();
    

    /*
     * Method to return the type of the shape such as rectangle, square etc
     * @return type of the shape 
     */
    public ShapeType getType();
    
    /*
     * Method to find if a point is enclosed by the shape or not
     * @param point,point for which to check
     * @return true if the given point lies inside the shape else false
     */
    public boolean isPointEnclosed(Point point);

    /*
     * Method to return the origin of the shape i.e., the leftmost point of the
       shape
     * @return origin, coordinates of the leftmost point of type Point
     */
     public Point getOrigin();

    /*
     * Method to return the unique id of the object
     * @return id of the object
     */
    public int getId();

    /*
     * Method to return the timeStamp of the object created     
     * @return the copy of the date object
     */
    public Date getTimeStamp();

    /*
     * Method to calculate the distance between the origin of the screen and
       origin of the shape 
     * @return distance between the two points
     */
    public double getDistance();
}
