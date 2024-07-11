package pandemic;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import pandemic.*;

public class JSONMapTest extends MapTest {
    
    @Before
    public void init() {
        JSONMap jm = new JSONMap("data/map4test.json", 2, 1);
        jm.parseJSON();
        m = (Map)jm;
    }

    @Test
    public void JSONparseTest(){
        City c0 = m.getCities().get(0);
        City c1 = m.getCities().get(1);
        assertEquals(c0.getName(), "ville-1");
        assertEquals(c1.getName(), "ville-2");
        assertEquals(c0.getDisease().getId(), 0);
        assertEquals(c1.getDisease().getId(), 1);   
    }
    
}
