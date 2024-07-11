package pandemic.Players;

//import java.util.LinkedList;

import pandemic.City;
import pandemic.Actions.*;
//import pandemic.Cards.Card;
//import pandemic.Cards.PlayerCard;

public class Scientist extends Player {

    /**
     * Constructor for the class Scientist to create a new scientist
     * @param name player's name
     * @param location player's location
     */
    public Scientist(String name,City location) {
        super(name,location);

        this.actions.add(new MoveAction());
        this.actions.add(new TreatDiseaseAction());
        this.actions.add(new ScientistFindRemedyAction());
        this.actions.add(new BuildAction());
    }

    public String getRole(){
        return " Scientist ";
    }


    
}

