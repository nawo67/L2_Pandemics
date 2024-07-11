package pandemic;
import pandemic.Game;
import pandemic.Players.*;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import pandemic.Actions.*;

public class MoveActionTest {

    @Test
    public void MoveActionStandardTest(){
    Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    LinkedList<Player> players = g.getPlayers();
    MoveAction m = new MoveAction();
    try {
        City c = players.get(0).getLocation();
        m.execute(players.get(0), g);
        assertTrue(players.get(0).getLocation()!= c);
    } catch (Exception e) {
        
        e.printStackTrace();
    }}

    @Test
    public void MoveActionGlobetrotterTest(){
    Game g = new Game().setMap("data/carte2.json")
    .addGlobetrotter("Yoshi", false)
    .addExpert("Bruh", false)
    .addDoctor("Bronnie", false)
    .addScientist("bubbleTea", false);
    LinkedList<Player> players = g.getPlayers();
    MoveAction m = new GlobetrotterMoveAction();
    try {
        City c = players.get(0).getLocation();
        m.execute(players.get(0), g);
        assertTrue(players.get(0).getLocation()!= c);
    } catch (Exception e) {
        
        e.printStackTrace();
    }}
    
}
