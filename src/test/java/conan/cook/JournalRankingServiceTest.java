package conan.cook;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JournalRankingServiceTest {

    Journal a, b, c;
    List<Journal> journals;
    private JournalRankingService rankingService = new JournalRankingService();
    private List<List<Journal>> expected;

    @Before
    public void setUp() {
        journals = new ArrayList<>();

        a = new Journal("Journal A");
        a.getScores().put(2010, 5.6d);
        a.getScores().put(2009, 2.2d);
        a.getScores().put(2008, 5.6d);
        journals.add(a);

        b = new Journal("Journal B");
        b.getScores().put(2010, 2.4d);
        b.getScores().put(2009, 6.2d);
        b.getScores().put(2008, 2.4d);
        journals.add(b);

        c = new Journal("Journal C");
        c.getScores().put(2010, 3.1d);
        c.getScores().put(2009, 6.2d);
        c.getScores().put(2008, 3.1d);
        journals.add(c);

        expected = new ArrayList<>();
        for(int i=0; i<3; i++) {
            expected.add(new ArrayList<Journal>());
        }
    }

    @Test
    public void testScenario1() {
        int year = 2010;

        expected.get(0).add(a);
        expected.get(1).add(c);
        expected.get(2).add(b);

        List<List<Journal>> rankedJournals = rankingService.rankJournals(journals, year);

        assertEquals("Incorrectly ranked journals", expected, rankedJournals);

        // Print output
        System.out.println("\nScenario 1:\n");
        for (int i = 0; i < rankedJournals.size(); i++) {
            List<Journal> currentRankJournals = rankedJournals.get(i);
            for (Journal journal : currentRankJournals) {
                System.out.println((i + 1) + " " + journal.getName() + " " + journal.getScore(year));
            }
        }
    }

    @Test
    public void testScenario2() {
        int year = 2009;

        expected.get(0).add(b);
        expected.get(0).add(c);
        expected.get(2).add(a);

        List<List<Journal>> rankedJournals = rankingService.rankJournals(journals, year);

        assertEquals("Incorrectly ranked journals", expected, rankedJournals);

        // Print output
        System.out.println("\nScenario 2:\n");
        for (int i = 0; i < rankedJournals.size(); i++) {
            List<Journal> currentRankJournals = rankedJournals.get(i);
            for (Journal journal : currentRankJournals) {
                System.out.println((i + 1) + " " + journal.getName() + " " + journal.getScore(year));
            }
        }
    }

    @Test
    public void testScenario3() {
        int year = 2008;
        a.setReview(true);

        expected.get(0).add(c);
        expected.get(1).add(b);
        expected.remove(2);

        List<List<Journal>> rankedJournals = rankingService.rankJournals(journals, year);

        assertEquals("Incorrectly ranked journals", expected, rankedJournals);

        // Print output
        System.out.println("\nScenario 3:\n");
        for (int i = 0; i < rankedJournals.size(); i++) {
            List<Journal> currentRankJournals = rankedJournals.get(i);
            for (Journal journal : currentRankJournals) {
                System.out.println((i + 1) + " " + journal.getName() + " " + journal.getScore(year));
            }
        }

    }
}
