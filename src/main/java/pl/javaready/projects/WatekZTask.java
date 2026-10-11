package pl.javaready.projects;

public class WatekZTask extends Thread {

    private final String nameOfThread;
    private final int lokalna;
    private final Task wspolny;

    public WatekZTask(String nazwa, int lokalna, Task wspolny) {
        this.nameOfThread = nazwa;
        this.lokalna = lokalna;
        this.wspolny = wspolny;
    }

    public void run() {
        int x = 1000;
        System.out.println(this.nameOfThread + ": lokalna=" + this.lokalna + ", task=" + this.wspolny + x);
    }
}
