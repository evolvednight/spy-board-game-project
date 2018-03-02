import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class board {
	
	private int turn = 1; 		//1 is red turns, 0 is blue turn
	protected ArrayList<Location>allLocations;
	protected ArrayList<String>codeNamesOnBoard;
	
	
public board() {
	allLocations = new ArrayList<Location>();
}
	
public ArrayList<Location> getLocations(){
	return allLocations;
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
