package conan.cook;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;

public class JournalComparatorTest {

    private JournalComparator comparator;
    private int year = 2013;
    private Journal journal1, journal2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        comparator = new JournalComparator(year);
        journal1 = new Journal("Journal 1");
        journal2 = new Journal("Journal 2");
    }

    @Test
    public void testFirstHigher() {
        journal1.getScores().put(year, 2d);
        journal2.getScores().put(year, 1d);
        int result = comparator.compare(journal1, journal2);
        assertEquals("First journal should be higher", -1, result);
    }

    @Test
    public void testFirstLower() {
        journal1.getScores().put(year, 1d);
        journal2.getScores().put(year, 2d);
        int result = comparator.compare(journal1, journal2);
        assertEquals("First journal should be lower", 1, result);
    }

    @Test
    public void testEqual() {
        journal1.getScores().put(year, 1d);
        journal1.setName("Z");
        journal2.getScores().put(year, 1d);
        journal2.setName("A");
        int result = comparator.compare(journal1, journal2);
        assertEquals("Journals should be alphabetically ordered", 25, result);

        result = comparator.compare(journal1, journal1);
        assertEquals("Journals should be equal", 0, result);
    }

    @Test
    public void testNullJournal1() {
        thrown.expect(NullPointerException.class);
        journal2.getScores().put(year, 1d);
        comparator.compare(null, journal2);
    }

    @Test
    public void testNullJournal2() {
        thrown.expect(NullPointerException.class);
        journal1.getScores().put(year, 1d);
        comparator.compare(journal1, null);
    }

    @Test
    public void testNullScore1() {
        thrown.expect(NullPointerException.class);
        journal1.getScores().put(year, null);
        journal2.getScores().put(year, 1d);
        comparator.compare(journal1, journal2);
    }

    @Test
    public void testNullScore2() {
        thrown.expect(NullPointerException.class);
        journal1.getScores().put(year, 1d);
        journal2.getScores().put(year, null);
        comparator.compare(journal1, journal2);
    }
}
