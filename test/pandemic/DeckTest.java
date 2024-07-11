package pandemic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pandemic.Cards.Card;
import pandemic.Cards.Deck;
import pandemic.Cards.PlayerCard;

public class DeckTest {
    
    @Test
    public void drawCardTest(){
        Disease d1 = new Disease(1, 0);
        City c1 = new City("City1", d1);

        Disease d2 = new Disease(2, 0);
        City c2 = new City("City2", d2);

        Disease d3 = new Disease(3, 0);
        City c3 = new City("City3", d3);

        LinkedList<Card> cardPile = new LinkedList<Card>();

        PlayerCard pc1 = new PlayerCard(c1, d1);
        PlayerCard pc2 = new PlayerCard(c2, d2);
        PlayerCard pc3 = new PlayerCard(c3, d3);

        cardPile.add(pc1);
        cardPile.add(pc2);
        cardPile.add(pc3);

        Deck<Card> deck = new Deck<Card>(cardPile);
    
    
    
    
        assertTrue(deck.drawCard().equals(pc3));

    }

    @Test
    public void discardTest(){
        Disease d1 = new Disease(1, 0);
        City c1 = new City("City1", d1);

        Disease d2 = new Disease(2, 0);
        City c2 = new City("City2", d2);

        Disease d3 = new Disease(3, 0);
        City c3 = new City("City3", d3);

        LinkedList<Card> cardPile = new LinkedList<Card>();

        PlayerCard pc1 = new PlayerCard(c1, d1);
        PlayerCard pc2 = new PlayerCard(c2, d2);
        PlayerCard pc3 = new PlayerCard(c3, d3);

        cardPile.add(pc1);
        cardPile.add(pc2);
        cardPile.add(pc3);

        Deck<Card> deck = new Deck<Card>(cardPile);
        deck.discard(pc2);
        assertTrue(deck.getDiscardPile().contains(pc2));
    }

    @Test
    public void resetDeckTest(){
        Disease d1 = new Disease(1, 0);
        City c1 = new City("City1", d1);

        Disease d2 = new Disease(2, 0);
        City c2 = new City("City2", d2);

        Disease d3 = new Disease(3, 0);
        City c3 = new City("City3", d3);

        LinkedList<Card> cardPile = new LinkedList<Card>();

        PlayerCard pc1 = new PlayerCard(c1, d1);
        PlayerCard pc2 = new PlayerCard(c2, d2);
        PlayerCard pc3 = new PlayerCard(c3, d3);

        cardPile.add(pc1);
        cardPile.add(pc2);
        cardPile.add(pc3);

        Deck<Card> deck = new Deck<Card>(cardPile);
        while (deck.getFullDeck().size() > 0){
            deck.discard(deck.drawCard());
        }
        deck.resetDeck();
        assertTrue(deck.getDiscardPile().size() == 0);
        assertTrue(deck.getFullDeck().size() == 3);
    }
}
