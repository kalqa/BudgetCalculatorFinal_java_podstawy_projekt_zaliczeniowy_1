package pl.javaready.projects;

public class ZagadkaStringITablica {

    public static void main(String[] args) {
        System.out.println("## Zagadka 4: a co ze Stringiem i tablica?");

        String s = "Ala";
        int[] numbers = {1, 2, 3};

        // Pytanie: w mapie powyzej nie ma Stringa - bo String NIGDY nie byl
        // prymitywem, od razu byl klasa (obiektem). Tablica tez - mimo ze nie
        // widac tu slowa "new", kazda tablica w Javie to tez obiekt.
        System.out.println("s instanceof Object:       " + (s instanceof Object));
        System.out.println("numbers instanceof Object: " + (numbers instanceof Object));
        System.out.println("s.getClass():              " + s.getClass());
        System.out.println("numbers.getClass():        " + numbers.getClass());
        // ^ "[I" wyglada dziwnie, ale to tylko wewnetrzna nazwa Javy dla
        // "tablicy intow" - wazne, ze to w ogole JEST jakas klasa (obiekt).

        // Dla porownania: ponizsze NIE skompilowaloby sie, bo "a" to prymityw,
        // a prymitywy nie maja zadnych metod (nie sa obiektami):
        // int a = 5;
        // a.getClass(); // <- BLAD KOMPILACJI
    }
}
