package pandemic;
import java.security.InvalidParameterException;
import java.util.*;

import pandemic.Cards.Card;
import pandemic.Cards.Deck;
import pandemic.Cards.EpidemicCard;
import pandemic.Cards.InfectionCard;
import pandemic.Cards.PlayerCard;
import pandemic.Players.*;
import pandemic.Actions.*;


public class Game {
    private Map map;
    private List<Player> players;
    private Deck<Card> playerCards;
    private Deck<InfectionCard> infectionCards;
    private int globalInfectionRate;
    private Choose hChoose;
    private Choose bChoose;
    
    /**
    * create a game object
    */
    public Game(){
        this.map = null;
        this.players = new LinkedList<Player>();
        this.playerCards = null;
        this.infectionCards = null;
        this.globalInfectionRate = 0;
        this.hChoose = new HumanChoose();
        this.bChoose = new BotChoose();
        
    }
    
    /**
    * Define the map where the game will run
    * @param filename the name of the map 
    * @return the game
    */
    public Game setMap(String filename){
        this.map = new JSONMap(filename, 4, 24);
        ((JSONMap) this.map).parseJSON();
        return this;
    }
    
    /**
    * Adds the player to the game
    * @param newPlayer the player to add
    * @return the game     
    */
    protected Game addPlayerWithRole(Player newPlayer, boolean Human) {
        for(Player p : this.players) {
            if(p.getClass() == newPlayer.getClass()){
                throw new InvalidParameterException("Player with same role exists");
            }
        }
        
        if(this.map == null) throw new InvalidParameterException("No board");
        
        if (Human){newPlayer.setToHuman();}
        
        this.players.add(newPlayer);
        return this;
    }
    
    /**
    * Adds an expert to the game
    * @param name the name of the expert player
    * @return the game
    */    
    public Game addExpert(String name, boolean Human) {
        this.addPlayerWithRole(new Expert(name, getRandomCity()), Human);
        
        return this;
    }
    
    /**
    * Adds a doctor to the game
    * @param name the name of the doctor player
    * @return the game
    */    
    public Game addDoctor(String name, boolean Human) {
        this.addPlayerWithRole(new Doctor(name, getRandomCity()), Human);  
        return this;
    }
    
    /**
    * Adds a globetrotter to the game
    * @param name the name of the globetrotter player
    * @return the game
    */    
    public Game addGlobetrotter(String name, boolean Human) {
        this.addPlayerWithRole(new Globetrotter(name, getRandomCity()), Human); 
        return this; 
    }
    
    /**
    * Adds a scientist to the game
    * @param name the name of the scientist player
    * @return the game
    */    
    public Game addScientist(String name, boolean Human) {
        this.addPlayerWithRole(new Scientist(name, getRandomCity()), Human); 
        return this;
    }
    
    
    
    /**
    * Initializes the player's hands and the game's cards
    * @return the game
    */    
    public Game setHandsAndDeck(){
        // initialisation des mains + cartes :
        InitCards init = new InitCards(this.map);
        Deck<Card> deck = new Deck<Card>(init.createFullPlayerDeck());
        
        // Création d'une main
        // for joueur :
        // creer main : 
        // for carte in nombre de carte que je veux dans chaque main :
        // créer carte random
        // rajouter carte à la main
        // assigner main à joueur 
        
        for (Player player : this.players){
            // creation de la main :
            LinkedList<PlayerCard> hand = new LinkedList<PlayerCard>();
            for ( int i = 0; i < 2; i++){
                hand.add((PlayerCard) deck.drawCard());
            }
            player.setHand(hand);
        }
        
        // initialisation du deck de la partie :
        for ( int i = 0; i < 4 ; i++){
            EpidemicCard ec = new EpidemicCard();
            // gameCards.add(ec);
            deck.getFullDeck().add(ec);
            deck.shuffle();
        }
            
        Deck<InfectionCard> infectionDeck = new Deck<InfectionCard>((LinkedList<InfectionCard>) init.createFullInfectionDeck());
        
        this.infectionCards = infectionDeck;
        this.playerCards = deck;
        return this;
        
    }
        
        // public Game addHumanPlayer(Player newPlayer){
    //   for(Player p : this.players) {
    //     if(p.getClass() == newPlayer.getClass()){
    //     throw new InvalidParameterException("Player with same role exists");
    //   }
    // }

    // if(this.map == null) throw new InvalidParameterException("No board");

    // newPlayer.setToHuman();
    // this.players.add(newPlayer);
    // return this;
    //}

    /**
    * Initializes infected cities
    * @return the game
    */    
    public Game initialInfection(){
        for ( int i = 0; i < 3; i++){
            InfectionCard c = this.infectionCards.drawCard();
            c.getCity().infect(3);
            infectionCards.discard(c);
            System.out.println(" The city " + c.getCity().getName() + " will be infected with 3 cubes");
        }
        
        for ( int i = 0; i < 3; i++){
            InfectionCard c = this.infectionCards.drawCard();
            c.getCity().infect(2);
            infectionCards.discard(c);
            System.out.println(" The city " + c.getCity().getName() + " will be infected with 2 cubes");
        }
        
        for ( int i = 0; i < 3; i++){
            InfectionCard c = this.infectionCards.drawCard();
            c.getCity().infect(1);
            infectionCards.discard(c);
            System.out.println(" The city " + c.getCity().getName() + " will be infected with 1 cube");
        }
        return this;
    }


    /**
    * Get a random city
    * @return the chosen city
    */
    private City getRandomCity(){
        Random random = new Random();
        List<City> cities = this.map.getCities();
        int i = random.nextInt(cities.size());
        return cities.get(i);
        
    }

