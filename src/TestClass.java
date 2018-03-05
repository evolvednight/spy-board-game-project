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
	@Test
	public void checkInvalid() {
		main x = new main();


		boolean y  = x.checkSelection("AFRICA");
		assertEquals(false,y);
	}
	@Test
	public void checkTrueSelection() {
	main x = new main();

	boolean y  = x.checkSelection("");
	assertEquals(false,y);
	}
	@Test
	public void check() {
	main x = new main();

	boolean y  = x.checkSelection("usa");
	assertEquals(true,y);
	
	}

}
