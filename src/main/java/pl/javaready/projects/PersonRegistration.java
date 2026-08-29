package pl.javaready.projects;

import java.util.Scanner;

// PersonRegistration przyjmuje w konstruktorze DWIE klasy naraz:
//   - Scanner - napisana przez tworcow Javy (pakiet java.util)
//   - Person  - napisana przez NAS (Person.java, ten sam projekt)
//
// Dla kompilatora nie ma miedzy nimi ZADNEJ roznicy. Klasa to klasa,
// nie wazne kto ja napisal - obie sa uzyte jako typ parametru
// dokladnie w ten sam sposob.
public class PersonRegistration {

    private final Scanner scanner;
    private final Person person;

    public PersonRegistration(Scanner scanner, Person person) {
        this.scanner = scanner;
        this.person = person;
    }

    public void printSummary() {
        System.out.println(person + " zarejestrowany/a.");
    }

    public String askForCity() {
        System.out.println("Podaj miasto dla " + person.getName() + ":");
        // nextLine() to gotowa metoda Scannera - nie musimy sami pisac
        // kodu, ktory czyta znaki z klawiatury az do konca linii
        return scanner.nextLine();
    }

    public int askForFavoriteNumber() {
        System.out.println("Podaj ulubiona liczbe dla " + person.getName() + ":");
        // nextInt() to kolejna gotowa metoda Scannera - sama zamienia
        // wpisany tekst na liczbe, nie musimy tego robic recznie
        return scanner.nextInt();
    }
}
