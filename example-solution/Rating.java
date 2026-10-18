package pl.javaready.projects;

// Jedna ocena - danie + punkty (1-10) + komentarz. isValidScore() jest
// static, bo nie dotyczy zadnego konkretnego obiektu Rating - to czysta
// reguła klasy, sprawdzana ZANIM obiekt w ogole powstanie.
public class Rating {

    private static final int MIN_SCORE = 1;
    private static final int MAX_SCORE = 10;
    private static final int POSITIVE_THRESHOLD = 7;

    private final Dish dish;
    private final int score;
    private final String comment;

    public Rating(Dish dish, int score, String comment) {
        this.dish = dish;
        this.score = score;
        this.comment = comment;
    }

    public Dish getDish() {
        return dish;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public boolean isPositive() {
        return this.score >= POSITIVE_THRESHOLD;
    }

    public static boolean isValidScore(int score) {
        return score >= MIN_SCORE && score <= MAX_SCORE;
    }

    @Override
    public String toString() {
        return dish.getName() + ": " + score + "/10 - " + comment;
    }
}
