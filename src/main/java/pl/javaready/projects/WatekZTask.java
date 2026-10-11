package pl.javaready.projects;

public class WatekZTask extends Thread {

    private final int lokalna;
    private final Task wspolny;

    public WatekZTask(String nazwa, int lokalna, Task wspolny) {
        super(nazwa);
        this.lokalna = lokalna;
        this.wspolny = wspolny;
    }

    public void run() {
        System.out.println(getName() + ": lokalna=" + lokalna + ", task=" + wspolny);
    }
}
