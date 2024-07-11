package pandemic;
import java.util.*;
public class City {
    private List<City> neighbors; // attribute refering to neighboring cities
    private String name;
    private Disease disease;
    private boolean lab; // boolean indicating if the city has a research lab or not
    private int cubes; // int refering to the number of cubes on a city AKA the number of ill patients
    private boolean isFocusOfInfection; // boolean is set to true after three people in the city are infected 
    private boolean isStillInfectable; // boolean indicating if the city can still be infected 

    /**
     * Create City object
     * @param name City's name
     * @param disease disease that will infect it
     */
    public City(String name, Disease disease){
        this.name = name;
        this.disease = disease;
        this.neighbors = new ArrayList<City>();
        this.lab = false;
        this.cubes = 0;
        this.isStillInfectable = true;
        this.isFocusOfInfection = false;

    }

    /**
     * Get name of the city
     * @return name attribute
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns true if the city has a research lab
     * @return boolean indicating if the city has a research lab
     */
    public boolean hasLab(){
        return this.lab;
    }

    /**
     * Returns the City's neighbors
     * @return list of the city's neighbors
     */
    public List<City> getNeighbors(){
        return this.neighbors;
    }

    /**
     * Returns the number of cubes placed on the City aka the number of ill patients
     * @return int of the amount of ill patients yet to be treated
     */
    public int getCubes(){
        return this.cubes;
    }

    /**
     * Returns the disease corresponding to the city
     * @return disease the city suffers from
     */
    public Disease getDisease(){
        return this.disease;
    }

    /**
     * Indicates if the city is currently a focus of infection
     * @return
     */
    public boolean getIsFocusOfInfection(){
        return this.isFocusOfInfection;
    }

    /**
     * Indicates if the city is still infectable
     * @return boolean indicating if the city can still be infected
     */
    public boolean isStillInfectable() {
        return this.isStillInfectable;
    }

    /**
     * Cures one patient 
     */
    public void cure(){
        if ( this.cubes > 0){
            this.cubes = this.cubes - 1;
            this.disease.decreaseNumberOfCubes();
        }
    
        else{
            this.cubes = 0;
        }
    }

    /**
     * infects one patient
     */
    public void infect(int i){
        this.cubes += i;
        if (this.cubes >= 3){
            this.isFocusOfInfection = true;
            this.cubes = 3;
            this.infectNeighbors();
        }
        else{
            this.disease.decreaseNumberOfCubes();
        }
    }

    /**
     * Infects the city's neighbors if the city is a focus of infection
     */
    private void infectNeighbors(){
            for (City neighbor : this.neighbors){
                if(!neighbor.getIsFocusOfInfection()){
                    neighbor.infect(1);
                }
        }
    }


    /**
     * adds one city to the neighbors list
     * @param neighbor City to be added as a neighbor
     */
    public void addneightbor(City neighbor){
        this.neighbors.add(neighbor);
    }
    
    /**
     * Places a research lab on the city
     */
    public void placeResearchLab(){
        this.lab = true;
    }

    /**
     * Removes a research lab from the city
     */
    public void removeResearchLab(){
        this.lab = false;
    }

    /**
     * sets infectability status 
     * @param isStillInfectable boolean to which the infectability status will be set to
     */
    public void setInfectabilityStatus(boolean isStillInfectable){
        this.isStillInfectable = isStillInfectable;
    }

    
    /**
     * String representation of the City
     * @return String representation of the City
     */
    public String toString(){
        String s = " City : " + this.getName() + " neighbors : ";
        for (City neighbor : this.neighbors){
            s += " " + neighbor.getName() + " ";
        }

        return s;
    }

    /**
     * check if two objects are equal
     * @param object The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object object){
        if (!(object instanceof City)){
            return false;
        }

        else{
            City c = (City) object;
            return ( c.name.equals(this.name) && c.disease.equals(this.disease));
        }
    }



}
