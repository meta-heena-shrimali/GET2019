/**
 * This class extends Shape class , represents Circle and implements functions such as getArea(), getPerimeter(),
   getOrigin(), isPointEnclosed() for Circle shape
 */
import java.util.Date;
import java.util.List;

public class Circle implements Shape {

	private final Point originPoint;
	private final double radius;
	private final ShapeType shapeType;
	private final Date timestamp;
	private int id;
	
	/*
	 *@param type of ShapeType, @param id of type integer, @param origin of type Point
	 *@param parameters of type list  
	 */
	public Circle(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.shapeType = type;
		this.originPoint = origin;
		this.radius = parameters.get(0);
		this.timestamp = new Date();
		this.id = id;
	}

    /*
     * Method to calculate the area enclosed by the shape
     * @return area, enclosed by the shape
     */
	@Override
	public double getArea() {  
		return (Math.PI) * radius * radius; 
	}

    /*
     * Method to calculate the perimeter of the shape
     * @return perimeter of the shape
     */
	@Override
	public double getPerimeter() {    
		return 2 * Math.PI * radius; 
	}

    /*
    * Method to return the origin of the shape 
    * @return origin, coordinates of the leftmost point
    */
	@Override
	public Point getOrigin() {   
		return originPoint;  
	}

	/* to find Centre of circle 
	 * @return Point of Centre of Circle
	 */
	private Point getCenter() {
		try{
			double slope = Math.atan(originPoint.getyCoordinate() / originPoint.getxCoordinate());
			//H^2 = B^2 + L^2
			double distOfOrigin = Math.sqrt(originPoint.getyCoordinate() * originPoint.getyCoordinate() + originPoint.getxCoordinate() * originPoint.getxCoordinate());
			double distOfCenter = radius + distOfOrigin;
			double xCoordinate = distOfCenter * Math.cos(slope);
			double yCoordinate = distOfCenter * Math.sin(slope);
			Point center = new Point(xCoordinate, yCoordinate);
			return center;
		}
		catch(ArithmeticException e){
			System.out.println("Divide By Zero Arithmetic Exception");
		}
		
		return null;
	}
	
    /*
     * Method to find if a point is enclosed by the shape or not
     * @param point,point for which to check
     * @return true if the given point lies inside the shape else false
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		Point center = getCenter();
		double xCenter = center.getxCoordinate();
		double yCenter = center.getyCoordinate();
		double pointX = point.getxCoordinate();
		double pointY = point.getyCoordinate();
		if (Math.sqrt((pointY - yCenter) * (pointY - yCenter) + (pointX - xCenter) * (pointX - xCenter)) < radius) {
			return true;
		}
		return false;
	}

    /*
     * Method to calculate the distance between the origin of the screen and origin of the shape 
     * @return distance between the two points
     */
	@Override
	public double getDistance() {
		return Math.sqrt(originPoint.getxCoordinate() * originPoint.getxCoordinate() + originPoint.getyCoordinate() * originPoint.getyCoordinate());
	}
	
    /*
     * Method to return the type of the shape such as rectangle, square etc 
     * @return type of the shape
     */
	@Override
	public ShapeType getType() { 
		return shapeType;  
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
