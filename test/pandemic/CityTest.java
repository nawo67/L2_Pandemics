package pandemic;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import pandemic.*;

public class CityTest {
   private static Disease d = new Disease(0, 3);
   private static City c = new City("City1", d);

   @Test
   public void cureAndInfectMethodTest(){
      c.infect(2);
      assertTrue(c.getCubes()== 2);
      c.cure();
      assertTrue(c.getCubes()== 1);

   }

   @Test
   public void addneighborTest(){
      City n = new City("city2", d);
      ArrayList<City> neighbors = new ArrayList<City>();
      neighbors.add(n);

      c.addneightbor(n);
      assertEquals(c.getNeighbors(), neighbors);

   }

   @Test
   public void placeAndRemoveResearchLabTest(){
      assertEquals(c.hasLab(), false); // verifier que l'objet de base n'a pas de labo de recherche 
      c.placeResearchLab(); // ajouter un labo de recherche
      assertEquals(c.hasLab(), true); // verifier que le labo a bien été ajouté
      c.removeResearchLab(); // retirer le labo
      assertEquals(c.hasLab(), false); // Vverifier que la labo a bien été retirer

   }

   @Test
   public void setInfectabilityStatusTest(){
      assertEquals(c.isStillInfectable(), true);
      c.setInfectabilityStatus(false);
      assertEquals(c.isStillInfectable(), false);
      c.setInfectabilityStatus(true);
      assertEquals(c.isStillInfectable(), true);

   }

   @Test
   public void isFocusOfInfectionTest(){
      City n = new City("city2", d);
      City n2 = new City("CityB", d);
      n.addneightbor(n2);
      assertTrue(!n.getIsFocusOfInfection());
      n.infect(3);
      assertTrue(n.getIsFocusOfInfection());
      assertTrue(n2.getCubes() == 1);

   }


}


