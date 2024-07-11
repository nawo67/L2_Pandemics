package pandemic.Actions;
import pandemic.Game;
import pandemic.Players.*;

public class PassAction extends Action{
    /**
     * Constructor for the pass action
     */
    public PassAction(){}

    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player p, Game game) throws Exception {
        System.out.println( " the player " + p.getName() + " passed their turn ");
    }

    public String getName(){return "Pass";}
}
