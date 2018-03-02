import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class main {
	
//	
//	private String[][] board;
////	private ArrayList<String>codeNamesOnBoard;
//	private HashMap<String,Boolean>visibility;
//	private HashMap<String, String>teamCodes;
//	ArrayList<Location> boardPieces = new ArrayList<Location>() ;
//	
//	public main() {	
//		String filename = "src/GameWords.txt";		//initializes stuff
//		board = new String[5][5];
//		ArrayList<String>allCodeNames = new ArrayList<>();
//		int count = 0;
//		
//		try {
//			for(String codename : Files.readAllLines(Paths.get(filename))) {	//reads file to get all codenames
//				allCodeNames.add(codename);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Collections.shuffle(allCodeNames);	//shuffles all codenames
//		
//		for(int i = 0; i <25;i++) {
//			codeNamesOnBoard.add(allCodeNames.get(i));	//adds 25 to an Arraylist
//		}
//		
//		for(int y = 0;y<board.length;y++) {		//adds the codenames onto the playing board
//			for(int x = 0;x<board[0].length;x++) {
//				board[y][x] = codeNamesOnBoard.get(count);
//				count = count + 1;
//			}
//		}
//		
//		ArrayList<String>copy = new ArrayList<>(codeNamesOnBoard);	//creates a new arraylist that has codenamesOnBoard
//		
//		Collections.shuffle(copy);
//		for(int k = 0 ; k < 25;k++) {
//		for(int i = 0;i<9;i++) {	//adds the first 9 codenames(0-8) to hashmap under Red Team 
//			teamCodes.put(copy.get(i), "Red");
//								}
//		for(int i = 9;i<17;i++) {	//adds the next 8 codenames(9-16) to hashmap under Blue Team 
//			teamCodes.put(copy.get(i), "Blue");
//			}
//		for(int i = 17;i<24;i++) {	//adds the next 7 codenames(17-23) to hashmap under Bystander 
//			teamCodes.put(copy.get(i), "Bystander");
//			}
//		
//		teamCodes.put(copy.get(24), "Assassin");	//makes last codename the assassin
//		}
//	}
		
}
