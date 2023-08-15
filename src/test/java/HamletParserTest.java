import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        setUp();
        boolean expected = true;
        boolean actual;

        String finalString = hamletParser.calculateFinalString(hamletText);
        if (finalString.contains("Hamlet")){
            actual = false;
        } else {
            actual = true;
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        setUp();
        boolean expected = true;
        boolean actual;

        String finalString = hamletParser.calculateFinalString(hamletText);
        if (finalString.contains("Horatio")){
            actual = false;
        } else {
            actual = true;
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}