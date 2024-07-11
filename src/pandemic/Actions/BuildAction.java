package pandemic.Actions;
import pandemic.Players.*;
import pandemic.Cards.*;
import pandemic.Game;

public class BuildAction extends Action {
    
    /**
     * Constructor for the build action
     */
    public BuildAction(){}

     /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player player, Game game) throws Exception{
        for ( Card c : player.getHand()){
            PlayerCard c2 = ( PlayerCard) c;
            if ( c2.getCity().equals(player.getLocation())){
                c2.getCity().placeResearchLab();
                player.getHand().remove(c);
                game.getPlayerCards().discard(c);
                System.out.println( player.getName() + " built a research lab in " + player.getLocation().getName());
                return;
            } 
        }
        throw new Exception(" can't build without having the right card silly goose!");
    }
    
    
    public String getName(){return "Build";}
}


      

