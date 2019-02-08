/**
 * Implement class that extends Shape class, represents square and implements functions such as
 *  getArea(), getPerimeter(), getOrigin(), isPointEnclosed() for Square shape
 */
import java.util.Date;
import java.util.List;

public class Square implements Shape {

	private Point origin;
	private double side;
	private final ShapeType type;
	private final Date timestamp;
	private int id;

	public Square(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.origin = origin;
		this.side = parameters.get(0);
		this.type = type;
		this.timestamp = new Date();
		this.id = id;
	}

    /*
     * Method to calculate the area enclosed by the shape
     * @return area, enclosed by the shape
     */
	@Override
	public double getArea() {
		return (side * side);  
	}

    /*
     * Method to calculate the perimeter of the shape
     * @return perimeter of the shape
     */
	@Override
    	public double getPerimeter() {
		return (4 * side); 
	}

    /*
    * Method to return the origin of the shape i.e., the leftmost point of the
    * shape
    * @return origin, coordinates of the leftmost point
    */
	@Override
    	public Point getOrigin() { 
		return origin; 
	}

    /*
     * Method to find if a point is enclosed by the shape or not 
     * @param point,point for which to check
     * @return true if the given point lies inside the shape else false
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		if (point.getxCoordinate() >= 0 && point.getyCoordinate() >= 0 && point.getxCoordinate() < origin.getxCoordinate() + side
				&& point.getyCoordinate() < origin.getyCoordinate() + side) {
			return true;
		}
		return false;
	}

    /*
     * Method to calculate the distance between the origin of the screen and
     * origin of the shape
     * @return distance between the two points
     */
	@Override
	public double getDistance() {
		return Math.sqrt(origin.getxCoordinate() * origin.getxCoordinate() + origin.getyCoordinate() * origin.getyCoordinate());
	}

    /*
     * Method to return the type of the shape such as rectangle, square etc
     * @return type of the shape
     */
	@Override
	public ShapeType getType() { 
		return type;   
	}

    /*
     * Method to return the timestamp of the object created
     * @return the copy of the date object
     */
	@Override
	public Date getTimeStamp() {  
		return new Date(timestamp.getTime()); 
	}
	
    /*
     * Method to return the unique id of the object
     * @return id of the object
     */
	@Override
	public int getId() {   
		return id; 
	}

}
