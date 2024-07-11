package pandemic.Cards;

import pandemic.City;
import pandemic.Disease;

public class PlayerCard extends Card{
    private City city;
    private Disease disease;

    /**
     * create a playercard object
     * @param city the city of the card
     * @param disease the disease of the card
     */
    public PlayerCard(City city, Disease disease){
        super();
        this.city = city;
        this.disease = disease;
    }

    /**
    * get the city of the card
    * @return the city of the card
    */
    public City getCity(){
        return this.city;
    }

    /**
    * get the disease of the card
    * @return the disease of the card
    */
    public Disease getDisease(){
        return this.disease;
    }

    /**
     * String representation of the playercard
     * @return Representation of the playercard
     */
    public String toString(){
        return "this infection card has to do with " + this.city.toString() + " and " +this.disease.toString();}
    
    /** equals method
     * @return boolean indicating if two player cards are equals
     */
    public boolean equals(Object o){
        if (!(o instanceof PlayerCard)){
            return false;
        }
        else{
            PlayerCard pc = (PlayerCard) o;
            return ((this.city.equals(pc.getCity())) && (this.disease.equals(pc.getDisease())));
                
            
        }
    }
    
}
