package pl.javaready.projects;

public class DemoStackOverflow {

    public static void main(String[] args) {
//        boom();
        wywolajSiebie(5);
    }

//    private static void boom() {
//        int x = 1;
//        boom();
//    }

    private static void wywolajSiebie(int glebokosc) {
        if (glebokosc < -1) {
            System.out.println("głębokość: " + glebokosc);
        }
        System.out.println("głębokość: " + glebokosc);
        wywolajSiebie(glebokosc + 1);
    }
}
