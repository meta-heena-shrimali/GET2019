import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InSetTest {

	// test of set values out of range
	@Test
	public void testSet_Out_Range() {
		 try {
			 InSet setarray= new InSet( new int[]{-1,1002});
		 }
		 catch (Exception e) {
			 assertEquals("Value out of range", e.getMessage());
		 }
	}
	
	// positive test case for determining size of set 
	@Test
	public void testLength()throws Exception  {
		 
			 InSet setarray= new InSet( new int[]{6,7,8,10});
			 int returnedValue =setarray.size(); 
			 int expectedValue = 4;
			 Assert.assertEquals( expectedValue, returnedValue );
	}
	
	// positive test case to check if the number is member of set 
	@Test
	public void testFind_Value_Positive() throws Exception {
			 InSet setarray= new InSet( new int[]{1,2,3,4,5});
			 assertTrue(setarray.isMember(4) );	 
	}

	// negative test case to check if the number is member of set
	@Test
	public void testFind_Value_Negative() throws Exception {
			 InSet setarray= new InSet( new int[]{1,2,3,4,5});
			 assertFalse(setarray.isMember(8) );	 
	}
	
	//positive test to check if given array is a subset 
	 @Test
	   public void test_Is_Subset_Positive() throws Exception{	
		 InSet setarray= new InSet( new int[]{1,2,3,4,5});
		 InSet subsetarray= new InSet( new int[]{1,2,3});
		 assertTrue(setarray.isSubSet(subsetarray));	   
	   }
	 
	//negative test to check if given array is a subset 	 
	 @Test
	   public void test_Is_Subset_Negative() throws Exception{	
		 InSet setarray= new InSet( new int[]{1,2,3,4,5});
		 InSet subsetarray= new InSet( new int[]{7,8});
		 assertFalse(setarray.isSubSet(subsetarray));	   
	   }
	 
	//test to check if null set is a subset
	 @Test
	   public void test_Is_Subset_Null() throws Exception{	
		 InSet setarray= new InSet( new int[]{1,2,3,4,5});
		 InSet subsetarray= new InSet( new int[]{});
		 assertTrue(setarray.isSubSet(subsetarray));	   
	   }
	
	//positive test for union operation of sets
	 @Test
	   public void test_Union_Set_Same() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{1,2,3});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
	 
	 @Test
	   public void test_Union_Set_Diff() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{4,5,6});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3,4,5,6};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }

	 @Test
	   public void test_Union_Set_Mix() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{2,3,5,6});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3,5,6};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
	 
	 @Test
	   public void test_Union_Set_Null() throws Exception{
		 InSet setarray1= new InSet( new int[]{1,2,3});
		 InSet setarray2= new InSet( new int[]{});
		 int returnedArrOperation[] =setarray1.unionSet(setarray1,setarray2); 
		 int []expectedArr = new int[] {1,2,3};
		 Assert.assertArrayEquals( expectedArr, returnedArrOperation );
	   }
}
