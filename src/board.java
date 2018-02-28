import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class board {
	
public void getCodeNames() {
	ArrayList<String> allCodeNames = new ArrayList<>() ;
	
	try {
		URI filename = null;
		for(String codename : Files.readAllLines(Paths.get(filename))) {	//reads file to get all codenames
			allCodeNames.add(codename);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
	
	
	
	
	

}
