

import java.util.ArrayList;

public class board{
	
	protected int turn = 1; 		//1 is red turns, 0 is blue turn
	protected ArrayList<Location>allLocations  = new ArrayList<Location>();
	protected ArrayList<String>codeNamesOnBoard = new ArrayList<String>();
	
	
	
public board() {
//allLocations = new ArrayList<Location>();
//allLocations.add(new Location(true, "Test", "Red"));
//	Assigning test = new Assigning();
//	test.gameStart();
	//hh

	
}
	
public ArrayList<Location> getLocations(){
	return allLocations;
}

public void setLocations(ArrayList<Location>potato) {
	allLocations = potato;
}

public int getTurn() {
	return turn;
}

public void setTurn(int x) {
	turn = x;
}
public void changeTurn() {
	if (turn == 0) { 
		turn = 1 ;
	}else { 
		turn = 0 ;
	}
	
}
public void changeTurn3() {
	main a = new main();

	if (turn != 2) {
		turn++;
	} else {
		turn = 0;
	}
	if (a.getBlueAssassin() == 1 || a.getRedAssassin() == 1 || a.getGreenAssassin() ==1) {
		if (a.getBlueAssassin() == 1 && turn == 0) {
			turn++;
		}
		if (a.getRedAssassin() == 1 && turn == 1) {
			turn++;
		}
		if (a.getGreenAssassin() == 1 && turn == 2) {
			turn = 0;
		}
	} else {
	}
}


public ArrayList<String> getCodeNamesOnBoard(){
	return codeNamesOnBoard;
}

//public void setLocations(ArrayList<Location>x) {
//	allLocations = x;
//}


	

}