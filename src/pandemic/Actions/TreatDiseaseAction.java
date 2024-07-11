package pandemic.Actions;
// import pandemic.Cards.*;
import pandemic.Players.*;
import pandemic.Game;

public class TreatDiseaseAction extends Action {
    /**
     * Constructor for the treat disease action 
     */
    public TreatDiseaseAction(){};

    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player player, Game game) throws Exception {
        if ( player.getLocation().getDisease().hasRemedy()){
            while(player.getLocation().getCubes() > 0){
                player.getLocation().cure();
            }
            System.out.println(" the player " + player.getName() + " wiped out the cubes in " + player.getLocation().getName());
        }
        else{ player.getLocation().cure();
        System.out.println(" the player " + player.getName() + " cured a patient in " + player.getLocation().getName());}
    }

    public String getName(){return "Treat disease";}
}
