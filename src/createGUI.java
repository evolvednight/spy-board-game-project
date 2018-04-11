import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.sun.javafx.tk.Toolkit;

import javafx.scene.control.ToggleButton;

@SuppressWarnings("unused")
public class createGUI implements Observer {
	private JFrame aliasx2;
	private int clueCount;
	board ssr = new board();
	int xx =ssr.getTurn() ;
	public createGUI() {
		restart();
	}
	public void restart() {
		MakeGui();
	}
	
	
	public void MakeGui() {
		
		main m = new main();
		m.gameStart();

		
		
		if(m.winningState() == true) {
			JFrame win= new JFrame("Game Won");
			win.setLocation(450, 250);
			
			if(m.getNumRed() == 0) {
				ImageIcon icon = new ImageIcon("src/red.jpg");
				JLabel label = new JLabel(icon);
				
				win.add(label);
				  win.setDefaultCloseOperation
				         (JFrame.DISPOSE_ON_CLOSE);
				  win.pack();
			}
			else {
				ImageIcon icon = new ImageIcon("src/blue.jpg");
				JLabel label = new JLabel(icon);
				
				win.add(label);
				  win.setDefaultCloseOperation
				         (JFrame.DISPOSE_ON_CLOSE);
				  win.pack();
			}
		}

	

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File"); 
		JMenuItem start = new JMenuItem("Start New Game");
		JMenuItem exit = new JMenuItem("Exit Game");
		menuBar.add(menu);
		menu.add(start);
		menu.add(exit);
		
		
		
		JFrame x1 = new JFrame("CodeName game");
		x1.setJMenuBar(menuBar);
		x1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x1.setSize(1000,1000);
		GridLayout inX = new GridLayout(2,2);
		x1.setLayout(inX);
		JPanel panelTop = new JPanel(new GridLayout(6,6));
		JPanel panelBottom = new JPanel(new GridLayout(5,5));
		JLabel labelCode = new JLabel();
		JLabel labelNumber = new JLabel();
		
		
		
		
		ActionListener exit2 = new ActionListener() {//menu exit
			@Override
			public void actionPerformed(ActionEvent e) {
				x1.dispose();
				aliasx2.dispose();	
			}
		}
		;
		exit.addActionListener(exit2);
		
		
		
		
		
		ActionListener start2 = new ActionListener() {//menu restart
			@Override
			public void actionPerformed(ActionEvent e) {
				x1.getContentPane().removeAll();
				x1.dispose();
				restart();
			}
		}
		;
		start.addActionListener(start2);
		
		
		
		
		
		
		
		
		JButton restart = new JButton("Restart");
		
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == restart) {
					x1.getContentPane().removeAll();
					x1.dispose();
				restart();

				}
			}
		});

		panelTop.add(restart);
		
		

		
		JButton Spy = new JButton( "Spy Master");
		Spy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame x2 = new JFrame("Spy Master Window");
				aliasx2 = x2;
				JPanel panelRight = new JPanel();
