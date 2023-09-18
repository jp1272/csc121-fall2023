import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FamTreeTests {

    IFamTree bart = new Person("Bart",
            new Person("Marge", new Unknown(), new Unknown()),
            new Person("Homer",
                new Unknown(),
                new Person("Abe", new Unknown(), new Unknown())));

    IFamTree bart2 = new Person("Bart",
            new Person("Marge"), new Person("Homer",
                                        new Unknown(),
                                        new Person("Abe")));

    // for class; draw an object diagram:
    IFamTree unk = new Unknown();
    IFamTree mlkjr = new Person(
                "Martin",
                new Person("Alberta",
                           new Person("Jenny"),
                           new Person("Adam", unk, unk)),
                new Person("Martin",
                           new Person("Delia",
                                      unk,
                                      new Person("Jim")),
                           new Person("James", unk, unk)));


    @Test
    public void testCountName() {
        assertEquals(1 , new Person("Bart").countName("Bart"));
        assertEquals(0 , new Person("Abe").countName("Bart"));
        assertEquals(0 , new Unknown().countName("Bart"));
        assertEquals(1, bart.countName("Abe"));
        assertEquals(0, bart.countName("Lucy"));
        assertEquals(2, new Person("Homer", new Unknown(), bart2).countName("Homer"));
    }
}
