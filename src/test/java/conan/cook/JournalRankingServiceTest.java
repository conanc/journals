package conan.cook;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JournalRankingServiceTest {

    List<Journal> journals;
    private JournalRankingService rankingService = new JournalRankingService();

    @Before
    public void setUp() {
        journals = new ArrayList<>();

        Journal a = new Journal("Journal A");
        a.getScores().put(2010, 5.6d);
        a.getScores().put(2009, 2.2d);
        a.getScores().put(2008, 5.6d);
        journals.add(a);

        Journal b = new Journal("Journal B");
        b.getScores().put(2010, 2.4d);
        b.getScores().put(2009, 6.2d);
        b.getScores().put(2008, 2.4d);
        journals.add(b);

        Journal c = new Journal("Journal C");
        c.getScores().put(2010, 3.1d);
        c.getScores().put(2009, 6.2d);
        c.getScores().put(2008, 3.1d);
        journals.add(c);
    }

    @Test
    public void testScenario1() {
        int year = 2010;

    }

    @Test
    public void testScenario2() {
        int year = 2009;

    }

    @Test
    public void testScenario3() {
        int year = 2008;

    }
}
