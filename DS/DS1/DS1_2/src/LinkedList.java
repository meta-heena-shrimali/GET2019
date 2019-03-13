public class LinkedList 
{ 
    Node head;  
    /*
     * @param L of type integer that specify left end of the sublist in the list
     * @param R of type integer that specify right end of the sublist in the list
     * @param N of type integer that specify number of rotations that has to be made in the sublist
     */
    void rotate(Integer L, Integer R, Integer N) throws Exception 
    {  
    	Node sublistStart = head,left=head ,right=head, rotationPoint, temp;
	   int count=1, rotation;
	   	if(head==null)
        	throw new Exception("Cant rotate empty list");
	   	if(head.next==null)
        	throw new Exception("Cant rotate only one node in the list");
    	if(L == null || R == null || N == null)
    		throw new Exception("Null value passed as parameter in method rotate");
    	 
    	for(Node start = head ; start != null; start = start.next)
    		 	count++;
    	 if(L < 1 || R > count || L > R || R< 1)
    		 throw new Exception("Out Of Bound Left Right Parameter For SubList");
    	 if( N < 0 )
    		 throw new Exception("invalid number of rotations");
    	 
    	 count=1;
	   while(L != count)
	   {
		   if(left==null)
			   break;
		   left=left.next;
		   count++;
	   }
	   
	   if(left!=head)
		   while(sublistStart.next != left)
			   sublistStart=sublistStart.next; 
	  
	   count=1;
	   while( R != count)
	   {
		   if(right==null)
			   break;
		   right=right.next;
		   count++;
	   }
	   
	   rotation = N % (R+1-L);
	   rotation=(R+1-L)-rotation;
	   
	   count=1;
	   rotationPoint=left; 
	   while( rotation != count && rotationPoint.next != right )
	   {
		  rotationPoint=rotationPoint.next;
		   count++;	  
	   }
	
	   temp=rotationPoint.next;
	   rotationPoint.next=right.next;
	   right.next=left;
	   if(L!=1)
	   sublistStart.next=temp; 
	   else if(L==1)
	   {
		   left=temp;
		   head=left;
	   }
    } 
    /* 
     * Inserts at front of the list.
     *@param data of type Integer  
     */
    void push(Integer data) throws Exception 
    {         
    	 if(data ==null)
         	throw new Exception("null value passed node can't be created");
    	Node node = new Node(data); 
        node.next = head; 
        head = node; 
    }
    
    String getList()
    {
    	Node start = head;  
        String Slist = null;
        while(start != null) 
        { 
            Slist+=start.data+" --> "; 
            start = start.next; 
        }
		return Slist; 
    }
    
    void traverse() throws Exception 
    { 
        Node start = head; 
        if(start==null)
        	throw new Exception("Cant traverse empty list");
        while(start != null) 
        { 
            System.out.print(start.data+" --> "); 
            start = start.next; 
        } 
        System.out.println(); 
    } 
  /*
    public static void main(String args[]) 
    { 
        LinkedList list = new LinkedList(); 
       for (int i = 60; i >= 10; i -= 10) 
            list.push(i); 
  
        System.out.println("Given list"); 
        list.traverse(); 
  
        list.rotate(1,5,2); 
  
        System.out.println("Rotated Linked List"); 
        list.traverse(); 
    }
    */ 
} 