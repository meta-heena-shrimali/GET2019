/**
 * This class contains the information of a point such as its x and
 * y-coordinates
 */
public class Point {

    private double xCoord;
    private double yCoord;

    Point(double xCoord, double yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /* to get X coordinate of Point
     * @return x coordinate
     */
    public double getxCoord() { 
    	return xCoord;  
    }

    /* to get Y coordinate of Point
     * @return y coordinate
     */
    public double getyCoord() { 
    	return yCoord; 
    }

}
