package dictionary;
/**
 *  Class Node to store data in BST
 */
public class Node {
	
	String key;
	String value;
	Node left;
	Node right;
	
	/*
	 * Constructor
	 * Node for storing a key value pair in dictionary
	 * @param key
	 * @param value
	 */
	public Node(String key,String value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
