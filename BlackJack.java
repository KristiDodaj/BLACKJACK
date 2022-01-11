package BlackJack;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
/**
 * @author Kristi Dodaj
 * May 26, 2021
 * Fully functioning black jack game with an incorporated money betting system
 */
public class BlackJack 
{
	public static void main(String[] args) throws IOException 
	{
		//Display rules 
		JOptionPane.showMessageDialog (null, "WELCOME TO BLACKJACK!" + "\n\n" + "1. THE GOAL IS TO REACH A TOTAL OF 21 WITHOUT PASSING IT." + "\n" + "2. IF YOU PASS A TOTAL OF 21, YOU HAVE BEEN BURNED!" + "\n" + "3. PRESS THE HIT BUTTON TO ADD A CARD OR STAND IF YOU ARE OKAY WITH YOUR TOTAL." + "\n" + "4. WHILE NUMBER CARDS ARE EQUAL TO THEIR NUMBER, FACED CARDS ARE EQUAL TO 10." + "\n" + "5. ACES COULD BE EQUAL TO BOTH 1 AND 11." + "\n" + "6. THE COMPUTER DEALER WILL THEN CREATE THEIR HAND." + "\n" + "7. READ THE MESSAGE DISPLAYED TO SEE THE WINNER!" + "\n" + "8. PRESS YES TO PLAY AGAIN OR THE EXIT BUTTON ON BLACKJACK TO QUIT.", "RULES", JOptionPane.INFORMATION_MESSAGE);

		//PLAY AGAIN DIALOG
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("WOULD YOU LIKE TO PLAY AGAIN?"));
		JButton yes = new JButton("YES");
		panel.add(yes);
		JDialog dialog = new JDialog();
		dialog.add(panel);
		dialog.setSize(220, 100);
		dialog.setResizable(false);
		
		//GUI
		JFrame frame = new JFrame();
		CardDeck deck = new CardDeck();	
		CardDeck userDeck = new CardDeck();
		CardDeck compDeck = new CardDeck();
		gui(frame, deck, userDeck, compDeck);
		dialog.setVisible(true);
		
		//PLAY AGAIN
		yes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				JFrame frame = new JFrame();
				frame.dispose();	
				
