import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.HashMap;

public class main extends board{
	// TODO Auto-generated constructor stub



	protected board something;






	// Edwin: code need correction
	private int numRed;			//declare numbers of all different character for count purpose
	private int numBlue;
	@SuppressWarnings("unused")
	private int numBystander = 7;
	protected int numAssassin = 1;
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
	public void setNumRed(int x) {
		numRed = x;
	}
	public void setNumBlue(int y ) {
		numBlue = y;
	}

	/**
	 * Returns true if the current selection is one of the current team’s agent
	 * this method decrement the count of each team when the codename was selected
	 *
	 *@author Edwin Hung
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return true    if the location does contain current team agent
	 * @return false   if the location does not contain current team agent
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






	/**
	 * @author Austin Van Dood			
	 * @param clue-string of a clue used in game
	 * @return-boolean whether clue is legal
	 */



	public boolean Llegality(String clue) {
		gameStart();
		String x = clue.toLowerCase();//Turns clue into Lowercase
		String y = clue.toUpperCase();//Turns clue into Uppercase

		if(clue.contains(" ")) { //if clue contains a space its invalid
			return false;
		}

		for( int i = 0 ; i< allLocations.size(); i++) {
			//System.out.println(allLocations.get(i));
			if(allLocations.get(i).getCodeName() == x && allLocations.get(i).getVisibility() == false) {
				return false;
			}
			else if(allLocations.get(i).getCodeName() == y && allLocations.get(i).getVisibility() == false){
				return false;
			}
		}// if clue is the same as a codename but has not been revealed its invalid 

		return true;

	}

	/**
	 * 
	 *@author Edwin Medrano-Abzun 
	 * WinningState deteremines whether the game board is in a "winning state"
	 *there is three conditions that it checks for, 
	 *whether blue or red is equal to zero it will 
	 *@return true
	 *anything else it will 
	 *@return false 
	 *
	 */


 
	public boolean winningState() { //Determines whether the game is in winning state
		if(numRed == 0 && numBlue != 0) {
			System.out.println("Red team wins!");
			return true;

		}
		else if(numBlue == 0 && numRed != 0) {
			System.out.println("Blue Team wins!");
			return true;

		}
		else if (numRed != 0 && numBlue != 0){
			return false;
		}
		return false;
	}

	/**
	 * @author Hasan
	 * Checks if the assassin location was picked and determines if the game should be ended, and if so
	 * which team has won
	 * 
	 * @return false if assassin was not picked
	 * @return true if assassin was found and prints which team won
	 */



	public boolean whoWonWhenAss() { 
		//		int turn = 1 ; //delete later
		//		int numAssassin = 1 ; // delete later
		int xturn = getTurn();

		int checkass = numAssassin ;

		String red = "Team Red" ;
		String blue = "Team blue" ;
		String pwin = "";

		if (checkass == 0 ) {

			if (xturn == 1) {	
				pwin = blue ;	
			}
			else if (xturn == 0) {
				pwin = red ;
			}

			System.out.println(pwin + " wins!!") ; // prints who wins

			return true; 
			//
		}else {//does nothing game keeps going//
			return false ;
		}



	}
	//End of Austins Code







	/**
	 *
	 *Reads through a file, randomizes and selects 25 codenames, selects a team for each codename,
	 *adds it into an arraylist which will be used to keep track of each location
	 *
	 *@author-Musaiyab Ali
	 *@param no parameters
	 *@return nothing
	 *
	 */ 
	public void gameStart() {
		String filename = "src/GameWords1.txt";
		ArrayList<String>allCodeNames = new ArrayList<>();

		try {
			for(String codename : Files.readAllLines(Paths.get(filename))) {	//reads file to get all codenames
				allCodeNames.add(codename);
			}
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Collections.shuffle(allCodeNames);	//shuffles all codenames

		for(int i = 0; i <25;i++) {
			codeNamesOnBoard.add(allCodeNames.get(i));	//adds 25 to an Arraylist
		}
		Collections.shuffle(codeNamesOnBoard);		//reshuffles arraylist with all codenames in use

		ArrayList<Location>tempArr = new ArrayList<Location>();

		for(int i = 0;i<9;i++) {	//adds the first 9 codenames(0-8) to ArrayList under Red Team 
			Location temp = new Location(false,codeNamesOnBoard.get(i),"Red");
			tempArr.add(temp);
		}
		for(int i = 9;i<17;i++) {	//adds the next 8 codenames(9-16) to ArrayList under Blue Team 
			Location temp = new Location(false,codeNamesOnBoard.get(i),"Blue");
			tempArr.add(temp);
		}
		for(int i = 17;i<24;i++) {	//adds the next 7 codenames(17-23) to ArrayList under Bystander 
			Location temp = new Location(false,codeNamesOnBoard.get(i),"Bystander");
			tempArr.add(temp);
		}

		Location temp = new Location(false,codeNamesOnBoard.get(24),"Assassin");
		tempArr.add(temp);	//makes last codename the assassin
		Collections.shuffle(tempArr);



		allLocations = tempArr;
//		for(int i = 0; i<25; i++) {
//			System.out.print(allLocations.get(i).getTeam());
		}
//		System.out.println("");
		//		for(Location i : temp) {
		//			allLocations.add(i);
		//		}

		//		for(int i = 0;i<tempArr.size();i++) {
		//			allLocations.add(tempArr.get(i));
		//		}
		//sets local field ArrayList values to newly initialized locations
	



	public ArrayList<String> getCodeNamesOnBoard(){
		return codeNamesOnBoard;
		
	}
	



}






