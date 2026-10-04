package pl.javaready.projects;

public class DemoStackOverflow {

    public static void main(String[] args) {
        wywolajSiebie(0);
    }

    // breakpoint tutaj + panel "Frames" w debugerze = dokladnie ten stos
    private static void wywolajSiebie(int glebokosc) {
        if (glebokosc % 1000 == 0) {
            System.out.println("głębokość: " + glebokosc);
        }
        wywolajSiebie(glebokosc + 1);
    }
}
