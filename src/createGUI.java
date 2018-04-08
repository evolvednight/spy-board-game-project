import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class createGUI {
	
	
	public static void main(String[] args) {
		main m = new main();
		ActionListner r = new ActionListner();
//		board b = new board();
		m.gameStart();
//		System.out.println(m.codeNamesOnBoard);
//		System.out.println(b.allLocations);
//		System.out.println(b.tempArr);

		
		
		
		
		JFrame x1 = new JFrame("CodeName game");
		x1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x1.setSize(1500,1500);
		GridLayout inX = new GridLayout(7,5,20,20);
		x1.setLayout(inX);
//		JPanel panel = new JPanel();
//		panel.setPreferredSize(new Dimension(300,300));
//		panel.setMinimumSize(new Dimension(150,150));
//		panel.setMaximumSize(new Dimension(450,450));

		x1.add(new JButton("restart"));
		
		JButton Spy = new JButton( "Spy Master");
		Spy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame x2 = new JFrame("Spy Master Window");
				x2.setSize(750, 750);
				GridLayout inY = new GridLayout(5,5, 20, 20);
				x2.setLayout(inY);
				for( int i = 0; i<25 ; i++) {
					String temp = m.codeNamesOnBoard.get(i);
					JButton j = new JButton(temp);
					if(m.allLocations.get(i).getTeam() == "Red") {
						j.setBackground(Color.RED);
					}
					else if( m.allLocations.get(i).getTeam() == "Blue") {
						j.setBackground(Color.BLUE);
					}
					else if ( m.allLocations.get(i).getTeam() == "Bystander") {
						j.setBackground(Color.YELLOW);
					}
					else if ( m.allLocations.get(i).getTeam() == "Assassin") {
						j.setBackground(Color.GREEN);
					}
					x2.add(j);

				}
				x2.setVisible(true);
			}
		}
			);
		x1.add(Spy);

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
//		for (int i = 0; i < 25; i++) {
//			String temp = "codaname " +i;
//			x1.add(new JButton(temp));
//		}
//		

		
		
		
		
		for( int i = 0; i<25 ; i++) {
			String temp = m.codeNamesOnBoard.get(i);
			JButton j = new JButton(temp);
//			if(m.allLocations.get(i).getTeam() == "Red") {
//				j.setBackground(Color.RED);
//			}
//			else if( m.allLocations.get(i).getTeam() == "Blue") {
//				j.setBackground(Color.BLUE);
//			}
//			else if ( m.allLocations.get(i).getTeam() == "Bystander") {
//				j.setBackground(Color.YELLOW);
//			}
//			else if ( m.allLocations.get(i).getTeam() == "Assassin") {
//				j.setBackground(Color.GREEN);
//			}
//		panel.add(j);
		x1.add(j);
		x1.setVisible(true);
		}
		
	}		
}
