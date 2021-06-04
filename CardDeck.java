package BlackJack;
import java.util.ArrayList;
import java.util.Random;

public class CardDeck 
{
	private ArrayList<Card> deck;

	public CardDeck() 
	{
		this.deck = new ArrayList<Card>();
	}//end constructor
	public void fullDeck() 
	{
		for(Suit suit : Suit.values()) 
		{
			for (Number number : Number.values())
			{
				this.deck.add(new Card(number, suit));
			}//adds new card to deck
		}//end loop
	}//end method that creates deck 
	public void shuffleDeck() 
	{
		ArrayList<Card> shuffleDeck = new ArrayList<Card>();
		Random random = new Random();
		int index = 0;
		int size = this.deck.size();
		for (int i = 0; i < size; i++) 
		{
			index = random.nextInt((this.deck.size()-1-0) + 1);
			shuffleDeck.add(this.deck.get(index)); //adds random card to new deck
			this.deck.remove(index); //removes it from original deck
		}//end loop
		this.deck = shuffleDeck; //sets deck to shuffled version of array
	}//end method that shuffles deck


	public void remove(int j) 
	{
		this.deck.remove(j);
	}//end method	
	public Card getCard(int j)
	{
		return this.deck.get(j);
	}//end method	
	public void addCard(Card newCard) 
	{
		this.deck.add(newCard);
	}//end method
	public Card select(CardDeck original) 
	{
		return original.getCard(0);//returns card
	}//draw card from deck
	public void switching(CardDeck original) 
	{
		this.deck.add(original.getCard(0)); //draws card to players deck
		original.remove(0); //removes card from original deck
	}
	public int cardNumber() 
	{
		int totalvalue = 0;
		int ace = 0;

		for(Card card : this.deck) 
		{
			switch(card.getNumber()) 
			{
			case TWO: totalvalue += 2; break;
			case THREE: totalvalue += 3; break;
			case FOUR: totalvalue += 4; break;
			case FIVE: totalvalue += 5; break;
			case SIX: totalvalue +=6; break;
			case SEVEN: totalvalue += 7; break;
			case EIGHT: totalvalue += 8; break;
			case NINE: totalvalue += 9; break;
			case TEN: totalvalue += 10; break;
			case JACK: totalvalue += 10; break;
			case QUEEN: totalvalue += 10; break;
			case KING: totalvalue += 10; break;
			case ACE: ace+= 1; break;
			}
		}//end loop
		for (int i = 0; i < ace; i++) 
		{
			if(totalvalue > 10) 
			{
				totalvalue += 1;
			}
			else if (totalvalue < 10) 
			{
				totalvalue += 11;
			}//end if
		}//end loop
		return totalvalue;
	}//end method
	public String toString()
	{
		String str = "";

		for (Card card : this.deck) 
		{
			str+= "\n" + card.toString();
		}//end loop
		return str;
	}//end method
}//end class
