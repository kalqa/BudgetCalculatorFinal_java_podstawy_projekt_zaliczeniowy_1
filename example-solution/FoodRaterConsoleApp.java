package pl.javaready.projects;

// Steruje przeplywem: prowadzi menu w petli, czyta dane przez
// ConsoleInput, zleca liczenie RatingBook, zleca wypisywanie
// RatingPrinter. book MOZE byc final - w odroznieniu od zadania
// Budget Analyzer, tutaj nie ma fazy "zbierania danych na starcie",
// wiec obiekt powstaje od razu w konstruktorze.
public class FoodRaterConsoleApp {

    private final ConsoleInput input;
    private final RatingPrinter printer;
    private final RatingBook book;

    public FoodRaterConsoleApp(ConsoleInput input, RatingPrinter printer) {
        this.input = input;
        this.printer = printer;
        this.book = new RatingBook();
    }

    public void run() {
        boolean running = true;

        while (running) {
            printer.printMenu();
            String choice = input.readLine();

            if (choice.equals("1")) {
                handleAddRating();
            } else if (choice.equals("2")) {
                printer.printAllRatings(book);
            } else if (choice.equals("3")) {
                printer.printRanking(book);
            } else if (choice.equals("4")) {
                running = false;
                System.out.println("Do zobaczenia!");
            } else {
                System.out.println("Nieznana opcja.");
            }
        }

        input.close();
    }

    private void handleAddRating() {
        System.out.println();
        System.out.println("Nazwa restauracji:");
        String restaurantName = input.readLine();

        System.out.println("Miasto:");
        String city = input.readLine();
        Restaurant restaurant = new Restaurant(restaurantName, city);

        System.out.println("Nazwa dania:");
        String dishName = input.readLine();

        System.out.println("Cena (PLN):");
        double price = input.readDouble();
        Dish dish = new Dish(dishName, price, restaurant);

        int score = gatherValidScore();

        System.out.println("Komentarz:");
        String comment = input.readLine();

        book.addRating(new Rating(dish, score, comment));
        System.out.println("Dodano ocenę!");
    }

    private int gatherValidScore() {
        System.out.println("Ocena (1-10):");
        int score = input.readNumber();
        while (!Rating.isValidScore(score)) {
            System.out.println("Ocena musi być w zakresie 1-10. Spróbuj ponownie:");
            score = input.readNumber();
        }
        return score;
    }
}
