import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Jane",  "young", "healthy",2);
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Jane() {
        Animal testAnimal = new Animal("Jane",  "young", "healthy",2);
        assertEquals("Jane", testAnimal.getName());
    }

    @Test
    public void getAge_animalInstantiatesWithAge_healthy() {
        Animal testAnimal = new Animal("Jane",  "young", "healthy",2);
        assertEquals("healthy", testAnimal.getAge());
    }

    @Test
    public void getHealth_animalInstantiatesWithHealth_young() {
        Animal testAnimal = new Animal("Jane",  "young", "healthy",2);
        assertEquals("young", testAnimal.getHealth());
    }

    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal testAnimal = new Animal("Jane", "young", "healthy", 2);
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Jane", "young", "healthy", 2);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Henry", "adult", "ill", 3);
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Jane", "young", "healthy", 2);
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Jane",  "young", "healthy",2);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Henry", "adult", "ill", 3);
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

}
