package pl.javaready.projects;

public class Car {

    private String model;
    private Engine engine; // <- OBIEKT jako pole innej klasy. To jest to nowe.

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("Uruchamiam samochód: " + model);
        engine.start(); // Car nie startuje silnika sam - PROSI o to obiekt Engine
    }

    @Override
    public String toString() {
        return model + " (silnik: " + engine.getHorsePower() + " KM)";
    }
}

/*
Do tej pory pola klasy były typu int, double, String, boolean...
Teraz polem jest CAŁY OBIEKT innej klasy, którą sam napisałeś:

    private final Engine engine;

Car nie duplikuje danych silnika (nie ma swojego pola horsePower) - po prostu
TRZYMA CAŁY OBIEKT Engine u siebie i woła jego metody, kiedy potrzebuje.
To się nazywa kompozycja: klasa "ma" inną klasę, zamiast "być" nią.
*/
