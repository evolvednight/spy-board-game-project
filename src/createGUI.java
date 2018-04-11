import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.scene.control.ToggleButton;

@SuppressWarnings("unused")
public class createGUI implements Observer {
	private static int counter = 0;
	
	public static void main(String[] args) {
		
		main m = new main();
//		ActionListner r = new ActionListner();
//		board b = new board();
		m.gameStart();
//		System.out.println(m.codeNamesOnBoard);
//		System.out.println(b.allLocations);
//		System.out.println(b.tempArr);
		
		
		
		if(m.winningState() == true) {
			JFrame frame = new JFrame("Game Won");
			frame.setLocation(450, 250);
			
			if(m.getNumRed() == 0) {
			JLabel red = new JLabel("Red Wins");
			frame.add(red);
			  frame.setDefaultCloseOperation
			         (JFrame.DISPOSE_ON_CLOSE);
			  frame.pack();
			  
			  frame.setVisible(true);
			}
			else {
				JLabel blue = new JLabel("Blue Wins");
				frame.add(blue);
				  frame.setDefaultCloseOperation
				         (JFrame.DISPOSE_ON_CLOSE);
				  frame.pack();
				  
				  frame.setVisible(true);
			}
			
			
			

		}
	

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu(); 
		JMenuItem item = new JMenuItem();
		menuBar.add(menu);
		
		
		
		
		JFrame x1 = new JFrame("CodeName game");
		x1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x1.setSize(1000,1000);
		GridLayout inX = new GridLayout(2,2);
		x1.setLayout(inX);
		JPanel panelTop = new JPanel(new GridLayout(6,6));
		JPanel panelBottom = new JPanel(new GridLayout(5,5));
		JLabel labelCode = new JLabel();
		JLabel labelNumber = new JLabel();
		
		JButton restart = new JButton("Restart");
		
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main s = new main();
				s.gameStart();
				JFrame x3 = new JFrame("CodeName game");
				
				x1.setVisible(false);
				x3 = x1;
				x3.setVisible(true);
				
			}
		});
		
		panelTop.add(restart);
		
		
//		//Easter Egg
//	
//		//JButton easterEgg = new JButton();
//	//	x1.add(easterEgg);
//		//easterEgg.setOpaque(false);
//		//easterEgg.setContentAreaFilled(false);
//		//easterEgg.setBorderPainted(false);
//		
//		ActionListener egg = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				counter = counter + 1;
//				if(counter == 5) {
//				JFrame frame = new JFrame("EasterEgg");
//				frame.setLocation(450, 250);
//				ImageIcon icon = new ImageIcon("src/hertz.jpg");
//				JLabel label = new JLabel(icon);
//				
//				frame.add(label);
//				  frame.setDefaultCloseOperation
//				         (JFrame.DISPOSE_ON_CLOSE);
//				  frame.pack();
//				  
//				  frame.setVisible(true);
//				  x1.getContentPane().setBackground(Color.black);
//				//  easterEgg.setText("EasterEgg Unlocked");
//				//  easterEgg.setForeground(Color.WHITE);
//				}
//				  
//			  }	
//		    }
//		;
		
	//easterEgg.addActionListener(egg);

		
		
		JButton Spy = new JButton( "Spy Master");
		Spy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame x2 = new JFrame("Spy Master Window");
				JPanel panelRight = new JPanel();
//				panelRight.setLayout(new GridLayout(0,1));
				JPanel panelLeft = new JPanel();
				panelLeft.setLayout(new GridLayout(5,5));
				JLabel label1 = new JLabel();
				JLabel label2 = new JLabel();
				JButton jb = new JButton("Enter");
				JButton red = new JButton("Red");
				JButton blue = new JButton("Blue");
				
				 red.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						red.setEnabled(true);;
					 }
				 });
				
				JTextField textField= new JTextField("Input Clue" ,20);
				JTextField numField = new JTextField("Input number", 20);
				jb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String input = textField.getText();
						int x = Integer.parseInt(numField.getText());
						if ( m.Legality(input) == true && m.legalityNum(x)) {

							label1.setText(input);
							label2.setText(numField.getText());
							labelCode.setText(input);
							labelNumber.setText(numField.getText());
							
							
							if(input.equalsIgnoreCase("hertz")) {
								JFrame frame = new JFrame("EasterEgg");
								frame.setLocation(450, 250);
								ImageIcon icon = new ImageIcon("src/hertz.jpg");
								JLabel label = new JLabel(icon);
								
								frame.add(label);
								  frame.setDefaultCloseOperation
								         (JFrame.DISPOSE_ON_CLOSE);
								  frame.pack();
								  
								  frame.setVisible(true);
							}
							
						}
						else if(m.Legality(input) && !m.legalityNum(x)) {
							label1.setText("Invalid code or number");
						}
						else if( !m.Legality(input) && m.legalityNum(x)) {
							label1.setText("Invalid code or number");
						}
						else {
							label1.setText("Invalid code or number");
						}
						
					}
					
				});
//				notifyObserver();
				panelRight.add(red);
				panelRight.add(blue);
				panelRight.add(jb);
				panelRight.add(textField);
				panelRight.add(numField);
				panelRight.add(label1);
				panelRight.add(label2);
				x2.getContentPane().add(panelRight,BorderLayout.EAST);
				
				
				x2.setSize(750, 750);
				GridLayout inY = new GridLayout(0,2);
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
					panelLeft.add(j);
					x2.add(panelLeft);

				}
				
			
				x2.setVisible(true);
			}
		}
			);
		panelTop.add(Spy);
		panelTop.add(labelCode);
		panelTop.add(labelNumber);

		//hasan
		JButton tend = new JButton("End turn") ;// lets make this the the button that ends turns
		panelTop.add(tend);
		int gg = 1 ;//set this equal to the count getter
		if(gg== 0) { tend.doClick(); } // ends turn when clue count is  0 
		//end



		
		
		//instruction here
		
		JTextArea instruction = new JTextArea();
		instruction.setText("this is a game of codeName which model after the codename board game");
		panelTop.add(instruction);

		JTextArea instruction2 = new JTextArea();
		instruction2.setText("More Instructions");
		panelTop.add(instruction2);

		JTextArea countField = new JTextArea();
		countField.setText("this field is for red and blue counter");
		panelTop.add(countField); 

		//hasan
		JTextArea clueAndCount = new JTextArea() ;
		String x = "set equal to clue getter, " ;//need getters
		String g = "set equal to number of cards the clue applies to" ;//need getters
		clueAndCount.setText(x + g);
		panelTop.add(clueAndCount);
		//end 


		
		
		
		
		for( int i = 0; i<25 ; i++) {
			String temp = m.codeNamesOnBoard.get(i);
			JButton j = new JButton(temp);

			
		panelBottom.add(j);
		
		}
		x1.add(panelTop);
		x1.add(panelBottom);
		x1.setVisible(true);
	}
	
	
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}		
}