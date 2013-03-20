package conan.cook;

import java.util.Comparator;

public class JournalComparator implements Comparator<Journal> {

    private int year;

    public JournalComparator(int year) {
        this.year = year;
    }

    @Override
    public int compare(Journal journal1, Journal journal2) {
        if (journal1 == journal2) {
            return 0;
        }
        // Reverse the ordering as we want to order from highest to lowest
        int result = journal2.getScore(year).compareTo(journal1.getScore(year));

        // If scores are the same, rank alphabetically by name
        if (result == 0) {
            result = journal1.getName().compareTo(journal2.getName());
        }

        return result;
    }
}
