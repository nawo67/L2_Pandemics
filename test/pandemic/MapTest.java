package pandemic;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import pandemic.*;

public abstract class MapTest {
    protected Map m;

    @Test
    public void cubesPlacedTest(){
        Disease d = new Disease(0, 2);
        City c = new City("cityA", d);
        City c2 = new City("CityB", d);
        c.infect(2);
        c2.infect(1);
        m.cities.add(c2);
        assertTrue(m.cubesPlaced()== 1);
        m.cities.add(c);
        assertTrue(m.cubesPlaced()==3);
    }

    @Test
    public void numberFocusesOfInfectionTest(){
        Disease d = new Disease(0, 2);
        City c = new City("cityA", d);
        City c2 = new City("CityB", d);
        c.infect(3);
        c2.infect(1);
        m.cities.add(c2);
        m.cities.add(c);
        assertTrue(m.numberFocusesOfInfection()==1);
        c2.infect(2);
        assertTrue(m.numberFocusesOfInfection()==2);
    }

    @Test
    public void researchLabsOnTheMapTest(){
        Disease d = new Disease(0, 2);
        City c = new City("cityA", d);
        City c2 = new City("CityB", d);
        assertTrue(m.researchLabsOnTheMap() == 0);
        m.cities.add(c);
        m.cities.add(c2);
        c.placeResearchLab();
        assertTrue(m.researchLabsOnTheMap()==1);
        c2.placeResearchLab();
        assertTrue(m.researchLabsOnTheMap()==2);
        c2.removeResearchLab();
        assertTrue(m.researchLabsOnTheMap()==1);
        c.removeResearchLab();
        assertTrue(m.researchLabsOnTheMap()==0);



    }
}
