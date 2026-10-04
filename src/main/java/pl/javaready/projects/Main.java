package pl.javaready.projects;

// Lekcja: obiekty a prymitywy - skad to sie wzielo i gdzie jest haczyk?
//
// Krotki rys historyczny: Java od samego poczatku ma prymitywy (int, boolean,
// double...) - to "zwykle wartosci". Ale Java jest jezykiem OBIEKTOWYM, wiec
// dla kazdego prymitywu istnieje tez jego "obiektowy odpowiednik" - klasa
// opakowujaca (int -> Integer, boolean -> Boolean...). Macie juz za soba
// klasy, obiekty i prymitywy osobno - dzis zobaczymy, co sie dzieje, gdy
// trzeba je ze soba pogodzic.
//
// Zanim wytlumaczymy DLACZEGO tak sie dzieje (to temat na kolejna lekcje
// o modelu pamieci), zobaczmy NAJPIERW, jak to potrafi nas zaskoczyc.
// Przy kazdej zagadce zatrzymajcie sie na pytaniu w komentarzu.
public class Main {

    public static void main(String[] args) {
        zagadka1_dwaTakieSameObiekty();
        System.out.println();
        zagadka2_intKontraInteger();
        System.out.println();
        zagadka3_malaLiczbaKontraDuza();
        System.out.println();
        moral();
    }

    // ─── ZAGADKA 1: dwa obiekty z identycznymi danymi w srodku ──────────────
    private static void zagadka1_dwaTakieSameObiekty() {
        System.out.println("## Zagadka 1: User != User?");

        User user1 = new User("Ala");
        User user2 = new User("Ala");

        System.out.println("user1 == user2:        " + (user1 == user2));
        System.out.println("user1.equals(user2):   " + user1.equals(user2));

        // Pytanie: oba obiekty maja w srodku dokladnie to samo imie "Ala".
        // Dlaczego Java i tak mowi, ze to NIE to samo?
    }

    // ─── ZAGADKA 2: int kontra Integer ───────────────────────────────────────
    private static void zagadka2_intKontraInteger() {
        System.out.println("## Zagadka 2: int kontra Integer");

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

    // ─── ZAGADKA 3: ta sama zagadka, inne liczby ─────────────────────────────
    private static void zagadka3_malaLiczbaKontraDuza() {
        System.out.println("## Zagadka 3: mala liczba kontra duza liczba");

        Integer male1 = 100;
        Integer male2 = 100;
        System.out.println("Integer 100 == 100       -> " + (male1 == male2));

        Integer duze1 = 1000;
        Integer duze2 = 1000;
        System.out.println("Integer 1000 == 1000     -> " + (duze1 == duze2));

        // Pytanie: ten sam kod, ta sama logika - a wynik zalezy od tego,
        // JAKA to liczba (male: true, duze: false)?! To NIE jest clue tej
        // lekcji, to tylko ciekawostka (Java "cache'uje" Integery od -128
        // do 127). Zapamietajcie wniosek ponizej, nie ten szczegol.
    }

    private static void moral() {
        System.out.println("## Zasada, ktora juz teraz mozecie zapamietac:");
        System.out.println("Dla OBIEKTOW zawsze uzywamy .equals() - nigdy ==.");
        System.out.println("Dlaczego tak jest - o tym na kolejnej lekcji (model pamieci).");
    }
}
