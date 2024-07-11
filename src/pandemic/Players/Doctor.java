package pandemic.Players;

import java.util.LinkedList;

//import pandemic.Cards.Card;
import pandemic.Cards.PlayerCard;
import pandemic.*;
import pandemic.Actions.*;

public class Doctor extends Player {

    /**
     * Constructor for the class Doctor to create a new doctor
     * @param name player's name
     * @param location player's location
     */
    public Doctor(String name, City location) {
        super(name,location);

        this.actions.add(new MoveAction());
        this.actions.add(new DoctorTreatAction());
        this.actions.add(new FindRemedyAction());
        this.actions.add(new BuildAction());
    }

    public String getRole(){
        return " Doctor ";
    }


    
}
