import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class RentACatTest {

    // Re-usable Cat reference.
    RentACat _rac;

    // Create a new LaboonCoin instance before each test.
    @Before
    public void setup() {
        _rac = new RentACat();
    }

    // Test RentACat.returnCat(cat c)
    // Test will check and see that when passed a rented cat the method will return true 
    @Test
    public void testReturnCat_000() {
        Cat theCat = mock(Cat.class);
        when(theCat.getRented()).thenReturn(true);

        assertTrue(_rac.returnCat(theCat)));
    }

    // Test RentACat.returnCat(cat c)
    // Test will check and see that when passed a unrented cat the method will return true 
    @Test
    public void testRentCat_000() {
        Cat theCat = mock(Cat.class);
        when(theCat.getRented()).thenReturn(false);

        assertTrue(_rac.rentCat(theCat));
    }
    
    // Test RentACat.returnCat(cat c)
    // Test will check and see that when passed a rented cat the method will return false
    @Test
    public void testRentCat_001() {
        Cat theCat = mock(Cat.class);
        when(theCat.getRented()).thenReturn(true);

        assertFalse(_rac.rentCat(theCat));
    }

    // TODO comments
    @Test
    public void testListCats_000() {
        ArrayList<Cat> catList = new ArrayList<Cat>();

        Cat mockCat = mock(Cat.class);
        when(mockCat.getRented()).thenReturn(false);
        when(mockCat.toString()).thenReturn("1");
        catList.add(mockCat);

        mockCat = mock(Cat.class);
        when(mockCat.getRented()).thenReturn(true);
        catList.add(mockCat);

        String ret = "1\n";
        assertEquals(_rac.listCats(catList), ret);
    }

    // Test catExists when no cats are inthe arraylist.
    // Expected to return false
    @Test
    public void testCatExists_000() {
        ArrayList<Cat> catList = new ArrayList<Cat>();
        assertFalse(_rac.catExists(0, catList));
    }

    // Test catExists when the cat id isn't in the arraylist
    @Test
    public void testCatExists_001() {
        ArrayList<Cat> catList = new ArrayList<Cat>();

        Cat mockCat = mock(Cat.class);
        when(mockCat.getId()).thenReturn(1);
        catList.add(mockCat);

        mockCat = mock(Cat.class);
        when(mockCat.getId()).thenReturn(2);
        catList.add(mockCat);

        assertFalse(_rac.catExists(0, catList));
    }

    // Test catExists when the cat id is in the arraylist
    @Test
    public void testCatExists_002() {
        ArrayList<Cat> catList = new ArrayList<Cat>();

        Cat mockCat = mock(Cat.class);
        when(mockCat.getId()).thenReturn(1);
        catList.add(mockCat);

        mockCat = mock(Cat.class);
        when(mockCat.getId()).thenReturn(0);
        catList.add(mockCat);

        assertTrue(_rac.catExists(0, catList));
    }
}
