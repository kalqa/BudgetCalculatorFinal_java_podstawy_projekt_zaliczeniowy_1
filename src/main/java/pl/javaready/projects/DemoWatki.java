package pl.javaready.projects;

public class DemoWatki {

    public static void main(String[] args) {
        Task wspolny = new Task(1, "Wspólne zadanie", 5);

        Runnable praca1 = () -> {
            int lokalna = 100;
            System.out.println(Thread.currentThread().getName() + ": lokalna=" + lokalna + ", task=" + wspolny);
        };
        Runnable praca2 = () -> {
            int lokalna = 200;
            System.out.println(Thread.currentThread().getName() + ": lokalna=" + lokalna + ", task=" + wspolny);
        };

        new Thread(praca1, "Wątek-1").start();
        new Thread(praca2, "Wątek-2").start();
    }
}
