package pandemic;
import pandemic.Game;
import pandemic.Players.*;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import pandemic.Cards.Card;

import org.junit.Test;
import pandemic.Actions.*;
import pandemic.Cards.PlayerCard;

public class BuildActionTest {


    @Test ( expected = Exception.class)
    public void BuildActionExceptionTest() throws Exception {
    Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    //.setHandsAndDeck();
    LinkedList<Player> players = g.getPlayers();
    //PlayerCard pc = new PlayerCard(new City("Bruh", new Disease(0, 0)), new Disease(0, 0));
    //players.get(0).setHand(new LinkedList<PlayerCard>());

    BuildAction b = new BuildAction();
    b.execute(players.get(0), g);
}

    @Test
    public void BuildActionStandardTest() {
        Game g = new Game().setMap("data/carte2.json")
        .addDoctor("Yoshi", false)
        .addExpert("Bruh", false)
        .addGlobetrotter("Bronnie", false)
        .addScientist("bubbleTea", false)
        .setHandsAndDeck();
        LinkedList<Player> players = g.getPlayers();
        BuildAction b = new BuildAction();
        PlayerCard pc = new PlayerCard(players.get(0).getLocation(),g.getMap().getDiseaseList().get(0));
        players.get(0).getHand().add(pc);
        try {
            b.execute(players.get(0), g);
            assertTrue(players.get(0).getLocation().hasLab());
        } catch (Exception e) {
            
            e.printStackTrace();
        }}

    @Test
    public void BuildActionExpertTest(){
    Game g = new Game().setMap("data/carte2.json")
    .addExpert("Yoshi", false)
    .addDoctor("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    //.setHandsAndDeck();

    LinkedList<Player> players = g.getPlayers();
    BuildAction b = new ExpertBuildAction();
    try {
        b.execute(players.get(0), g);
        assertTrue(players.get(0).getLocation().hasLab());
    } catch (Exception e) {
        
        e.printStackTrace();
    }
    }

        








}
