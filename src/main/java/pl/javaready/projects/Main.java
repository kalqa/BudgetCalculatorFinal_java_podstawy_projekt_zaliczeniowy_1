package pl.javaready.projects;

// Main pokazuje "na żywo" dokładnie to, co widać w wizualizacji modelu pamięci:
// - int to prymityw, który żyje wprost na stosie
// - Integer to KLASA - nawet "Integer priority = 5;" tworzy obiekt na stercie
// - referencja to tylko adres, kopiowana do konstruktora Task(...)
// - obiekty porównujemy przez equals(), a nie ==
//
// Odpal to w debugerze i podglądaj zmienne w IntelliJ (Variables / Evaluate)
// - zobaczysz dokładnie te same wartości i referencje, co na diagramie.
public class Main {

    public static void main(String[] args) {
        int id = 1;
        String title = "Kupić mleko";

        // Integer to klasa - "new Integer(...)" dzieje się w tle (autoboxing)
        Integer priority = 5;

        Task task = new Task(id, title, priority);
        System.out.println(task);
        System.out.println("Priorytet zadania: " + task.getPriority());

        // ─── PLAC ZABAW: == kontra equals() ─────────────────────────────────
        // Prymitywy - zawsze ==
        int a = 5;
        int b = 5;
        System.out.println("int a == b: " + (a == b)); // true - to zwykłe porównanie wartości

        // Obiekty - powinniśmy używać equals()
        Integer x = 200;
        Integer y = 200;
        System.out.println("Integer x == y: " + (x == y));         // uwaga: false! (dwa różne obiekty)
        System.out.println("Integer x.equals(y): " + x.equals(y)); // true - ta sama wartość w środku

        // Małe Integery (-128..127) Java trzyma w "cache" i podaje ten sam
        // obiekt, dlatego akurat w tym zakresie == czasem "przez przypadek" zadziała:
        Integer small1 = 100;
        Integer small2 = 100;
        System.out.println("mały Integer 100 == 100: " + (small1 == small2)); // true - pułapka!

        // null - referencja, która na nic jeszcze nie wskazuje
        Integer nieustawiony = null;
        System.out.println("czy nieustawiony == null: " + (nieustawiony == null));
    }
}
