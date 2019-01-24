import static org.junit.Assert.*;
import org.junit.Test;
public class LcmHcfTest {
	LcmHcf lh = new LcmHcf();
	
	@Test
	public void testFindHcf() {
		 try {
			 lh.findHcf(0, 0);
		 }
		 catch (Exception e) {
			 assertEquals("Divide By Zero", e.getMessage());
		 }
	}
	
	@Test
	public void testFindHcfPositiveInput() throws Exception {
		 assertEquals(2,lh.findHcf(6,8));  
	}

	@Test
	public void testFindLcm() {
		try { 
			lh.findLcm(0, 0);
		}
		catch (Exception e) {
			assertEquals("Divide By Zero", e.getMessage());
		}
	}
	
	@Test
	public void testFindLcmPositiveInput() throws Exception {
		assertEquals(24,lh.findLcm(6,8));
	}

}
