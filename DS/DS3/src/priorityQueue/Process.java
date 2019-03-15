package priorityQueue;

public class Process {
	 String name;
	    String Description;
	 
	    public Process(String name, String Description)
	    {
	        this.name = name;
	        this.Description = Description; 
	    }
	    
	    public String toString() 
	    {
	        return "Job Name : "+ name +"\nDescription : "+ Description;
	    }
}
