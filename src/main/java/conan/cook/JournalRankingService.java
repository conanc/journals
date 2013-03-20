package conan.cook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JournalRankingService {

    public List<List<Journal>> rankJournals(Collection<Journal> journals, int year) {
        // A list whose indices are ranks, and whose values are lists of journals of that rank
        List<List<Journal>> rankedJournals = new ArrayList<>(journals.size());

        // Duplicate input list
        List<Journal> sortedJournals = new ArrayList<>(journals.size());
        sortedJournals.addAll(journals);

        // Remove review journals
        for (Iterator<Journal> iterator = sortedJournals.iterator(); iterator.hasNext(); ) {
            if (iterator.next().isReview()) {
                iterator.remove();
            }
        }

        // Sort journals into descending score order based on specified year
        Collections.sort(sortedJournals, new JournalComparator(year));

        // Iterate over sorted list of journals, adding to appropriate rank
        Journal current;
        Journal previous = null;
        for (int i = 0; i < sortedJournals.size(); i++) {
            rankedJournals.add(i, new ArrayList<Journal>());
            current = sortedJournals.get(i);

            // If the score has not decreased, the rank does not increase
            if (previous != null && previous.getScore(year).equals(current.getScore(year))) {
                rankedJournals.get(sortedJournals.indexOf(previous)).add(current);
            } else {
                rankedJournals.get(i).add(current);
            }
            previous = current;
        }

        return rankedJournals;
    }
}
