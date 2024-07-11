package pandemic.Actions;
import java.util.LinkedList;

import pandemic.Cards.Card;
import pandemic.Cards.Deck;
import pandemic.Cards.PlayerCard;
import pandemic.Players.*;
import pandemic.*;

public class FindRemedyAction extends Action{
    /**
     * Constructor for the remedy action 
     */
    public FindRemedyAction(){};

    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player p, Game game) throws Exception{
        if (!p.getLocation().hasLab()){throw new Exception(" Can't find remedy without a lab");}
        else{
            //int count = 0;
             LinkedList<PlayerCard> hand = p.getHand();
             LinkedList<Disease> diseases = new LinkedList<Disease>();
             //LinkedList<PlayerCard> cardsToDiscard = new LinkedList<PlayerCard>();
             for ( PlayerCard c : hand){
                 if (!diseases.contains(c.getDisease())){
                     diseases.add(c.getDisease());
                 }
             }

             for (Disease d : diseases){
                if (this.countCardsForDisease(d, p).size() >= 5){
                    d.setRemedy();
                    int count = 0;
                    for (PlayerCard pc : this.countCardsForDisease(d, p)){
                        count += 1;
                        game.getPlayerCards().discard(pc);
                        if (count == 5){
                            d.setRemedy();
                            System.out.println(p.getName() + " found a remedy for disease number " + d.getId() );
                            break;}}
                }
                else{ throw new Exception(" You don't have the right cards for this action ");}

            }
        }
    }

    public LinkedList<PlayerCard> countCardsForDisease(Disease d, Player p){
        LinkedList<PlayerCard> n = new LinkedList<PlayerCard>();
        for (PlayerCard pc : p.getHand()){
            if (pc.getDisease().equals(d)){ n.add(pc); }
        }
        return n;
    }

public String getName(){ return " Find remedy";}}
