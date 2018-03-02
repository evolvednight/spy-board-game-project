import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Assigning extends board{
	
	public void gameStart() {
		String filename = "src/GameWords.txt";
		ArrayList<String>allCodeNames = new ArrayList<>();
		
		try {
			for(String codename : Files.readAllLines(Paths.get(filename))) {	//reads file to get all codenames
				allCodeNames.add(codename);
			}
		} catch (IOException e) {
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
		
		allLocations = tempArr;	//sets local field ArrayList values to newly initialized locations
		}
		
	
	
	public ArrayList<String> getCodeNamesOnBoard(){
		return codeNamesOnBoard;
	}
	
	

}
