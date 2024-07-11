package pandemic.Players;

import java.util.LinkedList;

import pandemic.City;
import pandemic.Actions.ExpertBuildAction;
import pandemic.Actions.FindRemedyAction;
import pandemic.Actions.MoveAction;
import pandemic.Actions.TreatDiseaseAction;
//import pandemic.Cards.Card;
import pandemic.Cards.PlayerCard;

public class Expert extends Player{

    /**
     * Constructor for the class Expert to create a new expert
     * @param name player's name
     * @param location player's location
     */
    public Expert(String name,  City location) {
        super(name, location);

        this.actions.add(new MoveAction());
        this.actions.add(new TreatDiseaseAction());
        this.actions.add(new FindRemedyAction());
        this.actions.add(new ExpertBuildAction());
    }

    public String getRole(){
        return " Expert ";
    }

    
}
