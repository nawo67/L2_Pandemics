package pandemic.Actions;
import pandemic.Game;
import pandemic.Players.Doctor;
import pandemic.Players.Player;

public class DoctorTreatAction extends  TreatDiseaseAction {

    /**
     * Constructor for the treat action specific to the doctor role
     */
    public DoctorTreatAction(){}

    /**
     * @param player the player who executes the action
     * @param game the game in which the action will be executed
     */
    public void execute(Player p, Game game) throws Exception {
        while ( p.getLocation().getCubes() > 0){
            p.getLocation().cure();
        }
        System.out.println( "the doctor " + p.getName() + " treated the disease in " + p.getLocation().getName()  );
    }

}
