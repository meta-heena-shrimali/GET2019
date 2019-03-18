package dictionary;
/**
 * the interface for a dictionary implemented using a binary search tree
 */
import java.util.List;

public interface Dictionary {

	/*
	 * @param node,for adding in BST
	 * @return true after addition of node in BST
	 */
	boolean add(Node node) throws Exception;
		
	/*
	 * @param key,deleting a node(Key:value pair) based on key
	 * @return true, false 
	 */
	boolean delete(String key) throws Exception;
	
	/*
	 * @param key, for getting value based on Key from BST
	 * @return value(ObjectType),if key found else return null
	 */
	String getValue(String key) throws Exception;
	
	
	/*
	 * @return sortedList of key:value pair based on key
	 */
	List<String> getSortedList();
	
	
	/* 
	 * method will return sorted list of key:value pair based on key condition:-for all the keys >=K1 and <=K2.
	 * @param key1
	 * @param key2
	 * @return sortedList of key:value pair based on key between key1 and key2
	 */
	public List<String> getSortedList(String key1,String key2) throws Exception;
}
