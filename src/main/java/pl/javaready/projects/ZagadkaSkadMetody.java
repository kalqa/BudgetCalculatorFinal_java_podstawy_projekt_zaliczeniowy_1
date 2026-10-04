package pl.javaready.projects;

public class ZagadkaSkadMetody {

    public static void main(String[] args) {
        System.out.println("## Zagadka 3: skad User ma equals/hashCode/toString?");

        User user = new User("Ala");

        System.out.println("user.toString():    " + user.toString());
        System.out.println("user.hashCode():    " + user.hashCode());
        System.out.println("user.equals(user):  " + user.equals(user));

        // Pytanie: otworzcie klase User - jest tam tylko pole i konstruktor,
        // ZERO metod. A mimo to powyzsze 3 linijki dzialaja. Skad Java to
        // wziela?
        //
        // To jedna z najwazniejszych rzeczy z dzisiejszej lekcji: KAZDA
        // klasa w Javie, bez wyjatku, ma wbudowane fabrycznie trzy metody:
        // equals(), hashCode() i toString(). Nie musisz ich pisac, zeby
        // istnialy - dostajesz je "w pakiecie", za darmo. (Szczegoly tego
        // "skad" - na kolejnych lekcjach.)
    }
}
