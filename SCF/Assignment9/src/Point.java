/**
 * Implements class containing the information of a point such as its x and
 * y-coordinates
 */
public class Point {

    private double xCoordinate;
    private double yCoordinate;

    Point(double xCoord, double yCoord) {
        this.xCoordinate = xCoord;
        this.yCoordinate = yCoord;
    }

    /* to get X coordinate of Point
     * @return x coordinate
     */
    public double getxCoordinate() { 
    	return xCoordinate;  
    }

    /* to get Y coordinate of Point
     * @return y coordinate
     */
    public double getyCoordinate() { 
    	return yCoordinate; 
    }

}
