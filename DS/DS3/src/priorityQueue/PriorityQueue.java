package priorityQueue;

class PriorityQueue
{
    private Process[][] processQueue; 
	private int capacity;
	private int maxPriority;
	private int frontPointers[], rearPointers[];
 
    public PriorityQueue(Integer capacity, Integer maxPriority) throws Exception
    {    
        if(capacity == null || maxPriority == null)
        	throw new Exception(" Null value passed in constructor");
        if(capacity <= 0 || maxPriority <= 0)
        	throw new Exception(" Invalid value passed in constructor");
    	this.capacity = capacity;
    	this.maxPriority=maxPriority;
        processQueue = new Process[maxPriority][capacity];
        rearPointers = new int[maxPriority];
        frontPointers = new int[maxPriority];
        for(int i=0;i<maxPriority;i++){
        	frontPointers[i] = rearPointers[i] = -1;
        }
    }
    
    public boolean enqueue(String name, String description, Integer priority) throws Exception
    {
    	 if(name == null || priority == null || description == null)
         	throw new Exception(" Null value passed as input");
         if(priority < 0 || priority >= maxPriority)
         	throw new Exception(" Invalid value passed as priority");
         if(name.length() == 0 || description.length() == 0 )
          	throw new Exception(" Empty string passed as input");
		 if(rearPointers[priority] == capacity-1)
			throw new Exception("Queue of Priority "+priority+" overflow ");
		else
		{
			rearPointers[priority]++;
			Process p = new Process(name, description);
			processQueue[priority][rearPointers[priority]] = p;
			//System.out.println(" Enqueue process is : "+p.toString());
			return true;
		}
		
    }
   
    public Process dequeue(Integer priority) throws Exception
    {
    	 if( priority == null )
         	throw new Exception(" Null value passed as input for priority");
         if(priority < 0 || priority >= maxPriority)
         	throw new Exception(" Invalid value passed as priority");
        
		if(rearPointers[priority] == frontPointers[priority])
			throw new Exception("Queue of Priority "+priority+" underflow ");
		else
		{
			frontPointers[priority]++;
			Process p = processQueue[priority][frontPointers[priority]];
			//System.out.println(" Dequeue Element is : "+p.toString());
			return p;
		}
			
    }
   
    public void traverse(Integer priority) throws Exception
    {   
    	 if( priority == null )
          	throw new Exception(" Null value passed as input for priority");
         if(priority < 0 || priority >= maxPriority)
          	throw new Exception(" Invalid value passed as priority"); 
         if(rearPointers[priority] == frontPointers[priority])
			throw new Exception("Queue of Priority "+priority+" underflow ");
    	for(Process p: processQueue[priority]) 
    	{
    			System.out.println(p.toString());
    	}
    }
}
 

