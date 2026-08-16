package pl.javaready.projects;

public class Engine {

    private int horsePower;

    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    public void start() {
        System.out.println("Silnik startuje! Moc: " + horsePower + " KM");
    }

    public int getHorsePower() {
        return horsePower;
    }
}
