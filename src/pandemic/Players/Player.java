package pandemic.Players;
import java.util.*;

import pandemic.Actions.*;

import pandemic.*;
import pandemic.Cards.Card;
import pandemic.Cards.Deck;
import pandemic.Cards.PlayerCard;

public abstract class Player {
    private String name;
    private LinkedList<PlayerCard> hand;
    private City location;
    private Choose choice;
    protected List<Action> actions;

    /**
     * Constructor for the class player to create a new player 
     * @param name player's name
     * @param hand player's hand
     */
    public Player(String name,  City location){
        this(name,location,new BotChoose());
    }

    public Player(String name,  City location, Choose chooseFunction) {
        this.name = name;
        this.hand = new LinkedList<PlayerCard>();
        this.location = location;
        this.choice = chooseFunction;

        this.actions = new ArrayList<Action>();
        this.actions.add(new PassAction());
    }

   
    /**
     * get the player's name
     * @return the player's name
     */    
    public String getName(){
        return this.name;
    }

    /**
     * get the player's location 
     * @return the player's location
     */    
    public City getLocation(){
        return this.location;
    }

    /**
     * get the player's hand 
     * @return the player's hand
     */    
    public LinkedList<PlayerCard> getHand(){
        return this.hand;
    }

    /**
     * String representation of the player
     * @return Representation of the player
     */
    public String toString(){
        String s = "";
        for ( Card c : this.hand){
            s += c.toString();
        }
        return " the player " + this.name + " has the following cards " + s + " and is located in " + this.location.toString();
    }


    /* public void move(City destination){
        for ( City c : this.location.getNeighbors()){
            if (c.equals(destination)){
                this.location = destination;
            }

            else{
                System.out.println("can't move to non neighboring City");
            }
        }}

    public void build(){
        for (Card c : this.hand){
            if ( ((PlayerCard)c).getCity().equals(this.location) && (!this.location.hasLab())){
                this.location.placeResearchLab();
            }
            else{
                System.out.println("Can't build research lab without the right player card");
            }
        }
    } */


    /**
     * defines the hand passed as a parameter to the player
     * @param hand the hand to set
     */    
    public void setHand(LinkedList<PlayerCard> hand){
        this.hand = hand;
    }

    /**
     * defines the location passed as a parameter to the player
     * @param c the city to set
     */    
    public void setLocation(City c){
        this.location = c;
    }

    public void setToHuman(){
        this.choice = new HumanChoose();
    }

    public void printHand(){
        for (Card c : this.hand){
            System.out.println(c.toString());

        }
    }

    public int choose(List<String> options){
        return this.choice.choose(options);
    }

    public PlayerCard discard(int index){
        return this.hand.remove(index);
    }

    public void draw(PlayerCard pc ){
        this.hand.add(pc);
    }

    public String getRole() {
        return "";
    }    

    //public void drawOneCard(Deck<Card> deck){
      //  this.hand.add(deck.getFullDeck().removeLast());
    //}

    
    public List<Action> getActions() {
        return actions;
    }
    
}