/**
 * Implement the immutable class intSet using an array to represent a set of integers in the range 1-1000
 *  @author HP
 */
import java.util.ArrayList;

public final class InSet {

	private final int set[];
	
	public InSet(int a[]) throws Exception{
		this.set = new int[a.length];
		for(int i = 0;i < a.length ; i++)
		{
			if(a[i]<0 || a[i]>1000)
				throw new Exception("Value out of range");
			set[i] = a[i];
		}
	}
	
	/*
	 * @param x element to be check in set
	 * @return true if element found else return false
	 */
	public boolean isMember(int x) throws Exception {
		for(int i = 0 ; i < set.length ; i++)
			if(set[i] == x)
				return true;
		return false;  
	}
	
	/*
	 * @return size of the set
	 */
	public int size() throws Exception{	
		return set.length;  
	}
	
	/*
	 * @param InSet s is the object to check the subset
	 * @return true if it is a subset else false
	 */
	public boolean isSubSet( InSet s) throws Exception {	
		int len = set.length-s.set.length , j;
		for(int i = 0 ; i < len ; i++)
		{
			for( j = 0 ; j < s.set.length ; j++)
			{
				if(set[i] == s.set[j])
					break;
			}
			if(j == s.set.length && s.set.length!=0)
				return false;
		}	
		return true;  
	}
	
	/*
	 * 	 * @return complement set of the given set
	 */
	public int[] getComplement() throws Exception {
		int carray[] = new int[1000-set.length] , f , index = 0;
		for(int i = 0 ; i < 1000 ; i++)
		{
			f = 0;
			for(int j = 0 ; j < set.length ; j++)
			{
				if(set[j] == i)
				{
					f = 1;
					break;
				}		
			}
			if(f == 0)
			{
				carray[index] = i;
				index++;
			}
		}
		return carray;
		
	}
	
	/*
	 * @param InSet s1 , @param InSet s2  are taken to find the union of the sets
	 * @return union set of the given two sets.
	 */	
	public int[] unionSet(InSet s1, InSet s2) throws Exception{
		
		int f = 0, j , i ;
		ArrayList<Integer> carray=new ArrayList<Integer>();
		for(i = 0 ; i < s1.set.length ; i++)
		{
			carray.add(s1.set[i]);
			 
		}
		int index = s1.set.length;
		for(i = 0 ; i < s2.set.length ; i++)
		{
			for(j = 0 ; j < s1.set.length ; j++)
			{
				if(s2.set[i] != s1.set[j])
				{
					f = 1;
				}
				else
				{
					f = 0;
					break;
				}
			}
			if(f == 1)
			{	
				carray.add(s2.set[i]);
				
			}
		}
		int[] unionset = new int[carray.size()];
	    for (i=0; i < unionset.length; i++)
	    {
	        unionset[i] = carray.get(i).intValue();
	    }
		return unionset;
	}
	
}