//				panelRight.setLayout(new GridLayout(0,1));
				JPanel panelLeft = new JPanel();
				panelLeft.setLayout(new GridLayout(5,5));
				JLabel label1 = new JLabel();
				JLabel label2 = new JLabel();
				JButton jb = new JButton("Enter");
				
				System.out.println(m.getNumRed());
				
				JTextField textField= new JTextField("Input Clue" ,20);
				JTextField numField = new JTextField("Input number", 20);
				if(textField.getText().equals("Input Clue")) {
				textField.setForeground(Color.LIGHT_GRAY);
				}
				if(numField.getText().equals("Input number")) {
				numField.setForeground(Color.LIGHT_GRAY);
				}
				
				
				
				
				FocusListener ghost1 = new FocusListener(){
					@Override
					public void focusGained(FocusEvent e) {
						textField.setText("");
						textField.setForeground(Color.black);
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(textField.getText().equals("")) {
							textField.setText("Input Clue");
							textField.setForeground(Color.LIGHT_GRAY);
						}
					 }	
				    }
				;
				
				
				
				
				
				FocusListener ghost2 = new FocusListener(){
					@Override
					public void focusGained(FocusEvent e) {
						numField.setText("");
						numField.setForeground(Color.black);
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(numField.getText().equals("")) {
							numField.setText("Input number");
							numField.setForeground(Color.LIGHT_GRAY);
						}
					 }	
				    }
				;
			textField.addFocusListener(ghost1);
			numField.addFocusListener(ghost2);
				
				
				
				
				
				jb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String input = textField.getText();
						int x = Integer.parseInt(numField.getText());
						clueCount = x;
						if ( m.Legality(input) == true && m.legalityNum(x)) {

							label1.setText(input);
							label2.setText(numField.getText());
							labelCode.setText("Hint: "+ input);
							labelNumber.setText("Number: "+ numField.getText());
							labelCode.setFont(new Font("Serif", Font.PLAIN, 40));
							labelNumber.setFont(new Font("Serif", Font.PLAIN, 40));
							
							
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
							
							if(input.equalsIgnoreCase("AustinsJeep")) {
							JFrame f = new JFrame(); 


					        ImageIcon image = new ImageIcon("src/img.jpg"); //imports the image

					        JLabel lbl = new JLabel(image); //puts the image into a jlabel

					        f.getContentPane().add(lbl); //puts label inside the jframe

					        f.setSize(image.getIconWidth(), image.getIconHeight()); //gets h and w of image and sets jframe to the size
					        

					 
					        f.setLocation(150, 250); //sets the location of the jframe
					        f.setVisible(true); //makes the jframe visible
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
					String temp = m.allLocations.get(i).getCodeName();
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
		
		
		
		
		

		JButton tend = new JButton("End turn") ;// lets make this the the button that ends turns
		panelTop.add(tend);
		tend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent t) {
				ssr.changeTurn();
			}
		});
		
		
		
		
		
		

		JLabel disturn = new JLabel();
		if(xx == 1) {disturn.setText("Turn : Team Red");
		disturn.setForeground(Color.red);
		disturn.setFont(new Font("Serif", Font.PLAIN, 40));}
		
		if(xx == 0) {disturn.setText("Turn : Team Blue");
		disturn.setForeground(Color.blue);
		disturn.setFont(new Font("Serif", Font.PLAIN, 40));
		
		}
		panelTop.add(disturn);

		
		
		//instruction here
		
		JLabel redScore = new JLabel("Red Team Points: " + m.getNumRed());
		redScore.setForeground(Color.red);
		redScore.setFont(new Font("Serif", Font.PLAIN, 40));
		panelTop.add(redScore);

		JLabel blueScore = new JLabel("Blue Team Points: " + m.getNumBlue());
		blueScore.setForeground(Color.blue);
		blueScore.setFont(new Font("Serif", Font.PLAIN, 40));
		panelTop.add(blueScore);

//		JTextArea countField = new JTextArea();
//		countField.setText("this field is for red and blue counter");
//		panelTop.add(countField); 

	/*	//hasan
		JTextArea clueAndCount = new JTextArea() ;
		String x = "set equal to clue getter, " ;//need getters
		String g = "set equal to number of cards the clue applies to" ;//need getters
		clueAndCount.setText(x + g);
		panelTop.add(clueAndCount);
		//end 
*/

		
		
	//hh	
		
	
		
		for( int i = 0; i<25 ; i++) {
			String temp = m.allLocations.get(i).getCodeName();
			JButton j = new JButton(temp);
			String team = m.allLocations.get(i).getTeam() ;
			
			
		panelBottom.add(j);
		j.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent E) {
				boolean turnOver = false ;
				clueCount = clueCount - 1 ;
				if(clueCount == 0) { 
					ssr.changeTurn(); 
				 turnOver = true ;
				}
				
				if(team == "Red") {
					if(xx != 1 && turnOver == false) { ssr.changeTurn();clueCount = 0 ;}
					j.setForeground(Color.red);
				}
				else if(team == "Blue") {
					if(xx != 0 && turnOver == false) { ssr.changeTurn(); clueCount = 0 ;}
					j.setForeground(Color.blue);
					
				}
				else if ( team == "Bystander") {
					j.setForeground(Color.yellow);
				if(turnOver == false) {	ssr.changeTurn(); clueCount = 0 ;}
					
				}
				else if ( team == "Assassin") {
					j.setForeground(Color.green);
				}
			}
		});
		
		
		//ll
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
