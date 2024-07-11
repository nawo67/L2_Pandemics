package pandemic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InitCardsTest {
    
    @Test
    public void createFullInfectionDeckTest(){
        JSONMap map = new JSONMap("data/map4test.json", 2, 1);
        map.parseJSON();
        InitCards ic = new InitCards(map);
        assertTrue(ic.createFullInfectionDeck().size() == 2); // car deux villes dans le json map4test

    }

    @Test
    public void createFullPlayerDeck(){
        JSONMap map = new JSONMap("data/map4test.json", 2, 1);
        map.parseJSON();
        InitCards ic = new InitCards(map);
        assertTrue(ic.createFullPlayerDeck().size() == 4); // car deux villes et deux maladies dans le json map4test
    }
}
