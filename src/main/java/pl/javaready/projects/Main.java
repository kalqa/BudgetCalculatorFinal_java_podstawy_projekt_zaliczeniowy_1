package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        zagadka1_intKontraInteger();
        System.out.println();
        zagadka2_dwaTakieSameObiekty();
        System.out.println();
        mapaTypow();
        System.out.println();
        zagadka3_stringITablica();
        System.out.println();
        moral();
    }

    // ─── ZAGADKA 1: int kontra Integer ───────────────────────────────────────
    private static void zagadka1_intKontraInteger() {
        System.out.println("## Zagadka 1: int kontra Integer");

        int a = 1000;
        int b = 1000;
        System.out.println("int:     a == b          -> " + (a == b));

        Integer x = 1000;
        Integer y = 1000;
        System.out.println("Integer: x == y          -> " + (x == y));
        System.out.println("Integer: x.equals(y)     -> " + x.equals(y));

        // Pytanie: to te same liczby, ten sam operator (==), a wyniki sa
        // inne. Dlaczego int i Integer zachowuja sie tutaj inaczej?
    }

    // ─── ZAGADKA 2: dwa obiekty z identycznymi danymi w srodku ──────────────
    private static void zagadka2_dwaTakieSameObiekty() {
        System.out.println("## Zagadka 2: User != User?");

        User user1 = new User("Ala");
        User user2 = new User("Ala");

        System.out.println("user1 == user2:        " + (user1 == user2));
        System.out.println("user1.equals(user2):   " + user1.equals(user2));

        // Pytanie: oba obiekty maja w srodku dokladnie to samo imie "Ala".
        // Dlaczego Java i tak mowi, ze to NIE to samo?
    }

    // ─── MAPA: kazdy prymityw ma swojego "obiektowego brata" ────────────────
    private static void mapaTypow() {
        System.out.println("## Mapa: prymityw -> jego klasa opakowujaca (wrapper)");
        System.out.println("int     -> Integer");
        System.out.println("long    -> Long");
        System.out.println("double  -> Double");
        System.out.println("float   -> Float");
        System.out.println("boolean -> Boolean");
        System.out.println("char    -> Character");
        System.out.println("byte    -> Byte");
        System.out.println("short   -> Short");
    }

    // ─── ZAGADKA 3: a co ze Stringiem i tablica? ─────────────────────────────
    private static void zagadka3_stringITablica() {
        System.out.println("## Zagadka 3: a co ze Stringiem i tablica?");

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

    private static void moral() {
        System.out.println("## Zasada, ktora juz teraz mozecie zapamietac:");
        System.out.println("Dla OBIEKTOW zawsze uzywamy .equals() - nigdy ==.");
        System.out.println("Dlaczego tak jest - o tym na kolejnej lekcji (model pamieci).");
    }
}
