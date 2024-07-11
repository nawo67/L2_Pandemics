package pandemic;
import pandemic.Game;
import pandemic.Players.*;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import pandemic.Actions.*;
import pandemic.Cards.PlayerCard;

public class FindRemedyActionTest {
    @Test (expected = Exception.class)
    public void FindRemedyException1Test() throws Exception{
    Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false)
    .setHandsAndDeck();
    LinkedList<Player> players = g.getPlayers();
    players.get(0).getLocation().placeResearchLab();
    FindRemedyAction fr = new FindRemedyAction();
    fr.execute(players.get(0), g);
    }

    @Test (expected = Exception.class)
    public void FindRemedyException2Test() throws Exception{
    Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    //.setHandsAndDeck();
    LinkedList<Player> players = g.getPlayers();
    //players.get(0).getLocation().placeResearchLab();
    FindRemedyAction fr = new FindRemedyAction();
    fr.execute(players.get(0), g);
    }

    @Test 
    public void FindRemedyStandardTest(){
    Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    Disease d = g.getMap().getDiseaseList().get(1);
    PlayerCard pc1 = new PlayerCard(g.getMap().getCities().get(0), d);
    PlayerCard pc2 = new PlayerCard(g.getMap().getCities().get(1), d);
    PlayerCard pc3 = new PlayerCard(g.getMap().getCities().get(2), d);
    PlayerCard pc4 = new PlayerCard(g.getMap().getCities().get(3), d);
    PlayerCard pc5 = new PlayerCard(g.getMap().getCities().get(4), d);

    
    LinkedList<Player> players = g.getPlayers();
    players.get(0).getLocation().placeResearchLab();
    players.get(0).getHand().add(pc1);
    players.get(0).getHand().add(pc2);
    players.get(0).getHand().add(pc3);
    players.get(0).getHand().add(pc4);
    players.get(0).getHand().add(pc5);
    FindRemedyAction fr = new FindRemedyAction();
    try {
        fr.execute(players.get(0), g);
        assertTrue(d.hasRemedy());
    } catch (Exception e) {
        
        e.printStackTrace();
    }}

    @Test 
    public void FindRemedyScientistTest(){
    Game g = new Game().setMap("data/carte2.json")
    .addScientist("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addDoctor("bubbleTea", false);
    Disease d = g.getMap().getDiseaseList().get(1);
    PlayerCard pc1 = new PlayerCard(g.getMap().getCities().get(0), d);
    PlayerCard pc2 = new PlayerCard(g.getMap().getCities().get(1), d);
    PlayerCard pc3 = new PlayerCard(g.getMap().getCities().get(2), d);
    PlayerCard pc4 = new PlayerCard(g.getMap().getCities().get(3), d);
    

    //PlayerCard pc5 = new PlayerCard(g.getMap().getCities().get(4), d);

    
    LinkedList<Player> players = g.getPlayers();
    players.get(0).getLocation().placeResearchLab();
    players.get(0).getHand().add(pc1);
    players.get(0).getHand().add(pc2);
    players.get(0).getHand().add(pc3);
    players.get(0).getHand().add(pc4);
    FindRemedyAction fr = new ScientistFindRemedyAction();
    try {
        fr.execute(players.get(0), g);
        assertTrue(d.hasRemedy());
    } catch (Exception e) {
        
        e.printStackTrace();
    }





}





}
