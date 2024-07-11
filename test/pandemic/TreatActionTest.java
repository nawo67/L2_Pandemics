package pandemic;
import pandemic.Game;
import pandemic.Players.*;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import pandemic.Actions.*;


public class TreatActionTest {
    @Test
    public void TreatWremedyTest(){
        Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    LinkedList<Player> players = g.getPlayers();
    players.get(0).getLocation().infect(2);
    players.get(0).getLocation().getDisease().setRemedy();
    TreatDiseaseAction t = new TreatDiseaseAction();
    try {
        t.execute(players.get(0), g);
        assertTrue(players.get(0).getLocation().getCubes() == 0);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Test
    public void TreatWOremedyTest(){
        Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    LinkedList<Player> players = g.getPlayers();
    players.get(0).getLocation().infect(2);
    //players.get(0).getLocation().getDisease().setRemedy();
    TreatDiseaseAction t = new TreatDiseaseAction();
    try {
        t.execute(players.get(0), g);
        assertTrue(players.get(0).getLocation().getCubes() == 1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Test
    public void TreatDoctorTest(){
        Game g = new Game().setMap("data/carte2.json")
    .addDoctor("Yoshi", false)
    .addExpert("Bruh", false)
    .addGlobetrotter("Bronnie", false)
    .addScientist("bubbleTea", false);
    LinkedList<Player> players = g.getPlayers();
    players.get(0).getLocation().infect(2);
    //players.get(0).getLocation().getDisease().setRemedy();
    TreatDiseaseAction t = new DoctorTreatAction();
    try {
        t.execute(players.get(0), g);
        assertTrue(players.get(0).getLocation().getCubes() == 0);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    
    
}
