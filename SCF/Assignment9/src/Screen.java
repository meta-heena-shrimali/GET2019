/**
 * Screen class is the main class through which a user will interact and checks
 * the validation of the input points and can perform operations such as create
 * shape, delete specific shape, display shape in the ascending order on the
 * basis of area, perimeter
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Screen {

    private List<Shape> listOfShapes = new ArrayList<Shape>();
    private final double xMax;
    private final double yMax;
    private Set<Integer> shapeId = new HashSet<>();

    /*
     * Constructor initialises the max x-coordinate and y-coordinate of the screen
     * @param xMax max x-coordinate
     * @param yMax max y-coordinate
     */
    public Screen(double xMax, double yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    /*
     * Method to add shapes to the list if the user has entered correct
     * coordinates and type of the shape
     * @param typerepresents the type of the shape
     * @param pointrepresents the origin point of the shape
     * @param parameterscontains the list of parameters of the shape
     * @return shapeObject, object of the shape created
     * @throws InvalidId, InvalidCoordinates exception if invalid parameters are given as input
     * @throws InvalidShapeType exception if valid shape is not entered
     */
    Shape addShape(Integer id, Shape.ShapeType type, Point originPoint, List<Double> parameters) throws Exception{
        if(id == null || type == null || originPoint == null || parameters == null){
        	throw new Exception("null value passed in input"); 
        }
    	Shape shapeObject = null;
        if (!shapeId.contains(id)) {
            shapeId.add(id);
        } 
        else 
            throw new Exception("Id already exist!!");
        if(originPoint.getxCoordinate() < 0 || originPoint.getxCoordinate() > xMax || originPoint.getyCoordinate() < 0 || originPoint.getyCoordinate() > yMax){
   		 	throw new Exception("Invalid Origin Point!!");
        }
        switch (type) {
        case CIRCLE:
            // Check the validation of the input parameters
        	if(parameters.size() <= 0 || parameters.size() >1){
        		 throw new Exception("Invalid parameters passed");
        	}
            double radius = parameters.get(0);
            double slope = Math.atan(originPoint.getyCoordinate() / originPoint.getxCoordinate());
            double centerDistance = Math.sqrt(originPoint.getxCoordinate() * originPoint.getxCoordinate() + originPoint.getyCoordinate() * originPoint.getyCoordinate()) + radius;
            double xCenter = centerDistance * Math.cos(slope);
            double yCenter = centerDistance * Math.sin(slope);
            if (originPoint.getxCoordinate() >= 0 && originPoint.getyCoordinate() >= 0 && (xCenter + radius) <= xMax
                    && (yCenter + radius <= yMax)) {
                break;
            }
            else 
                throw new Exception("Invalid Coordinates!!");

        case RECTANGLE:
        	if(parameters.size() <= 0 || parameters.size() >2){
       		 	throw new Exception("Invalid parameters passed");
        	}
            // Check the validation of the input parameters
            double length = parameters.get(0);
            double width = parameters.get(1);
            if (originPoint.getxCoordinate() >= 0 && originPoint.getyCoordinate() >= 0 && (originPoint.getxCoordinate() + length <= xMax)&& (originPoint.getyCoordinate() + width <= yMax)) {
                break;
            } else 
                throw new Exception("Invalid Coordinates!!");

        case SQUARE:
            // Check the validation of the input parameters
        	if(parameters.size() <= 0 || parameters.size() >1){
        		throw new Exception("Invalid parameters passed");
        	}
            double side = parameters.get(0);
            if (originPoint.getxCoordinate() >= 0 && originPoint.getyCoordinate() >= 0 && (originPoint.getxCoordinate() + side <= xMax) && (originPoint.getyCoordinate() + side <= yMax)) {
                break;
            } 
            else
                throw new Exception("Invalid Coordinates!!");


        case TRIANGLE:
            // Check the validation of the input parameters
        	if(parameters.size() <= 0 || parameters.size() >4){
        		throw new Exception("Invalid parameters passed");
        	}
            double side1 = parameters.get(0);
            double side3 = parameters.get(2);
            double height = parameters.get(3);
            if (originPoint.getxCoordinate() >= 0 && originPoint.getyCoordinate() >= 0 && (originPoint.getxCoordinate() + side1 <= xMax)
                    && (originPoint.getxCoordinate() + Math.sqrt(side3 * side3 - height * height) <= xMax)
                    && (originPoint.getyCoordinate() + height <= yMax)) {
                break;
            } 
            else 
                throw new Exception("Invalid Coordinates!!");
        default:
            throw new Exception("Invalid Shape Type!!");
        }
        shapeObject = Factory.createShape(id, type, originPoint, parameters);
        listOfShapes.add(shapeObject);
        return shapeObject;
    }

    /*
     * Method to delete a particular shape with the given id
     * @param type type of the shape
     * @param shapeId unique id of the shape
     * @return id of the deleted shape
     * @throws InvalidId exception if id does not exists
     */
    int deleteShape(Shape.ShapeType type, Integer shapeId) throws Exception{
    	if(shapeId == null || type == null ){
        	throw new Exception("null value passed in input"); 
        }
        int id = -1;
        System.out.println(shapeId);
        for(Shape shape:listOfShapes){
            if (shape.getType().equals(type) && shape.getId() == shapeId) {
                listOfShapes.remove(shape);
                id=shape.getId();
                break;
            }
        }
        if(id == -1)
            throw new Exception("Invalid id no such id exist!!");
        return id;
    }

    /*
     * Method to return the list of all shapes enclosing the given point 
     * @param point input point for which to check
     * @return shapesEnclosingPointList, list of all the shapes enclosing the point
     * 
     */
    List<Shape> getShapesEnclosingPoint(Point point) throws Exception {
    	if(point == null){
        	throw new Exception("null value passed in input"); 
        }
        List<Shape> shapesEnclosingPointList = new ArrayList<>();
        for(Shape shapeObject :listOfShapes) {
            if (shapeObject.isPointEnclosed(point)) {
                shapesEnclosingPointList.add(shapeObject);
            }
        }
        return shapesEnclosingPointList;
    }

    /*
     * Function to delete all the shapes of a given particular shape type
     * @param type type of the shape to be deleted
     * @return no of  all the shape objects have been deleted
     */
    int deleteAllShapeType(Shape.ShapeType type) throws Exception {
    	if(type == null){
        	throw new Exception("null value passed in input"); 
        }
    	int status = 0;
        Iterator<Shape> iterator = listOfShapes.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (shape.getType().equals(type)) {
                iterator.remove();
                status++;
            }
        }
        return status;
    }

    /*
     * Function to sort the shapes object in the ascending order on the basis of their area 
     * @return areaList, list in the sorted order
     */
    public List<Shape> sortByArea() {
        List<Shape> areaList = new ArrayList<Shape>(listOfShapes);
        int size = areaList.size();
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (areaList.get(j).getArea() > areaList.get(j + 1).getArea()) {
                    Shape tempShape = areaList.get(j);
                    areaList.set(j, areaList.get(j + 1));
                    areaList.set(j + 1, tempShape);
                }
        return areaList;
    }

    /*
     * Function to sort the shapes object in the ascending order on the basis of their perimeter
     * @return perimeterList, list in the sorted order
     */
    public List<Shape> sortByPerimeter() {
        List<Shape> perimeterList = new ArrayList<Shape>(listOfShapes);
        int size = perimeterList.size();
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (perimeterList.get(j).getPerimeter() > perimeterList.get(j + 1).getPerimeter()) {
                    Shape tempShape = perimeterList.get(j);
                    perimeterList.set(j, perimeterList.get(j + 1));
                    perimeterList.set(j + 1, tempShape);
                }
        return perimeterList;
    }

    /*
     * Function to sort the shapes object in the ascending order on the basis of
     * their distance from the origin of the screen
     * @return distanceList, list in the sorted order
     */
    public List<Shape> sortByDistance() {
        List<Shape> distanceList = new ArrayList<Shape>(listOfShapes);
        int size = distanceList.size();
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (distanceList.get(j).getDistance() > distanceList.get(j + 1).getDistance()) {
                    Shape tempShape = distanceList.get(j);
                    distanceList.set(j, distanceList.get(j + 1));
                    distanceList.set(j + 1, tempShape);
                }
        return distanceList;
    }

    /*
     * Function to sort the shapes object in the ascending order on the basis of their created time
     * @return timeList, list in the sorted order
     */
    public List<Shape> sortByTime() {
        List<Shape> timeList = new ArrayList<Shape>(listOfShapes);
        int size = timeList.size();
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (timeList.get(j).getTimeStamp().after(timeList.get(j + 1).getTimeStamp())) {
                    Shape tempShape = timeList.get(j);
                    timeList.set(j, timeList.get(j + 1));
                    timeList.set(j + 1, tempShape);
                }
        return timeList;
    }
}
