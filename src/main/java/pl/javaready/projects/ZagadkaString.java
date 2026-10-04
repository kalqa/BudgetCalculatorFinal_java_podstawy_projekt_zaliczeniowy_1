package pl.javaready.projects;

public class ZagadkaString {

    public static void main(String[] args) {
        System.out.println("## Zagadka 4: a co ze Stringiem?");

        String s = "Ala";

        // Pytanie: w mapie prymityw -> wrapper nie ma Stringa - bo String
        // NIGDY nie byl prymitywem, od razu byl klasa (obiektem).
        System.out.println("s instanceof Object: " + (s instanceof Object));
        System.out.println("s.getClass():        " + s.getClass());

        // Dla porownania: ponizsze NIE skompilowaloby sie, bo "a" to prymityw,
        // a prymitywy nie maja zadnych metod (nie sa obiektami):
        // int a = 5;
        // a.getClass(); // <- BLAD KOMPILACJI
    }
}
