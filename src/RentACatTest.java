import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class RentACatTest {

    // Re-usable Driver reference.
    Location _l;
    Driver _d;

    // Create a new LaboonCoin instance before each test.
    @Before
    public void setup() {
        _l = mock(Location.class);
        _d = new Driver(_l);
    }

    // Assert that creating a new Driver instance
    // does not return a null reference
    @Test
    public void testDriverExists() {
        assertNotNull(_d);
    }

    // ensure consutrctor location is set correctly
    @Test
    public void testLocation() {
        assertEquals(_d.curr_loc, _l);
    }

    // Test driver.move(road). move should set the current road's
    // destination to the current location.
    @Test
    public void testMove() {
        Location next_loc = mock(Location.class);
        Road _r = mock(Road.class);
        when(_r.getTo()).thenReturn(next_loc);

        _d.move(_r);
        assertEquals(_d.curr_loc, next_loc);
    }

    // test random move. Random move should randomly select a road
    // using location.get_rand_road(), then move along that road using
    // driver.move(road)
    @Test
    public void testRandomMove() {
        Road _r = mock(Road.class);

        Location mockLoc = mock(Location.class);
        when(mockLoc.get_rand_road()).thenReturn(_r);

        // can't mock, must subclass to stub method; this is the class under test.
        Driver mockDriver = new Driver(mockLoc) {
            public String move(Road road) {
                return "moved";
            }
        };
        
        assertEquals(mockDriver.random_move(), "moved");
    }

}
