package pl.javaready.projects;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // String to "obca" klasa - napisana przez tworcow Javy
        Greeter greeter = new Greeter("Ala");
        System.out.println(greeter.greet());

        // Person to "nasza" klasa - napisana przez nas w tym projekcie
        Person person = new Person("Bartek", 21);

        // toString() - String ma je "od razu", w Person napisalismy je sami
        System.out.println(person);          // Bartek (21 lat)
        System.out.println("Ala".toString()); // Ala

        // Scanner to kolejna "obca" klasa, tym razem z pakietu java.util
        Scanner scanner = new Scanner(System.in);

        // PersonRegistration przyjmuje w konstruktorze i obca klase (Scanner),
        // i nasza klase (Person) - w ten sam sposob
        PersonRegistration registration = new PersonRegistration(scanner, person);
        registration.printSummary();

        String city = registration.askForCity();
        System.out.println("Miasto: " + city);

        int favoriteNumber = registration.askForFavoriteNumber();
        System.out.println("Ulubiona liczba: " + favoriteNumber);

        scanner.close();
    }
}
