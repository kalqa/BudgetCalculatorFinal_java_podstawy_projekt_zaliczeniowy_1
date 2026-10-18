package pl.javaready.projects;

// Przechowuje wszystkie oceny i liczy wszystko, co ich dotyczy -
// srednia dla danego dania, liste ocen jednego dania, liste unikalnych
// dan. RatingBook nic nie wypisuje na ekran (to robota RatingPrinter) -
// tylko trzyma dane i liczy. Dwa razy wpisane "to samo" danie (ta sama
// nazwa + ta sama restauracja) to DWA RÓŻNE obiekty Dish w pamięci,
// ale .equals() mowi, ze to jedno danie - stad grupowanie przez petle +
// equals(), a nie przez porownywanie referencji.
public class RatingBook {

    private static final int MAX_RATINGS = 200;

    private final Rating[] ratings;
    private int ratingsCount;

    public RatingBook() {
        this.ratings = new Rating[MAX_RATINGS];
        this.ratingsCount = 0;
    }

    public boolean addRating(Rating rating) {
        if (isFull()) {
            System.out.println("Błąd: książka ocen jest pełna.");
            return false;
        }
        ratings[ratingsCount] = rating;
        ratingsCount++;
        return true;
    }

    public Rating[] getRatings() {
        return ratings;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public double averageScoreFor(Dish dish) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < ratingsCount; i++) {
            if (ratings[i].getDish().equals(dish)) {
                sum += ratings[i].getScore();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }

    public int ratingsCountFor(Dish dish) {
        int count = 0;
        for (int i = 0; i < ratingsCount; i++) {
            if (ratings[i].getDish().equals(dish)) {
                count++;
            }
        }
        return count;
    }

    // Kazde danie raz, nawet jesli ma 5 ocen w tablicy ratings.
    public Dish[] distinctDishes() {
        Dish[] result = new Dish[ratingsCount];
        int distinctCount = 0;
        for (int i = 0; i < ratingsCount; i++) {
            Dish candidate = ratings[i].getDish();
            if (!this.containsDish(result, distinctCount, candidate)) {
                result[distinctCount] = candidate;
                distinctCount++;
            }
        }
        return this.trimToSize(result, distinctCount);
    }

    private boolean containsDish(Dish[] dishes, int count, Dish candidate) {
        for (int i = 0; i < count; i++) {
            if (dishes[i].equals(candidate)) {
                return true;
            }
        }
        return false;
    }

    private Dish[] trimToSize(Dish[] dishes, int size) {
        Dish[] trimmed = new Dish[size];
        for (int i = 0; i < size; i++) {
            trimmed[i] = dishes[i];
        }
        return trimmed;
    }

    private boolean isFull() {
        return ratingsCount >= ratings.length;
    }
}
