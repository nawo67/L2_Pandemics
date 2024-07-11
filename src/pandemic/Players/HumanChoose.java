package pandemic.Players;

import java.util.*;

public class HumanChoose implements Choose {
    private final static Scanner scanner = new Scanner(System.in);


    /**
     * method that will allow a human player to pick out their next option
     * @param options the options to choose from
     */
    public int choose(List<String> options) {
        System.out.println("Pick out one action for your player to execute :");
        for (int i = 0; i < options.size(); ++i) {
            
            System.out.println(String.format("\t%1$3d : %2$s", i, options.get(i)));
        }
        System.out.println("> ");
        if(scanner.hasNextInt()) {
            int chosenOption = scanner.nextInt();
            if(0 < chosenOption && chosenOption < options.size()) {
                return chosenOption;
            }
            return 0;
        } else {
            return 0;
        }
    }
    
    
}
