package pl.javaready.projects;

public class DemoOutOfMemory {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long maxBajty = runtime.maxMemory();
        System.out.println("Maksymalny heap: " + maxBajty + " B, "
                + (maxBajty / (1024 * 1024)) + " MB, "
                + (maxBajty / (1024 * 1024 * 1024)) + " GB");

        Task ostatnie = null;
        int licznik = 0;

        while (true) {
            licznik++;
            ostatnie = new Task(licznik, "Zadanie " + licznik, 1, ostatnie);

            long uzyteBajty = runtime.totalMemory() - runtime.freeMemory();
            long uzyteMb = uzyteBajty / (1024 * 1024);
            long uzyteGb = uzyteBajty / (1024 * 1024 * 1024);

            System.out.println("obiektów: " + licznik
                    + ", zajęty heap: " + uzyteBajty + " B, "
                    + uzyteMb + " MB, "
                    + uzyteGb + " GB");
        }
    }
}
