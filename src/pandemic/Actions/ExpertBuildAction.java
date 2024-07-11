package pandemic.Actions;
import java.util.jar.Attributes.Name;

import pandemic.Players.*;
import pandemic.Game;

public class ExpertBuildAction extends BuildAction {
    /**
     * Constructor for the build action specific to the expert role
     */
    public ExpertBuildAction(){}


    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player player, Game game) throws Exception {
        if(!player.getLocation().hasLab()) {
            player.getLocation().placeResearchLab();
            System.out.println( player.getName() + " built a research lab in " + player.getLocation().getName());
        } else {
            throw new Exception("There's already a lab :(");
        }
    }

  
}