    /**
    * String representation of the Game
    * @return Representation of the Game
    */
    public String toString(){
        String s = "";
        for ( Player p : this.players){
            s = s + " " + p.getName();
        }
        return " This game uses the following map \n" + this.map.toString() + " the following players are participating \n " + s; 
    }

    /**
    * Deal two cards to each player
    */
    // public void drawCards(){
    //     for ( Player p : this.players){
    //         for (int i = 0; i < 2; i++){
    //             Card c = this.playerCards.drawCard();
    //             if ( c instanceof EpidemicCard){
    //                 this.globalInfectionRate += 1;
    //                 InfectionCard c2 = this.infectionCards.drawCard();
    //                 this.infectionCards.discard(c2);
    //                 this.infectionCards.shuffle();
    //                 c2.getCity().infect(1);}
                    
    //                 p.getHand().add((PlayerCard) c);
    //             }
    //         }
                
    // }
    
    protected void handleAction(Player player) {
        for(int i = 0; i < 4; ++i) {
            player.printHand();
            List<String> options = new ArrayList<String>();
            for (Action act : player.getActions()) {
                options.add(act.getName());
            }
            int chosenActionId = player.choose(options);          
            Action chosenAction = player.getActions().get(chosenActionId);
            try {
                chosenAction.execute(player, this);
                System.out.println("Action executed : " + chosenAction.getName());
            } catch(Exception e) {
                System.err.println("Error performing action " + chosenAction.getName() + " : " + e.getMessage());
            }
        }
    }
    
    
    
    /**
     * methods that infects the right city depending on the infection card drawn
     */
    protected void playInfector() {
        for(int i = 0; i<this.globalInfectionRate;i++) {
            InfectionCard drawnCard = this.infectionCards.drawCard();
            System.out.println("Drawn "+drawnCard);
            drawnCard.getCity().infect(1);
            infectionCards.discard(drawnCard);
        }
    }
    
    /**
     * method that starts an infection phase
     */
    protected void InfectionPhase() {
        InfectionCard drawnCard = infectionCards.drawCard();
        System.out.println("drawn " + drawnCard);
        drawnCard.getCity().infect(1);
        //this.epidemic = false;
        infectionCards.discard(drawnCard);
        infectionCards.resetDeck();
    }

    /** 
     * methods that allows each player to draw two cards and has the game react accordingly
     * @param player the player that will draw their two cards
     */
    protected void drawCards(Player player){
        // Tirer deux cartes
        for (int i = 0; i < 2 ; ++i) {
            Card drawnCard = playerCards.drawCard();
            System.out.println("Drawn " + drawnCard);
            // Carte épidémie
            if (drawnCard instanceof EpidemicCard) {
                //this.epidemic = true;
                globalInfectionRate+=1;
                playInfector();
                playerCards.discard(drawnCard);
            } else {
                player.draw((PlayerCard)drawnCard);
            }
            if (player.getHand().size() >= 7){
                System.out.println("Which card to you want to discard ?");
                List <String> cardList = new ArrayList<String>();
                for(PlayerCard c : player.getHand()) {
                    cardList.add(c.toString());
                }
                int index = player.choose(cardList);
                PlayerCard card = player.discard(index);
                this.playerCards.discard(card);
            }
        }
    }

    /**
     * method to play one turn 
     * @param player
     */
    protected void processTurn(Player player){
        System.out.println("[" + player.getName() + " turn (Starts on " + player.getLocation().getName() + ") - Role: "+ player.getName() +"]");
        // Choix de 4 actions
        handleAction(player);
        drawCards(player);

        // Jouer l'infecteur
        playInfector();
    }

    /**
     * method to check if the game is over
     */
    protected boolean isGameOver(){
        // verifier si toutes maladies cured :
        // verif toutes villes infectées 
        // verif plus de cubes 
        // verif si 8+ foyer infection 

        boolean areAllCured = true;
        for ( Disease d : this.map.getDiseaseList()){
            if (!d.hasRemedy()){ areAllCured = false; break;}
        }

        boolean AllInfected = true;
        for (City c : this.map.getCities()){
            if ( !(c.getCubes() >= 1)){
                AllInfected = false; break;
            }
        }

        boolean noMoreCubes = false;
        int count = 0;
        for ( Disease d : this.map.getDiseaseList()){
            if ( d.getNumberOfCubes() > 0){ count++;}
        }
        if (count == 0){noMoreCubes = true;}

        


        boolean tooManyInfectionPoints;
        int count2 = 0;
        for ( City c : this.map.getCities()){
            if (c.getIsFocusOfInfection()){ count2 += 1;}
        }

        tooManyInfectionPoints = count2 >= 8;

        return (tooManyInfectionPoints || AllInfected || areAllCured || noMoreCubes);



    }

    public boolean GameWon(){
        boolean areAllCured = true;
        for ( Disease d : this.map.getDiseaseList()){
            if (!d.hasRemedy()){ areAllCured = false; break;}
        }
        return areAllCured;
    }

    /**
     * method to play one round
     * @return the game currently being played 
     */
    int round = 0;
    public Game playOneRound(){
        System.out.println("\n round number " + round);
        round++;
        for (Player p : this.players){
            System.out.println(p.getName() + "'s turn [role="+p.getRole()+"]");
            handleAction(p);
        }
        return this;
    }

    public Deck<Card> getPlayerCards() {
        return playerCards;
    }

    public Deck<InfectionCard> getInfectionCards() {
        return infectionCards;
    }

    public LinkedList<Player> getPlayers(){
        return (LinkedList<Player>) this.players;
    }

    public Map getMap() {
        return map;
    }
}
                        
                        
                        