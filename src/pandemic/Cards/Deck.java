package pandemic.Cards;

import java.util.*;

public class Deck<Cards extends Card> {
    protected LinkedList<Cards> fullDeck;
    protected LinkedList<Cards> discardPile;


    /**
     * Constructor for deck class to build a full deck of cards
     * @param fullDeck
     * @param discardPile
     */
    public Deck(LinkedList<Cards> fullDeck){
        this.discardPile = new LinkedList<Cards>();
        this.fullDeck = fullDeck;
    }

    /**
     * method that allows you to draw a card from a deck
     * @return last card in the deck
     */
    public Cards drawCard(){
        return this.fullDeck.removeLast();}
    
    /**
     * method that allows you to discard a card 
     * @param c card to be discarded
     */
    public void discard(Cards c){
        this.discardPile.add(c);}
    
    /**
     * if the deck is empty at any point in the game this method is used to reset it using the cards in the discard pile
     */
    public void resetDeck(){
        if ( this.fullDeck.size() == 0){
            while ( this.discardPile.size() > 0){
                this.fullDeck.add(this.discardPile.removeLast());}}
        this.shuffle();
        }

        public void shuffle() {
            Collections.shuffle(this.fullDeck);
        }

    /**
    * get the fulldeck
    * @return the fulldeck
    */
    public LinkedList<Cards> getFullDeck(){
        return this.fullDeck;
    }

    /**
     * get the discard pile
     * @return the discard pile
     */
    public LinkedList<Cards> getDiscardPile(){
        return this.discardPile;
    }
}
