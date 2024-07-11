package pandemic.Actions;
import pandemic.*;
import pandemic.Players.Player;
import java.util.*;

public class MoveAction extends Action {
    /**
     * Constructor for the move action
     */
    public MoveAction(){}

    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player player, Game game) throws Exception {
        List<City> neighbors1 = player.getLocation().getNeighbors();
        List<String> neighbors2 = new ArrayList<String>();
        for ( City c : neighbors1){
            neighbors2.add(c.getName());
        }
        int index = player.choose(neighbors2);
       
        player.setLocation(neighbors1.get(index));
        System.out.println( " the player " + player.getName() + " moved to " + neighbors1.get(index).getName());
    }

    public String getName(){return "Move";}
}

