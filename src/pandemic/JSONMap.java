package pandemic;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.*;

public class JSONMap extends Map{
           
    protected String fileName;
    
    
    /**
     * Create JSONMap object
     * @param fileName name of the JSON file
     * @param numberOfDiseases number of diseases on the map
     * @param cubesPerDisease number of cubes for each disease 
     */
    public JSONMap(String fileName, int numberOfDiseases, int cubesPerDisease){ 
        super();
        this.fileName = fileName;
        for ( int i =0 ; i < numberOfDiseases; i++ ){
            Disease d = new Disease(i, cubesPerDisease); // creation des maladies
            this.diseaseList.add(d); // ajout des maladies dans l'attribut de la map
        }
    }

    /**
     * Parser that uses the JSON data to construct City and disease objects 
     */
    public void parseJSON(){
        // Parcour de data de cities ( boucle for )
        // Construction d'une ville avec le constructeur de city en param les infos récupérées pendant le parcour )
        // new hashmap   // hashmap vide où on associe le nome de la ville ( String ) à la ville ( objet )
        // for ( element in cities data )  {
        //        c = new City(name , secteur)
        //        hashmap.add ( rajouter name : c ( object))
        //        }
        // une fois les objects construits, parcour sur data de neighbors 
        // for ( ville in neighbors data){
        //        utiliser get dans la hashmap créee pour trouver liste de voisins correspondants
        //              for (element in liste de voisins ){ 
        //                  city.addneighbor(element)
        //}
        // }
        // 
         try {
        // Parcour des données de cities :
        FileReader reader = new FileReader(this.fileName); // ouverture du fichier 
        JSONObject data = new JSONObject(new JSONTokener(reader)); // lit le contenu du fichier et le parse
        JSONObject cities = (JSONObject) data.get("cities"); // récuperer la partie cities du JSON
        HashMap<String, City> cityMap = new HashMap<String, City>(); // creation d'une hashmap vide  
        for (String cityname : cities.keySet()) {
            int secteurId = cities.getInt(cityname); // récuperer le secteur
            Disease d = this.diseaseList.get(secteurId); // récuperer maladie
            City c = new City(cityname, d); // construction des objets ville
            cityMap.put(cityname, c); // ajout de l'objet city à la hashmap
        }

        JSONObject neighbors = (JSONObject) data.get("neighbors"); // récuperer la partie neighbors du JSON
        for (String cityname : neighbors.keySet()){
            JSONArray nList = neighbors.getJSONArray(cityname); // récuperer la liste de voisins
            City c = cityMap.get(cityname);    
            for (Object name : nList){
                String n = (String) name;
                City neighboringCity  = cityMap.get(n); // récuperer la ville voisine
                c.addneightbor(neighboringCity);
            }
            this.cities.add(c);
        }


        }catch(FileNotFoundException e){
            System.err.println("File not found");
        } 
    }

}