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

    // // Assert that creating a new Driver instance
    // // does not return a null reference
    // @Test
    // public void testDriverExists() {
    //     assertNotNull(_d);
    // }

    // // ensure consutrctor location is set correctly
    // @Test
    // public void testLocation() {
    //     assertEquals(_d.curr_loc, _l);
    // }

    // // Test driver.move(road). move should set the current road's
    // // destination to the current location.
    // @Test
    // public void testMove() {
    //     Location next_loc = mock(Location.class);
    //     Road _r = mock(Road.class);
    //     when(_r.getTo()).thenReturn(next_loc);

    //     _d.move(_r);
    //     assertEquals(_d.curr_loc, next_loc);
    // }

    // // test random move. Random move should randomly select a road
    // // using location.get_rand_road(), then move along that road using
    // // driver.move(road)
    // @Test
    // public void testRandomMove() {
    //     Road _r = mock(Road.class);

    //     Location mockLoc = mock(Location.class);
    //     when(mockLoc.get_rand_road()).thenReturn(_r);

    //     // can't mock, must subclass to stub method; this is the class under test.
    //     Driver mockDriver = new Driver(mockLoc) {
    //         public String move(Road road) {
    //             return "moved";
    //         }
    //     };
        
    //     assertEquals(mockDriver.random_move(), "moved");
    // }

    // TODO comments
    @Test
    public void testReturnCat() {

    }

    // TODO comments
    @Test
    public void testRentCat() {

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
