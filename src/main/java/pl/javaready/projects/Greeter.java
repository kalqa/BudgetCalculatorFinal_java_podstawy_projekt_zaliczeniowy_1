package pl.javaready.projects;

// Greeter przyjmuje w konstruktorze String - klase, ktorej NIE napisalismy,
// napisali ja tworcy Javy. Uzywamy jej dokladnie tak, jak za chwile
// uzyjemy naszej wlasnej klasy Person w PersonRegistration.
public class Greeter {

    private final String name;

    public Greeter(String name) {
        this.name = name;
    }

    public String greet() {
        return "Czesc, " + name + "!";
    }
}
