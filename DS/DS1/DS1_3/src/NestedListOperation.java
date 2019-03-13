import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;

public class NestedListOperation implements NestedList {

    private List<Object> nestedList = new ArrayList<Object>();
    private JSONObject JSONObject;

    public NestedListOperation(JSONObject JSONObject) {
        if (JSONObject != null) {
            this.JSONObject = JSONObject;
        }
    }

    public void createNestedList() {
        if (JSONObject != null) {
            this.nestedList = createNestedListRecursive(JSONObject);
        } else {
            throw new NullPointerException("Empty JSON Object");
        }
    }

    /*
     * private helper method to create nested list after parsing it from json file
     * 
     * @param JSONObject json object which contains input nested list
     * @return list of objects
     */
    private List<Object> createNestedListRecursive(JSONObject JSONObject) {
        LinkedList<Object> nestedList = new LinkedList<>();
        try {
            for (Object key : JSONObject.keySet()) {
                if (key != null) {
                    if (JSONObject.get(key) instanceof Long) {
                        long value = (Long) JSONObject.get(key);
                        nestedList.add(value);
                    } else {
                        JSONObject newJson = (JSONObject) JSONObject.get(key);
                        List<Object> list = createNestedListRecursive(newJson);
                        nestedList.add(list);
                    }
                } else {
                    throw new NullPointerException("Empty key value");
                }
            }
            System.out.println(nestedList);
            return nestedList;
        } catch (NullPointerException e) {
            throw new NullPointerException("Empty key value");
        }
    }

    @Override
    public long sumOfAllValues() {
        if (nestedList != null) {
            return sumOfAllValues(nestedList);
        } else {
            throw new AssertionError("Empty nested list");
        }

    }

    /*
     * private helper method to get the sum of all values of nested list
     * 
     * @param nestedList whose value's sum is to be calculated
     * @return sum of all values of nested list
     * @throws Assertion error
     */
    private long sumOfAllValues(List<Object> nestedList) {
        long sum = 0;
        for (Object object : nestedList) {
            if (object instanceof List) {
                sum += sumOfAllValues((List<Object>) object);
            } else if (object instanceof Long) {
                sum += (long) object;
            } else {
                throw new AssertionError("Invalid Input");
            }
        }
        return sum;
    }

    @Override
    public long largestValue() {
        if (nestedList != null) {
            return largestValue(nestedList);
        } else {
            throw new AssertionError("Empty nested list");
        }
    }

    /*
     * largest value from nested list
     * 
     * @param nestedList whose largest value is to be find
     * @return largest value of nested list
     * @throws Assertion error
     */

    private long largestValue(List<Object> nestedList) {

        long max = 0;
        long temp = 0;
        for (Object object : nestedList) {
            if (object instanceof List) {
                temp = largestValue((List<Object>) object);
            } else if (object instanceof Long) {
                temp = (long) object;
            } else {
                throw new AssertionError("Invalid Input");
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    @Override
    public boolean searchValue(int element) {
        if (nestedList != null) {
            return searchValue(nestedList, element);
        } else {
            throw new AssertionError("Empty nested list");
        }
    }

    /*
     * search value in nested list
     * 
     * @param nestedList in which element is to be searched
     * @param element    which is to be searched in list
     * @return true if element is present in list else false
     */
    private boolean searchValue(List<Object> nestedList, int element) {

        for (Object object : nestedList) {
            if (object instanceof List) {
                if (searchValue((List<Object>) object, element)) {
                    return true;
                }
            } else if (object instanceof Long) {
                if ((long) object == element) {
                    return true;
                }
            } else {
                throw new AssertionError("Invalid Input");
            }

        }
        return false;
    }

}
