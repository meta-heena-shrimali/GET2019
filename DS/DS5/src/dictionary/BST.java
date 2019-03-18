package dictionary;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BST implements Dictionary{

	//for purpose of returning a sorted list of BST element
	List<String> sortedList;
	//root node of BST (binary search tree)
	Node root;

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	/*
	 * Constructor which is taking json file path and creating dictionary
	 * @param jsonFilePath,path of json file
	 */
	public BST(String jsonFilePath) throws Exception {
		this.root = null;
		sortedList  = new LinkedList<String>();
		if( jsonFilePath == null)
			throw new Exception(" Null Json file path passed ");
		if( jsonFilePath == "")
			throw new Exception(" Empty Json file path passed ");
		File jsonFile = new File(jsonFilePath);
		this.createDictionary(jsonFile);
	}

	/*
	 * @param jsonFile path of json File
	 */
	private void createDictionary(File jsonFile) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			//getting data from json file
			Map<String, String> mapObject = objectMapper.readValue(jsonFile,
					new TypeReference<Map<String, String>>() {});
			//inserting each key:value pair into dictionary
			for (Map.Entry<String,String> entry : mapObject.entrySet()) {
				Node node = new Node(entry.getKey(),entry.getValue());//creating node of each key:value
				this.add(node);//adding node into tree
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @param node,for adding in BST
	 * @return true after addition of node in BST else false
	 */

	@Override
	public boolean add(Node node) throws Exception {
		if(node == null)
			throw new Exception("null value passed as node");
		if(this.getRoot()==null) {
			this.setRoot(node);
			return true;
		}
		Node addedNode = addRecursive(this.getRoot(), node);
		if(addedNode!=null) {
			return true;
		}else {
			return false;
		}
	}

	/*
	 * @param key,deleting a node(Key:value pair) based on key
	 * @return @return true, false 
	 */
	@Override
	public boolean delete(String key) throws Exception {
		if(key == null)
			throw new Exception("null value passed as key");
		if(key == "")
			throw new Exception("empty value passed as key");
		setDeleteStatus(false);
		deleteRecursive(this.getRoot(),key);		
		if(getDeleteStatus()) {
			return true;
		}
		return false;
	}

	/*
	 * @param key, for getting value based on Key from BST
	 * @return value(ObjectType),if key found else return null
	 */
	@Override
	public String getValue(String key) throws Exception {
		if(key == null)
			throw new Exception("null value passed as key");
		if(key == "")
			throw new Exception("empty value passed as key");
		Node node = search(root, key);

		if(node!=null) {
			return node.getValue();
		}
		return null;
	}

	/*
	 * @return sortedList of key:value pair based on key
	 */
	@Override
	public List<String> getSortedList(){
		//firstly cleaning the list in which new data will store
		sortedList.clear();
		return inOrderTraversalForSortedList(this.getRoot(),null,null);
	}

	/* 
	 * method will return sorted list of key:value pair based on key condition:-for all the keys >=K1 and <=K2.
	 * @param key1
	 * @param key2
	 * @return sortedList of key:value pair based on key between key1 and key2
	 * */
	@Override
	public List<String> getSortedList(String key1,String key2) throws Exception{
		if(key1 == null || key2 == null)
			throw new Exception("null value passed as key");
		if(key1 == "" || key2 == "")
			throw new Exception("empty value passed as key");
		sortedList.clear();
		return inOrderTraversalForSortedList(this.getRoot(),key1,key2);
	}
	
	public static boolean deleteStatus=false;

	private static boolean getDeleteStatus() {
		return deleteStatus;
	}
	
	private static void setDeleteStatus(boolean deleteStatu) {
		deleteStatus = deleteStatu;
	}

	/*
	 * @param root, root of BST
	 * @param node for adding in binary 
	 * @return root, the addedNode will return or if node with same key already exist then "null" will return 
	 */
	private Node addRecursive(Node root,Node node){
		//if tree is empty
		if (root == null) { 
			root = node;
			return root; 
		} 
		//if key is larger than current node then move right of current node 
		if (node.getKey().compareTo(root.getKey())>=1) { 
			root.setRight(addRecursive(root.getRight(), node));
		}
		//if key is lesser than current node then move left of current node 
		else if(node.getKey().compareTo(root.getKey())<0) { 
			root.setLeft(addRecursive(root.getLeft(), node));
		}
		//dupicate entries are nor allowed in BSt
		else {
			return null;
		}
		return root;
	}

	/*
	 * Private helper method
	 * @param root,BST root node
	 * @param key , for deleting the node which contain this key
	 * @return root, the deleted node else "null" if node not found with given key
	 */
	private Node deleteRecursive(Node root,String key) {
		//If tree is empty
		if (root == null) 
			return root; 
		//if key is greater than current node then move right of current node 
		if (key.compareTo(root.getKey())>=1) {
			root.setRight(deleteRecursive(root.getRight(), key)); //deleteRecursive(
		}   
		//if key is lesser than current node then move left of current node 
		else if (key.compareTo(root.getKey())<0) { 
			root.setLeft(deleteRecursive(root.getLeft(), key));
		}
		// if key is same as root's key, then This is the node 
		// to be deleted 
		else
		{ 
			deleteStatus = true;//setting node deletion status
			// node with only one child or no child 
			if (root.getLeft() == null) 
				return root.getRight(); 
			else if (root.getRight() == null) 
				return root.getLeft(); 
			// node with two children: Get the inorder successor (smallest in the right subtree) 
			//setting root node as smallest node in it's right subtree
			Node root1 = (minValue(root.getRight())); 
			root.setKey(root1.getKey());
			root.setValue(root1.getValue());
			// Delete the inorder successor the smallest key value node which has put as a root node now
			root.setRight(deleteRecursive(root.getRight(), root.getKey())); 
		} 
		return root;
	}

	/*
	 * Private helper method which is returning the smallest node from the BST
	 * @param root, the root node of BST
	 * @return root, the node which contain smallest key
	 */
	private Node minValue(Node root) 
	{  
		while (root.getLeft() != null) 
		{ 
			root = root.getLeft(); 
		} 
		return root; 
	} 

	/*
	 * @param root,root node of BST
	 * @param key, the Key for which method will search node
	 * @return Node, the node which contain the given key
	 */
	private Node search(Node root, String key) 
	{ 
		// Base Cases: root is null or key is present at root 
		if (root==null || root.getKey().compareTo(key)==0) 
			return root; 
		// val is greater than root's key 
		if (key.compareTo(root.getKey())>=1) 
			return search(root.getRight(), key); 
		// val is less than root's key 
		return search(root.getLeft(), key); 
	} 

	/*
	 * this method is working for both, one is for sorted list in which limits are not given second is for where limit is given
	 * @param root, root node of the tree
	 * @param k1,key1 for lower limit 
	 * @param k2, key2 for upper limit
	 * @return sortedList
	 */
	private List<String> inOrderTraversalForSortedList(Node root,String k1,String k2) {
		if (root == null) 
			return null; 
		/* first recur on left child */
		inOrderTraversalForSortedList(root.getLeft(),k1,k2); 
		if(k1 == null && k2 == null) {
			/* then add node to List*/
			sortedList.add(root.getKey()+" : "+root.getValue());
		}else {
			String value = root.getKey();
			if(value.compareTo(k1)>=0 && value.compareTo(k2)<=0) {
				/* then add node to List*/
				sortedList.add(root.getKey()+" : "+root.getValue());
			}
		}
		/* now recur on right child */
		inOrderTraversalForSortedList(root.getRight(),k1,k2); 
		return sortedList;
	}
}
