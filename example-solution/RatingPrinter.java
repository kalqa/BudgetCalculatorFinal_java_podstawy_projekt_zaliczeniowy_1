package pl.javaready.projects;

// RatingPrinter ma JEDNA odpowiedzialnosc: wyswietlac na ekran. Nie wie,
// jak oceny sa przechowywane (to robota RatingBook) ani skad biora sie
// dane wejsciowe (to robota ConsoleInput).
public class RatingPrinter {

    public void printMenu() {
        System.out.println();
        System.out.println("=== FOODRATER ===");
        System.out.println("1. Dodaj ocenę");
        System.out.println("2. Pokaż wszystkie oceny");
        System.out.println("3. Ranking dań");
        System.out.println("4. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    public void printAllRatings(RatingBook book) {
        if (book.getRatingsCount() == 0) {
            System.out.println("Brak ocen.");
            return;
        }
        Rating[] ratings = book.getRatings();
        for (int i = 0; i < book.getRatingsCount(); i++) {
            System.out.println((i + 1) + ". " + ratings[i]);
        }
    }

    public void printRanking(RatingBook book) {
        Dish[] dishes = book.distinctDishes();
        if (dishes.length == 0) {
            System.out.println("Brak ocen.");
            return;
        }
        for (int i = 0; i < dishes.length; i++) {
            this.printDishLine(dishes[i], book);
        }
    }

    private void printDishLine(Dish dish, RatingBook book) {
        double average = book.averageScoreFor(dish);
        int count = book.ratingsCountFor(dish);
        String flag = "";
        if (average >= 8) {
            flag = " 🔥";
        }
        System.out.println("- " + dish + " | średnia: " + average + "/10 (" + count + " ocen)" + flag);
    }
}
