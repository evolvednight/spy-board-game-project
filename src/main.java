import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

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
	private int numGreen;
	private int redAssassin = 0;
	private int blueAssassin = 0;
	private int greenAssassin = 0;
	@SuppressWarnings("unused")
	private int numBystander = 7;
	protected int numAssassin = 2;
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
	public int getRedAssassin() {
		return redAssassin;
	}
	public void setRedAssassin(int redAssassin) {
		this.redAssassin = redAssassin;
	}
	public int getBlueAssassin() {
		return blueAssassin;
	}
	public void setBlueAssassin(int blueAssassin) {
		this.blueAssassin = blueAssassin;
	}
	public int getGreenAssassin() {
		return greenAssassin;
	}
	public void setGreenAssassin(int greenAssassin) {
		this.greenAssassin = greenAssassin;
	}
	public void setNumBlue(int y ) {
		numBlue = y;
	}
	public void setNumGreen(int z) {
		numGreen = z;
	}
	
	public int getNumRed() {
		return numRed;
	}
	
	public int getNumBlue() {
		return numBlue;
	}
	public int getNumGreen() {
		return numGreen;
	}
	public int getNumAssassin() {
		return numAssassin;
	}
	public void setNumAssassin(int numAssassin) {
		this.numAssassin = numAssassin;
	}
	/**
	 * Returns true if the current selection is one of the current team�s agent
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
						setTurn(2);
						return false;
					}
					else
						return true;
				} else if (allLocations.get(i).getTeam() == "Green") {
					numGreen--;							// need method for keep or switch turn
					allLocations.get(i).setVisibility(true);     // change the value to face up
					if (getTurn() == 2) {
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
					else if(getTurn() == 1){
						setTurn(2);
						return false;
					}
					else if(getTurn() == 2){
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
	

	public boolean Legality(String clue) {
//		gameStart();
		String y = clue.toUpperCase();//Turns clue into Uppercase
		int checker = 0;
	
ArrayList<String> test = new ArrayList<String>();
   
		if(clue.contains(" ")) { //if clue contains a space its invalid
			return false;
		}

		for(Location z : allLocations) {
		
			test.add(z.getCodeName());
			
		}
		for(int i = 0;i<test.size();i++){
			if(y.contains(test.get(i))){
				checker++;
			}
		}
		if(checker > 0) {
			return false;
		}
		else {
			return true;
		}
		}

	public boolean legalityNum(int x) {
		if( x > 0 && x <= 9) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean legalityNumThree(int x) {
		if( x > 0 && x <= 6) {
			return true;
		}
		else {
			return false;
		}
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

	public boolean winningStateThreeTeam() { //Determines whether the game is in winning state
		if(numRed != 0 && numBlue != 0) {
			if(numGreen == 0) {
	
	
			System.out.println("Green team wins!");
			return true;
			}
		}
		else if(numRed == 0 && numBlue != 0) {
			if(numGreen !=0) {
		
			System.out.println("Red team wins!");
			return true;
		}
			}
		else if(numBlue == 0 && numRed != 0) {
				if(numGreen != 0) {
			System.out.println("Blue Team wins!");
			return true;
				}
		}
		else if (numRed != 0 && numBlue != 0){
			if(numGreen != 0) {
			return false;
		}
		}
		return false;
	}

 
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
	
	public int assWinThree() {
		int potato = -1;
			
		if(numAssassin == 0){
			if(greenAssassin == 0){
				potato = 2;
			}
			else if(redAssassin == 0){
				potato = 1;
			}
			else{
				potato = 0;
			}
		}
		
		return potato;
		}
	
	public String whoElim() {
		String potato = "";
		if(redAssassin == 1) {
			potato = potato + " Red Team";
		}
		if(blueAssassin == 1) {
			potato = potato + " Blue Team";
		}
		if(greenAssassin == 1) {
			potato = potato + " Green Team";
		}	
		return potato;
	}







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
		setNumRed(9);
		setNumBlue(8);
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
	}
		
		
		
		public void gameStartThreeTeam() {
			setNumRed(6);
			setNumBlue(5);
			setNumGreen(5);
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

			for(int i = 0;i<6;i++) {	//adds the first 6 codenames(0-5) to ArrayList under Red Team 
				Location temp = new Location(false,codeNamesOnBoard.get(i),"Red");
				tempArr.add(temp);
			}
			for(int i = 6;i<11;i++) {	//adds the next 8 codenames(9-16) to ArrayList under Blue Team 
				Location temp = new Location(false,codeNamesOnBoard.get(i),"Blue");
				tempArr.add(temp);
			}
			for(int i = 11;i<16;i++) {	//adds the next 7 codenames(17-23) to ArrayList under Green Team 
				Location temp = new Location(false,codeNamesOnBoard.get(i),"Green");
				tempArr.add(temp);
			}
			for(int i = 16;i<23;i++) {	//adds the next 7 codenames(17-23) to ArrayList under bystander
				Location temp = new Location(false,codeNamesOnBoard.get(i),"Bystander");
				tempArr.add(temp);
			}

			for(int i = 23;i<25;i++) {	//adds the next 7 codenames(17-23) to ArrayList under Assassin
				Location temp = new Location(false,codeNamesOnBoard.get(i),"Assassin");
				tempArr.add(temp);
			}
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
