package pandemic.Players;


import pandemic.City;
import pandemic.Actions.*;

public class Globetrotter extends Player {

    /**
     * Constructor for the class Globetrotter to create a new globetrotter
     * @param name player's name
     * @param location player's location
     */
    public Globetrotter(String name,City location) {
        super(name,location);

        this.actions.add(new GlobetrotterMoveAction());
        this.actions.add(new TreatDiseaseAction());
        this.actions.add(new FindRemedyAction());
        this.actions.add(new BuildAction());
    }

    
    public String getRole(){
        return " Globetrotter ";
    }

    
}
