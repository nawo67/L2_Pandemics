package pandemic;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;

/**
 * Represent a map object
 */
public abstract class Map {
  protected List<City> cities;
  protected List<Disease> diseaseList; // go from ID to disease using diseaseList.get(secteurId)

  /**
   * Create a Map object
   */ 
  public Map() {
    this.cities = new ArrayList<City>();
    this.diseaseList = new ArrayList<Disease>();
  }

  /**
   * Number of cubes placed on the map
   * @return Number of cubes placed on the map
   */
  public int cubesPlaced(){
    int counter = 0;
    for (City c: this.cities){
        counter += c.getCubes();      
    }

    return counter;
  }

  /**
   * Number of focuses of infection on the map
   * @return Number of focuses of infection on the map
   */
  public int numberFocusesOfInfection(){
    int counter = 0;
    for ( City c: this.cities){
      if (c.getIsFocusOfInfection() ){
        counter += 1;
      }
    }
    return counter;
  }

  /**
   * Number of research labs on the map
   * @return Number of research labs on the map
   */
  public int researchLabsOnTheMap(){
    int counter = 0;
    for (City c: this.cities){
        if (c.hasLab()){
          counter += 1;
        }
      }
      return counter;
    }

    /**
     * get Cities on the map
     * @return Cities on the map
     */
    public List<City> getCities() {
        return this.cities;
    }

    /**
     * get list of diseases on the map
     * @return list of diseases on the map
     */
    public List<Disease> getDiseaseList() {
        return this.diseaseList;
    }


    /**
     * String representation of the map
     * @return representation of the map
     */
    public String toString(){
      String s = "";
      for (City city : this.cities){
        s += city + "\n";
      }

      return s;
    }

    
  }
  