				CardDeck deck = new CardDeck();	
				CardDeck userDeck = new CardDeck();
				CardDeck compDeck = new CardDeck();
				gui(frame, deck, userDeck, compDeck);
			}
		});	
	}//end method
	public static void gui(JFrame frame, CardDeck deck, CardDeck userDeck, CardDeck compDeck) 
	{
		//Frame
		frame.setVisible(true);
		frame.setSize(600, 600); 
		frame.setLayout(null);
		frame.setTitle("KRISTI'S CASINO: BLACK JACK");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel back = new JLabel(new ImageIcon("filepath"));
		back.setLayout(null);
		back.setSize(600, 600);
                frame.add(back);
        
		//Button HIT/STAND
		JButton hit = new JButton("HIT");
		hit.setBounds(60,100,95,30);  
		hit.setLocation(131, 519);
		hit.setBackground(Color.decode("#FFE500"));
		hit.setVisible(true);
		back.add(hit);

		JButton stand = new JButton("STAND");
		stand.setBounds(60,100,95,30);  
		stand.setLocation(373, 519);
		stand.setBackground(Color.decode("#FFE500"));
		back.add(stand);
		
		//User Print Areas	
		JLabel userhandone = new JLabel("CARD ONE", SwingConstants.CENTER);
		userhandone.setOpaque(true);
		userhandone.setBackground(Color.decode("#FFE500"));
		userhandone.setForeground(Color.black);
		userhandone.setBounds(100,100,110, 26);
		userhandone.setLocation(82, 477);
		userhandone.setVisible(true);
		back.add(userhandone);
		
		JLabel userhandtwo = new JLabel("CARD TWO:", SwingConstants.CENTER);
		userhandtwo.setOpaque(true);
		userhandtwo.setBackground(Color.decode("#FFE500"));
		userhandtwo.setForeground(Color.black);
		userhandtwo.setBounds(100,100,110,26);
		userhandtwo.setLocation(405, 477);
		userhandtwo.setVisible(true);
		back.add(userhandtwo);

		JLabel userHit = new JLabel("USER HIT", SwingConstants.CENTER);
		userHit.setOpaque(true);
		userHit.setBackground(Color.decode("#FFE500"));
		userHit.setForeground(Color.black);
		userHit.setBounds(100,100,97,32);
		userHit.setLocation(249, 323);
		userHit.setVisible(true);
		back.add(userHit);
		
		JLabel userTotal = new JLabel("TOTAL", SwingConstants.CENTER);
		userTotal.setOpaque(true);
		userTotal.setBackground(Color.decode("#FFE500"));
		userTotal.setForeground(Color.black);
		userTotal.setBounds(100,100,131,26);
		userTotal.setLocation(233,477);
		userTotal.setVisible(true);
		back.add(userTotal);

	        //Computer Print Areas
		JLabel comphandone = new JLabel("CARD 1", SwingConstants.CENTER);
		comphandone.setOpaque(true);
		comphandone.setBackground(Color.decode("#FFE500"));
		comphandone.setForeground(Color.black);
		comphandone.setBounds(100,100,100,32);
		comphandone.setLocation(165, 172);
		comphandone.setVisible(true);
		back.add(comphandone);
		
		JLabel comphandtwo = new JLabel("HIDDEN", SwingConstants.CENTER);
		comphandtwo.setOpaque(true);
		comphandtwo.setBackground(Color.decode("#FFE500"));
		comphandtwo.setForeground(Color.black);
		comphandtwo.setBounds(100,100,95,32);
		comphandtwo.setLocation(330, 172);
		comphandtwo.setVisible(true);
		back.add(comphandtwo);
		
		JLabel compHit = new JLabel("COMP HIT", SwingConstants.CENTER);
		compHit.setOpaque(true);
		compHit.setBackground(Color.decode("#FFE500"));
		compHit.setForeground(Color.black);
		compHit.setBounds(100,100,119,38);
		compHit.setLocation(235, 245);
		compHit.setVisible(true);
		back.add(compHit);
		
		JLabel compTotal = new JLabel("TOTAL", SwingConstants.CENTER);
		
		JLabel winner = new JLabel("",SwingConstants.CENTER);
		winner.setForeground(Color.white);
		winner.setBounds(100,100,400,38);
		winner.setLocation(105, 407);
		winner.setVisible(true);
		back.add(winner);
		
                //Disables resizing
		frame.setResizable(false);
		frame.revalidate();
		
		//Generates and shuffles
		deck.fullDeck();
		deck.shuffleDeck();
		//Generate User Hand
		userhandone.setText(userDeck.select(deck).toString());
		userDeck.switching(deck); 
		userhandtwo.setText(userDeck.select(deck).toString());
		userDeck.switching(deck);
		//Generate First Computer card while second remain hidden
		comphandone.setText(compDeck.select(deck).toString());
		compDeck.switching(deck);
		
		//User Hand Total
		userTotal.setText("USER TOTAL: "+String.valueOf(userDeck.cardNumber()));

                //Event listeners for HIT/STAND
		hit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				userHit.setText(userDeck.select(deck).toString());
				userDeck.switching(deck);
				userTotal.setText("USER TOTAL: "+String.valueOf(userDeck.cardNumber()));
				if (userDeck.cardNumber() > 21) 
				{
					//Disables buttons
					hit.setEnabled(false);
					stand.setEnabled(false);
					userTotal.setText("USER TOTAL: "+String.valueOf(userDeck.cardNumber()));
					compCompare(compDeck, deck, userDeck, comphandone, comphandtwo, compHit, compTotal, winner);
					//Once player is done it generates second computer card
					comphandtwo.setText(compDeck.select(deck).toString());
					compDeck.switching(deck);
				}
			}
		});
		stand.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//Disables buttons
				stand.setEnabled(false);
				hit.setEnabled(false);
				userTotal.setText("USER TOTAL: "+String.valueOf(userDeck.cardNumber()));
				//Once player is done it generates second computer card
				comphandtwo.setText(compDeck.select(deck).toString());
				compDeck.switching(deck);
				compCompare(compDeck, deck, userDeck, comphandone, comphandtwo, compHit, compTotal, winner);
			}
		});	 
	}//end method
	public static void compCompare(CardDeck compDeck, CardDeck deck, CardDeck userDeck, JLabel comphandone, JLabel comphandtwo, JLabel compHit, JLabel compTotal, JLabel winner) 
	{
		//Print computer total
		compTotal.setText(String.valueOf(compDeck.cardNumber()));
		/**
		 * Instructs computer how to beat the user input
		 */
		if(userDeck.cardNumber() > 21) 
		{
			do 
			{
				compHit.setText(compDeck.select(deck).toString());
				compDeck.switching(deck);
				compTotal.setText(String.valueOf(compDeck.cardNumber()));
			}while(compDeck.cardNumber() < 17);
		}
		else if(userDeck.cardNumber() <= 21) 
		{
			do 
			{
				if (compDeck.cardNumber() < userDeck.cardNumber() && compDeck.cardNumber() <= 21) 
				{
					compHit.setText(compDeck.select(deck).toString());
					compDeck.switching(deck);
					compTotal.setText(String.valueOf(compDeck.cardNumber()));
				}//end if
			}while(compDeck.cardNumber() < userDeck.cardNumber() && compDeck.cardNumber() <= 21);//end loop
		}//end if
		compTotal.setText(String.valueOf(compDeck.cardNumber()));
		/**
		 * Decides who wins and keeps track of score
		 */
		if (userDeck.cardNumber() > compDeck.cardNumber() && userDeck.cardNumber() <= 21) 
		{
			winner.setText("YOU WON!");
		}
		else if (userDeck.cardNumber() < compDeck.cardNumber() && compDeck.cardNumber() <= 21)  
		{
			winner.setText("COMPUTER WON WITH A TOTAL OF " + compDeck.cardNumber()+"!");
		}
		else if(userDeck.cardNumber() > 21 && compDeck.cardNumber() <= 21) 
		{
			winner.setText("BURNED! COMPUTER WINS!");
		}
		else if(userDeck.cardNumber() <= 21 && compDeck.cardNumber() > 21) 
		{
			winner.setText("COMPUTER GOT BURNED! YOU WIN!");
		}
		else if(userDeck.cardNumber() > 21 && compDeck.cardNumber() > 21) 
		{
			winner.setText("YOU BOTH GOT BURNED!");
		}
		else 
		{
			winner.setText("TIE!");
		}//end if
	}//end method
}//end class
