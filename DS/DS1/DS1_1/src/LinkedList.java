class LinkedList 
{ 
    Node head;

    /* 
     * Inserts at front of the list.
     *@param data of type Integer  
     */
    public void push(Integer data) throws Exception 
    { 
        if( data == null )
        	throw new Exception("null value passed node can't be created");
        
        Node node = new Node(data);  
        node.next = head; 
        head = node; 
    } 
  
    public void traverse() throws Exception
    {
    	if(head == null)
            throw new Exception("Empty List can't traverse");
    	Node start = head;
    	System.out.println(" Linked List is ::");
    	while(start != null){
    		System.out.print(" "+start.data+" --> ");
    		start=start.next;
    	}
    		
    }
    
    /* 
     * Create loop in the list by joining the last element to the specified node
     *@param data of type Integer  
     */
    public boolean createLoop(Integer data) throws Exception
    {
    	Node end = head, temp = null;
    	if( data == null )
        	throw new Exception("null value passed loop can't be created ");
    	if(detectLoop())
    		throw new Exception("loop already exist");
    	while(end.next != null)
    	{
    		if(end.data == data)
    		{
    			temp=end;
    		}
    		end=end.next;
    		
    	}
    	if(temp != null)
    	{
    		end.next=temp;
    		return true;
    	}
    	
    	else
    		throw new Exception("No Such Element In List before the last element");
    }
    
    /*
     * detect loop in the list
     */
    boolean detectLoop() throws Exception 
    { 
        Node pointer_behind = head, pointer_ahead = head; 
        if(head == null)
            throw new Exception("Empty List can't detect loop");
        while (pointer_behind != null && pointer_ahead != null && pointer_ahead.next != null) 
        { 
        	pointer_behind = pointer_behind.next; 
        	pointer_ahead = pointer_ahead.next.next; 
            if (pointer_behind == pointer_ahead) 
                return true;    
        } 
        return false; 
    } 
/*
    public static void main(String args[]) throws Exception 
    { 
        LinkedList list = new LinkedList(); 
  
        list.push(20); 
        list.push(4); 
        list.push(15); 
        list.push(10); 
          
        list.traverse();
       
        if(list.createLoop(10))
        	System.out.println("Loop created");
        else
    		System.out.println("Loop can not be created ");
        if(list.detectLoop()) 
        	System.out.println("Found loop");
        else
    		System.out.println("No Loop Found");
       
       //loop already exist  
        
        if(list.createLoop(20))
        	System.out.println("Loop created");
        else
    		System.out.println("Loop can not be created ");
        if(list.detectLoop()) 
        	System.out.println("Found loop");
        else
    		System.out.println("No Loop Found");
        
        //data not in list
        if(list.createLoop(55))
        	System.out.println("Loop created");
        else
    		System.out.println("Loop can not be created ");
        if(list.detectLoop()) 
        	System.out.println("Found loop");
        else
    		System.out.println("No Loop Found");
    	
    }
   */ 
}  