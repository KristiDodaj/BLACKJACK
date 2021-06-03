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
		CardDeck deck = new CardDeck();
		deck.fullDeck();
		deck.shuffleDeck();
		System.out.println(deck);
		
		
		
		//GUI
		
		//Frame
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setTitle("KRISTI'S CASINO: BLACK JACK");
		frame.getContentPane().setBackground(Color.decode("#23ad23"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Button
		JButton hit = new JButton("HIT");
		hit.setBounds(60,100,95,30);  
		hit.setLocation(150, 450);
		hit.setBackground(Color.decode("#ffffff"));
		frame.add(hit);
	
		JButton stand = new JButton("STAND");
		stand.setBounds(60,100,95,30);  
		stand.setLocation(350, 450);
		stand.setBackground(Color.decode("#ffffff"));
		frame.add(stand);
		
		//Label
		JLabel title = new JLabel("KRISTI'S CASINO: BLACK JACK");
		title.setBounds(100,100,350,60);
		title.setLocation(150, 40);
		title.setForeground(Color.decode("#ffffff"));
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.add(title);
		
		
		
		
		hit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("HIT");
			}
		});
		
		
		

	}//end method
}//end class
