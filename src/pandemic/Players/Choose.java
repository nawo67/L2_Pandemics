package pandemic.Players;
import java.util.*;

public interface Choose {

    /**
     * method that will allow the player to pick out their next action
     * @param options the options available to choose from 
     * @return  the index of the option chosen 
     */
    public int choose(List<String> options);
    
}
