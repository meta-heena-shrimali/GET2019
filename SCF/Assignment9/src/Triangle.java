/**
 * Implements class that extends Shape class,  represents triangle shape and
 * implements functions such as getArea(), getPerimeter(),
 * getOrigin(), isPointEnclosed() for Triangle shape
 */

import java.util.Date;
import java.util.List;

public class Triangle implements Shape {

	private Point origin;
	private double side1;
	private double side2;
	private double side3;
	private double height;
	private final ShapeType type;
	private final Date timestamp;
	private int id;

	public Triangle(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.origin = origin;
		this.side1 = parameters.get(0);
		this.side2 = parameters.get(1);
		this.side3 = parameters.get(2);
		this.height = parameters.get(3);
		this.type = type;
		this.timestamp = new Date();
		this.id = id;
	}

    /*
     * Method to calculate the area enclosed by the shape
     * s=(A+B+C)/2
     * area =Sqrt((s-A)*(s-B)*(s-C))
     * @return area, enclosed by the shape
     */
	@Override
	public double getArea() {
		double halfOfPerimeter = getPerimeter() / 2;
		double tempArea = halfOfPerimeter * (halfOfPerimeter - side1) * (halfOfPerimeter - side2)
				* (halfOfPerimeter - side3);
		return Math.sqrt(tempArea);
	}

    /*
     * Method to calculate the perimeter of the shape 
     * @return perimeter of the shape
     */
	@Override
	public double getPerimeter() { return (side1 + side2 + side3); }

    /*
    * Method to return the origin of the shape i.e., the leftmost point of the
    * shape 
    * @return origin, coordinates of the leftmost point
    */
	@Override
	public Point getOrigin() { return origin;  }

	/* to find  area covered by three points of Triangle
	 * area = [Ax(By-Cy) + Bx(Cy-Ay) + Cx(Ay-By)]/2
	 * @param point1 of triangle
	 * @param point2 of triangle
	 * @param point3 of triangle
	 * @return area covered by this three points
	 */
	private double getAreaByVertices(Point point1, Point point2, Point point3) {
		double area = Math.abs(point1.getxCoordinate() * (point2.getyCoordinate() - point3.getyCoordinate())
				+ point2.getxCoordinate() * (point3.getyCoordinate() - point1.getyCoordinate())
				+ point3.getxCoordinate() * (point1.getyCoordinate() - point2.getyCoordinate())) / 2;
		return area;
	}

	/*
     * Method to find if a point is enclosed by the shape or not 
     * @param point, point for which to check
     * @return true if the given point lies inside the shape else false
     *if point is in triangle it makes 3 another triangle  with original triangle sides 
     * and the sum of the all three triangle's area is equal to area of original triangle
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		double pointX1 = origin.getxCoordinate();
		double pointY1 = origin.getyCoordinate();
		double pointX2 = pointX1 + side1;
		double pointX3 = Math.sqrt(side3 * side3 - height * height) + pointX1;
		double pointY3 = pointY1 + height;
		// pointY2 is same as pointY1
		Point point1 = new Point(pointX1, pointY1);
		Point point2 = new Point(pointX2, pointY1); 
		Point point3 = new Point(pointX3, pointY3);
		double area1 = getAreaByVertices(point1, point2, point);
		double area2 = getAreaByVertices(point2, point, point3);
		double area3 = getAreaByVertices(point1, point3, point);

		double area = getArea();

		double summedArea = area1 + area2 + area3;
		if (area == summedArea) {
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
