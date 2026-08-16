package pl.javaready.projects;

class MainGood {
    public static void main(String[] args) {
        Thermostat t = new Thermostat(21.0);
        t.setTemperature(-500); // "Błąd: temperatura musi być między 10.0 a 30.0 stopni."
        // temperatura NIE zmienia się na -500
        t.temperature = -500;
    }
}
