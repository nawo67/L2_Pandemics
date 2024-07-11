package pandemic;

//import java.lang.reflect.Constructor;
//import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pandemic.Cards.*;

//import pandemic.Players.*;

public class InitCards {
    // this class will be used to initialize the cards you need for a game of pandemic
    private Map map;

    /**
     * create a Initcards object
     * @param map the map of the game
     */
    public InitCards(Map map){
        this.map = map;
       
    }

    // public List<Card> createFullDeck(){
    //     List<City> Cities = this.map.getCities();
    //     LinkedList<Card> fullDeck = new LinkedList<Card>();
    //     List<Disease> diseases = this.map.getDiseaseList();
    //     for (City c : Cities){
    //         for ( Disease d : diseases){
    //             PlayerCard pc = new PlayerCard(c, d);
    //             fullDeck.add(pc);
    //         }
    //     }
    //     for (int i=0; i < 4; i++){
    //         EpidemicCard ec = new EpidemicCard();
    //         fullDeck.add(ec);
    //     }
    //     Collections.shuffle(fullDeck); // melange du deck
    //     return fullDeck;
    // }

    /**
     * create a deck of infection cards
     * @return the list of infection cards
     */
    public List<InfectionCard> createFullInfectionDeck(){
        List<City> Cities = this.map.getCities();
        List<InfectionCard> fullDeck = new LinkedList<InfectionCard>();
        //List<Disease> diseases = this.map.getDiseaseList();
        for (City c : Cities){
                InfectionCard ic = new InfectionCard(c, c.getDisease());
                fullDeck.add(ic);
        }
        Collections.shuffle(fullDeck);
        return fullDeck;
    }

    /**
     * create a deck of players cards
     * @return the list of players cards
     */
    public LinkedList<Card> createFullPlayerDeck(){
        List<City> Cities = this.map.getCities();
        LinkedList<Card> fullDeck = new LinkedList<Card>();
        List<Disease> diseases = this.map.getDiseaseList();
        for (City c : Cities){
            for ( Disease d : diseases){
                PlayerCard pc = new PlayerCard(c, d);
                fullDeck.add(pc);
            }
        }
        Collections.shuffle(fullDeck);
        return fullDeck;
    }
 
}
