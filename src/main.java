import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class main extends board{
	// Edwin: code need correction
			private int numRed = 9;			//declare numbers of all different character for count purpose
			private int numBlue = 8;
			private int numBystander = 7;
			private int numAssassin = 1;
			/*
			Scanner choiceRed = new Scanner(System.in);
			System.out.println("Player1 please type in your choice");
			String cRed = choiceRed.nextLine();
			allRed.add(cRed);
			checkSelection();
			// HAVE TO IMPLEMENT ALL METHODS HERE to check winning state
			Scanner choiceBlue = new Scanner(System.in);
			System.out.println("Player2 please type in your choice");
			String cBlue = choiceBlue.nextLine();
			allBlue.add(cBlue);
			checkSelection();
			// HAVE TO IMPLEMENT ALL METHODS HERE to check winning state
			// pop cRed into array for all red choices
			 */
			/*
			for (int i = 0; i<25 ; i++) {
				visibility.put(copy.get(i), false); //all false values are not visible	
			}
			*/
			public boolean checkSelection(String locationx) { //locationx = selected piece
				
				for (int i = 0; i<25; i++) {
					if (locationx == allLocations.get(i).getCodeName()) {
						if (allLocations.get(i).getTeam() == "Red") {
							numRed--;							// need method for keep or switch turn
							allLocations.get(i).setVisibility(true);      // change the value to face up
							if (getTurn() == 0){
								setTurn(1);
								return false;
							} else
								return true;
						} else if (allLocations.get(i).getTeam() == "Blue") {
							numBlue--;							// need method for keep or switch turn
							allLocations.get(i).setVisibility(true);     // change the value to face up
							if (getTurn() == 1) {
								setTurn(0);
								return false;
							}
							else
								return true;
						} else if (allLocations.get(i).getTeam() == "Bystander") {
							numBystander--;						// need method for keep or switch turn
							allLocations.get(i).setVisibility(true);      // change the value to face up
							if (getTurn() == 0){
								setTurn(1);
								return false;
							}
							else {
								setTurn(0);
								return false;
							}
						} else if (allLocations.get(i).getTeam() == "Assassin") {
							numAssassin--;
							allLocations.get(i).setVisibility(true); // change the value to face up
							return false;
						}
					} else {
						System.out.println("incorrect selection"); // need method for keep turn
					} 
				}
				return false;
			}  // end of edwin's code.
		

 public boolean Llegality(String clue) {
	String x = clue.toLowerCase();
	String y = clue.toUpperCase();
	for( int i = 0 ; i< allLocations.size(); i++) {
	if(allLocations.get(i).getCodeName() == x && allLocations.get(i).getVisibility() == false) {
		return false;
	}
		else if(allLocations.get(i).getCodeName() == y && allLocations.get(i).getVisibility() == false){
				return false;
			}
	
		else if(clue.contains(" ")) {
			return false;
		}
		}
return true;
}
 }
//End of Austins Code
	
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
