package pandemic.Actions;

import java.util.ArrayList;
import java.util.List;

import pandemic.City;
import pandemic.Game;
import pandemic.Players.Globetrotter;
import pandemic.Players.Player;

public class GlobetrotterMoveAction extends MoveAction {
    /**
     * Constructor for the move action specific to the globetrotter role
     */
    public GlobetrotterMoveAction() { }


    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player player, Game game){
        List<String> cities = new ArrayList<String>();
        List<City> mapCities = game.getMap().getCities();
        for (City city : mapCities) {
            cities.add(city.getName());
        }
        int index = player.choose(cities);
        City dest = mapCities.get(index);
        player.setLocation(dest);

        System.out.println( "The globetrotter " + player.getName() + " moved to " + player.getLocation().getName());
    }

    public String getName(){return "Move";}
}
