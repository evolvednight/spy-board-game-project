import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestClass extends main{
	@Test
	public void testLlegality() { // test will only pass if there is something in allLocations arrayList
	
		main x = new main();
		
		
		boolean y  = x.Llegality("Test False");
		assertEquals(false,y);
		
	}

	@Test
	public void testLlegality2() {
		
		
		
		main x = new main();
		boolean y  = x.Llegality("TestTrue");
		assertEquals(true,y);
		
	}

}
