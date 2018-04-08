import static org.junit.Assert.assertEquals;

//import java.util.ArrayList;

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
		x.gameStart();
		String i = "";
		boolean y  = x.checkSelection(i);
		assertEquals(false,y);
	}
	@Test
	public void checkTrueSelection() {
		main x = new main();
		x.gameStart();
		String i = x.getCodeNamesOnBoard().get(2);
		boolean y  = x.checkSelection(i);	
	assertEquals(true,y);
	}
	@Test
	public void checkFalseSelection() {
	main x = new main();
	x.gameStart();
	String i = x.getCodeNamesOnBoard().get(10);
	boolean y  = x.checkSelection(i);
	assertEquals(false,y);
	
	}
	@Test
	public void testWinningState1() {
		setNumRed(0);
		setNumBlue(8);
		assertEquals(true, winningState() );
		
	}
	@Test
	public void testWinningState2() {
		setNumRed(7);
		setNumBlue(0);
		assertEquals(true, winningState() );
		
	}
	@Test
	public void testWinningState3() {
		setNumRed(6);
		setNumBlue(3);
		assertEquals(false, winningState() );
	}
	@Test
	public void testWhoWonWhenAss() {
		
		main kk = new main() ;
		numAssassin = 0; /// SET THE ASSASIN to 1
		setTurn(1); // set turn to 1 aka  red ;
		
		assertEquals(true, kk.whoWonWhenAss()) ;
		
	}

}
