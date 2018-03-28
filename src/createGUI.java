import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class createGUI {
	
	
	public static void main(String[] args) {
	
	JFrame x1 = new JFrame("CodeName game");
	x1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	x1.setSize(1500,1500);
	
	GridLayout inX = new GridLayout(7,5,20,20);
	x1.setLayout(inX);
	
	x1.add(new JButton("restart"));
	
	//hasan
	JButton tend = new JButton("End turn") ;// lets make this the the button that ends turns
	x1.add(tend);
	int gg = 1 ;//set this equal to the count getter
	if(gg== 0) { tend.doClick(); } // ends turn when clue count is  0 
	//end
	
	
	
	//easter egg field
	JTextArea easterEgg = new JTextArea();
	easterEgg.setText("**MAYBE** put easterEgg here");
	x1.add(easterEgg);
	//instruction here
	JTextArea instruction = new JTextArea();
	instruction.setText("this is a game of codeName which model after the codename board game");
	x1.add(instruction);

	JTextArea instruction2 = new JTextArea();
	instruction2.setText("More Instructions");
	x1.add(instruction2);

	JTextArea countField = new JTextArea();
	countField.setText("this field is for red and blue counter");
	x1.add(countField); 
	
	//hasan
	JTextArea clueAndCount = new JTextArea() ;
	String x = "set equal to clue getter, " ;//need getters
	String g = "set equal to number of cards the clue applies to" ;//need getters
	clueAndCount.setText(x + g);
	x1.add(clueAndCount);
	//end 
	
	
	
	for (int i = 0; i<25; i++) {
		String temp = "codeName card"+ i;
		x1.add(new JButton(temp));
	}
	x1.add(new JButton("End Game"));
	
	x1.setVisible(true);
	}
}
