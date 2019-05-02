import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class sightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void monster_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting("isaac", "Zone A", 1, 1);
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void Monster_instantiatesWithrangerName_String() {
        Sighting testSighting = new Sighting("isaac", "Zone A", 1, 1);
        assertEquals("isaac", testSighting.getRangerName());
    }

    @Test
    public void Monster_instantiatesWithLocation_String() {
        Sighting testSighting = new Sighting("isaac", "Zone A", 1, 1);
        assertEquals("Zone A", testSighting.getLocation());
    }


}