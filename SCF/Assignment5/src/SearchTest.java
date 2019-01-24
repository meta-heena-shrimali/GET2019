import static org.junit.Assert.*;
import org.junit.Test;
public class SearchTest {
	Search s = new Search();
	
	@Test
	public void testLinearSearchEmptyArray() {
		 try {
			 s.linearSearch(new int[]{}, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Empty Array", e.getMessage());
		 }
	}
	
	@Test
	public void testLinearSearchIndexOutOfBound() {
		 try {
			 s.linearSearch(new int[]{1,2,3}, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Array Index Out Of Bound", e.getMessage());
		 }
	}
	
	@Test
	public void testLinearSearchPositiveInput() throws Exception {
		 assertEquals(2,s.linearSearch(new int[]{1,2,3,4,5},0,3));  
	}
	
	@Test
	public void testLinearSearchNegativeInput() throws Exception {
		 assertEquals(-1,s.linearSearch(new int[]{1,2,3,4,5}, 5,9));  
	}

	@Test
	public void testBinarySearchEmptyArray() {
		 try {
			 s.binarySearch(new int[]{},0, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Empty Array", e.getMessage());
		 }
	}
	
	@Test
	public void testBinarySearchIndexOutOfBound() {
		 try {
			 s.binarySearch(new int[]{1,2,3},-6, 5, 8);
		 }
		 catch (Exception e) {
			 assertEquals("Array Index Out Of Bound", e.getMessage());
		}
	}
	
	@Test
	public void testBinarySearchPositiveInput() throws Exception {
		 assertEquals(2,s.binarySearch(new int[]{1,2,3,4,5},0,5,3));  
	}
	
	@Test
	public void testBinarySearchNegativeInput() throws Exception {
		 assertEquals(-1,s.binarySearch(new int[]{1,2,3,4,5},0,5,9));  
	}
}
