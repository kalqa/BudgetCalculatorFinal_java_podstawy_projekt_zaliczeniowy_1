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
        this.seedExampleData();
    }

    // Dane startowe, zeby po uruchomieniu programu od razu bylo cos
    // do pokazania w rankingu - w tym dwa dania ocenione dwa razy,
    // zeby od razu bylo widac grupowanie przez equals().
    private void seedExampleData() {
        Restaurant daMarco = new Restaurant("Pizzeria Da Marco", "Kraków");
        Restaurant kebabKing = new Restaurant("Kebab King", "Warszawa");
        Restaurant sushiZen = new Restaurant("Sushi Zen", "Wrocław");
        Restaurant podKogutem = new Restaurant("Bar Mleczny Pod Kogutem", "Kraków");
        Restaurant bella = new Restaurant("Trattoria Bella", "Poznań");

        Dish margherita = new Dish("Pizza Margherita", 32.00, daMarco);
        Dish pepperoni = new Dish("Pizza Pepperoni", 34.00, daMarco);
        Dish kebab = new Dish("Kebab w bułce XL", 25.00, kebabKing);
        Dish falafel = new Dish("Falafel wrap", 22.00, kebabKing);
        Dish california = new Dish("Zestaw California 12szt", 48.00, sushiZen);
        Dish ramen = new Dish("Ramen Tonkotsu", 36.00, sushiZen);
        Dish pierogi = new Dish("Pierogi ruskie", 18.00, podKogutem);
        Dish carbonara = new Dish("Spaghetti Carbonara", 29.00, bella);

        book.addRating(new Rating(margherita, 9, "Ciasto idealne, dowóz szybki"));
        book.addRating(new Rating(margherita, 7, "Trochę mniej sera niż zwykle"));
        book.addRating(new Rating(kebab, 8, "Sos czosnkowy petarda"));
        book.addRating(new Rating(california, 10, "Najlepsze sushi w mieście"));
        book.addRating(new Rating(pierogi, 9, "Jak u babci"));
        book.addRating(new Rating(pierogi, 6, "Tym razem trochę przypalone"));
        book.addRating(new Rating(ramen, 8, "Bulion gęsty i rozgrzewający"));
        book.addRating(new Rating(falafel, 5, "Suchy, mało sosu"));
        book.addRating(new Rating(pepperoni, 9, "Ostro i konkretnie"));
        book.addRating(new Rating(carbonara, 7, "Smaczne, ale za słone"));
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
