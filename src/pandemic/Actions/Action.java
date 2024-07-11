package pandemic.Actions;
import pandemic.Game;
import pandemic.Players.*;

public abstract class Action {

    public abstract String getName();
    
    public abstract void execute(Player player, Game game) throws Exception;
}
