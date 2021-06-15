package BlackJack;
import java.util.ArrayList;
/**
 * Create a card using the suit and number enum
 */
public class Card 
{
	private Number number;
	private Suit suit;

	public Card(Number number, Suit suit) 
	{
		this.number = number;
		this.suit = suit;
	}//end constructor
	public Number getNumber() 
	{
		return this.number;
	}//end getter
	public String toString() 
	{
		String str = "";
		str += number + "-" + suit;
		return str;
	}//end method
}//end class