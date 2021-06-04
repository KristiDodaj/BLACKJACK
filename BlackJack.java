package BlackJack;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * @author Kristi Dodaj
 * May 26, 2021
 * Fully functioning black jack game with an incorporated money betting system
 */
public class BlackJack 
{
	public static void main(String[] args) 
	{
		//Declaration&Initialization
		int reply;
		int userscoreTotal = 0;
		int compscoreTotal = 0;
		do {
		CardDeck deck = new CardDeck();	
		CardDeck userDeck = new CardDeck();
		CardDeck compDeck = new CardDeck();

		//Frame
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setTitle("KRISTI'S CASINO: BLACK JACK");
		frame.getContentPane().setBackground(Color.decode("#23ad23"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Button HIT/STAND
		JButton hit = new JButton("HIT");
		hit.setBounds(60,100,95,30);  
		hit.setLocation(140, 450);
		hit.setBackground(Color.decode("#ffffff"));
		frame.add(hit);

		JButton stand = new JButton("STAND");
		stand.setBounds(60,100,95,30);  
		stand.setLocation(360, 450);
		stand.setBackground(Color.decode("#ffffff"));
		frame.add(stand);

		//Title
		JLabel title = new JLabel("KRISTI'S CASINO: BLACK JACK");
		title.setBounds(100,100,350,60);
		title.setLocation(150, 20);
		title.setForeground(Color.decode("#ffffff"));
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.add(title);
		
		//User Print Areas
		JLabel userHand = new JLabel("YOUR HAND: ", SwingConstants.CENTER);	
		userHand.setForeground(Color.white);
		userHand.setBounds(100,100,150,32);
		userHand.setLocation(105, 100);
		userHand.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userHand.setVisible(true);
		frame.add(userHand);
			
		JLabel userhandone = new JLabel("CARD ONE", SwingConstants.CENTER);
		userhandone.setOpaque(true);
		userhandone.setBackground(Color.white);
		userhandone.setForeground(Color.black);
		userhandone.setBounds(100,100,150,32);
		userhandone.setLocation(105, 230);
		userhandone.setVisible(true);
		frame.add(userhandone);
		
		JLabel cardonelabel = new JLabel("CARD 1:");	
		cardonelabel.setBounds(100,100,150,32);
		cardonelabel.setLocation(30, 160);
		cardonelabel.setForeground(Color.white);
		cardonelabel.setVisible(true);
		frame.add(cardonelabel);
		
		JLabel userhandtwo = new JLabel("CARD TWO:", SwingConstants.CENTER);
		userhandtwo.setOpaque(true);
		userhandtwo.setBackground(Color.white);
		userhandtwo.setForeground(Color.black);
		userhandtwo.setBounds(100,100,150,32);
		userhandtwo.setLocation(105, 160);
		userhandtwo.setVisible(true);
		frame.add(userhandtwo);
		
		JLabel cardtwolabel = new JLabel("CARD 2:");	
		cardtwolabel.setBounds(100,100,150,32);
		cardtwolabel.setLocation(30, 230);
		cardtwolabel.setForeground(Color.white);
		cardtwolabel.setVisible(true);
		frame.add(cardtwolabel);
		
		JLabel userHit = new JLabel("USER HIT", SwingConstants.CENTER);
		userHit.setOpaque(true);
		userHit.setBackground(Color.white);
		userHit.setForeground(Color.black);
		userHit.setBounds(100,100,150,32);
		userHit.setLocation(105, 300);
		userHit.setVisible(true);
		frame.add(userHit);
		
		JLabel hitlabel = new JLabel("HIT:");	
		hitlabel.setBounds(100,100,150,32);
		hitlabel.setLocation(30, 300);
		hitlabel.setForeground(Color.white);
		hitlabel.setVisible(true);
		frame.add(hitlabel);
		
		JLabel userTotal = new JLabel("TOTAL", SwingConstants.CENTER);
		userTotal.setOpaque(true);
		userTotal.setBackground(Color.white);
		userTotal.setForeground(Color.black);
		userTotal.setBounds(100,100,150,32);
		userTotal.setLocation(105, 370);
		userTotal.setVisible(true);
		frame.add(userTotal);
		
		JLabel totallabel = new JLabel("TOTAL:");	
		totallabel.setBounds(100,100,150,32);
		totallabel.setLocation(30, 370);
		totallabel.setForeground(Color.white);
		totallabel.setVisible(true);
		frame.add(totallabel);
		
	    //Computer Print Areas
		JLabel compHand = new JLabel("COMP HAND: ", SwingConstants.CENTER);	
		compHand.setForeground(Color.white);
		compHand.setBounds(100,100,150,32);
		compHand.setLocation(340, 100);
		compHand.setFont(new Font("Times New Roman", Font.BOLD, 18));
		compHand.setVisible(true);
		frame.add(compHand);
		
		JLabel comphandone = new JLabel("CARD 1", SwingConstants.CENTER);
		comphandone.setOpaque(true);
		comphandone.setBackground(Color.white);
		comphandone.setForeground(Color.black);
		comphandone.setBounds(100,100,150,32);
		comphandone.setLocation(340, 230);
		comphandone.setVisible(true);
		frame.add(comphandone);
		
		JLabel comphandtwo = new JLabel("HIDDEN", SwingConstants.CENTER);
		comphandtwo.setOpaque(true);
		comphandtwo.setBackground(Color.white);
		comphandtwo.setForeground(Color.black);
		comphandtwo.setBounds(100,100,150,32);
		comphandtwo.setLocation(340, 160);
		comphandtwo.setVisible(true);
		frame.add(comphandtwo);
		
		JLabel compHit = new JLabel("COMP HIT", SwingConstants.CENTER);
		compHit.setOpaque(true);
		compHit.setBackground(Color.white);
		compHit.setForeground(Color.black);
		compHit.setBounds(100,100,150,32);
		compHit.setLocation(340, 300);
		compHit.setVisible(true);
		frame.add(compHit);
		
		JLabel compTotal = new JLabel("TOTAL", SwingConstants.CENTER);
		compTotal.setOpaque(true);
		compTotal.setBackground(Color.white);
		compTotal.setForeground(Color.black);
		compTotal.setBounds(100,100,150,32);
		compTotal.setLocation(340, 370);
		compTotal.setVisible(true);
		frame.add(compTotal);
		
		//Score Area
		JLabel compScore = new JLabel("COMPUTER SCORE: ");
		compScore.setForeground(Color.white);
		compScore.setBounds(100,100,150,32);
		compScore.setLocation(450, 520);
		frame.add(compScore);
		
		JLabel userScore = new JLabel("USER SCORE: ");
		userScore.setForeground(Color.white);
		userScore.setBounds(100,100,150,32);
		userScore.setLocation(30, 520);
		frame.add(userScore);

        //Disables resizing
		frame.setResizable(false);
		
		//Back End
		userInput(hit, stand, userhandone,userhandtwo, comphandone, comphandtwo,userHit, compHit, userTotal, compTotal, deck, userDeck, compDeck, userscoreTotal, compscoreTotal);
		reply = JOptionPane.showConfirmDialog(null, "WOULD YOU LIKE TO PLAY AGAIN", "PLAY AGAIN", JOptionPane.YES_NO_OPTION);
		}while(reply == JOptionPane.YES_OPTION);
	}//end method
	public static void userInput(JButton hit, JButton stand, JLabel userhandone, JLabel userhandtwo, JLabel comphandone, JLabel comphandtwo,JLabel userHit, JLabel compHit, JLabel userTotal, JLabel compTotal, CardDeck deck, CardDeck userDeck, CardDeck compDeck, int userscoreTotal, int compscoreTotal) 
	{
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
		userTotal.setText(String.valueOf(userDeck.cardNumber()));

        //Event listeners for HIT/STAND
		hit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				userHit.setText(userDeck.select(deck).toString());
				userDeck.switching(deck);
				userTotal.setText(String.valueOf(userDeck.cardNumber()));
				if (userDeck.cardNumber() > 21) 
				{
					//Disables buttons
					hit.setEnabled(false);
					stand.setEnabled(false);
					System.out.println("Burned");
					userTotal.setText(String.valueOf(userDeck.cardNumber()));
					compCompare(compDeck, deck, userDeck, comphandone, comphandtwo, compHit, compTotal,userscoreTotal, compscoreTotal);
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
				userTotal.setText(String.valueOf(userDeck.cardNumber()));
				//Once player is done it generates second computer card
				comphandtwo.setText(compDeck.select(deck).toString());
				compDeck.switching(deck);
				compCompare(compDeck, deck, userDeck, comphandone, comphandtwo, compHit, compTotal, userscoreTotal, compscoreTotal);
			}
		});	
	}//end method
	public static void compCompare(CardDeck compDeck, CardDeck deck, CardDeck userDeck, JLabel comphandone, JLabel comphandtwo, JLabel compHit, JLabel compTotal, int userscoreTotal, int compscoreTotal) 
	{
		int userscore = 0;
		int compScore = 0;
		int usertotalScore = 0;
		int comptotalScore = 0;
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
			userscore++;
		}
		else if (userDeck.cardNumber() < compDeck.cardNumber() && compDeck.cardNumber() <= 21)  
		{
			compScore++;
		}
		else if(userDeck.cardNumber() > 21 && compDeck.cardNumber() <= 21) 
		{
			compScore++;
		}
		else if(userDeck.cardNumber() <= 21 && compDeck.cardNumber() > 21) 
		{
			userscore++;
		}
		else 
		{
			userscore++;
			compScore++;
		}
		usertotalScore += userscore;
		comptotalScore += compScore;
	}//end method
}//end class