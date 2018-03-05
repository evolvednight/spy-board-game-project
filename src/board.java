import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class board {
	
	private int turn = 1; 		//1 is red turns, 0 is blue turn
	protected ArrayList<Location>allLocations  = new ArrayList<Location>();
	protected ArrayList<String>codeNamesOnBoard = new ArrayList<String>();
	
	
	
public board() {
//allLocations = new ArrayList<Location>();
//allLocations.add(new Location(true, "Test", "Red"));
//	Assigning test = new Assigning();
//	test.gameStart();

	
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



public ArrayList<String> getCodeNamesOnBoard(){
	return codeNamesOnBoard;
}

//public void setLocations(ArrayList<Location>x) {
//	allLocations = x;
//}


	

}
