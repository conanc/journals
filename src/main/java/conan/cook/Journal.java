package conan.cook;

import java.util.HashMap;
import java.util.Map;

public class Journal {

    private String name;
    private Map<Integer, Double> scores = new HashMap<>();
    private boolean isReview = false;

    public Journal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Double> getScores() {
        return scores;
    }

    public Double getScore(int year) {
        return scores.get(year);
    }

    public boolean isReview() {
        return isReview;
    }

    public void setReview(boolean review) {
        isReview = review;
    }

    @Override
    public String toString() {
        return "Journal{name='" + name + "', scores=" + scores + ", isReview=" + isReview + "}";
    }
}
