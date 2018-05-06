import static org.junit.Assert.assertEquals;



//import java.util.ArrayList;

import org.junit.Test;



public class TestClassThree extends main{
	@Test
	public void testLlegality() { // test will only pass if there is something in allLocations arrayList
	
		main x = new main();
		
		boolean y  = x.Legality("Test False");
		assertEquals(false,y);
		
	}

	@Test
	public void testLegality2() {
		
		
		
		main x = new main();
		boolean y  = x.Legality("TestTrue");
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
	public void testWinningStateThree1() {
		setNumRed(2);
		setNumGreen(0);
		setNumBlue(2);
		assertEquals(true, winningStateThreeTeam());
		
	}
	@Test
	public void testWinningStateThree2() {
		setNumRed(0);
		setNumGreen(1);
		setNumBlue(2);
		assertEquals(true, winningStateThreeTeam());
		
	}
	@Test
	public void testWinningStateThree3() {
		setNumRed(2);
		setNumGreen(2);
		setNumBlue(0);
		assertEquals(true, winningStateThreeTeam());
		
	}
	@Test
	public void assWinThreeTest1() {
		setNumAssassin(0);
		
		setRedAssassin(1);
		setBlueAssassin(0);
		setGreenAssassin(1);
		
		assertEquals(0,assWinThree());
		
		
	}
	@Test
	public void assWinThreeTest2() {
		setNumAssassin(0);
		
		setRedAssassin(1);
		setBlueAssassin(1);
		setGreenAssassin(0);
		
		assertEquals(2,assWinThree());
		
		
	}
	@Test
	public void assWinThreeTest3() {
		setNumAssassin(0);
		
		setRedAssassin(0);
		setBlueAssassin(1);
		setGreenAssassin(1);
		
		assertEquals(1,assWinThree());
		
		
	}
	@Test
	public void testWhoWonWhenAss() {
		
		numAssassin = 0; /// SET THE ASSASIN to 1
		setTurn(1); // set turn to 1 aka  red ;
		
		assertEquals(true, whoWonWhenAss()) ;
		
	}

}