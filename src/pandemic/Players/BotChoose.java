package pandemic.Players;
import java.util.*;

public class BotChoose implements Choose {
    private static Random random = new Random();

    /**
     * method that will pick out a random action to act as a bot
     * @param options the options available to choose from
     * @return the index of the action chosen 
     */
    @Override
    public int choose(List<String> options) {
        return random.nextInt(options.size());
    }

    
    
    }

    
    

