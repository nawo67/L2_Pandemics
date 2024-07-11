package pandemic;


import java.util.*;
import pandemic.Cards.*;
import pandemic.Players.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        String file = "data/carte2.json";
        if (args.length >= 1){file = args[0];}
        game.setMap(file)
            .addDoctor("Nicki Minaj", true)
            .addExpert("Aki", false)
            .addGlobetrotter("Oscar", false)
            .addScientist("Onyks", false)
            .setHandsAndDeck()
            .initialInfection();
            while ( !game.isGameOver()){
            game.playOneRound();
            if (game.GameWon()){ System.out.println(" Congrats! You won!!"); break;}
            else{ System.out.println( " Better luck next time :("); break;}}

        //System.out.println(game.toString()); 
        

            
        
        
    }

    
}
