package pandemic;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import pandemic.*;

public class DiseaseTest {
    @Test
    public void IncreaseDecreaseNumberOfCubesTest(){
        Disease d = new Disease(2, 5);
        d.increaseNumberOfCubes();
        assertTrue(d.getNumberOfCubes() == 6);
        d.decreaseNumberOfCubes();
        assertTrue(d.getNumberOfCubes() == 5);
    }
    
}
