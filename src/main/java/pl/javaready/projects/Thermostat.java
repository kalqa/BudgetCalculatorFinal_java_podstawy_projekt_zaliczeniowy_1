package pl.javaready.projects;

public class Thermostat {

    private static final double MIN_TEMPERATURE = 10.0;
    private static final double MAX_TEMPERATURE = 30.0;

    private double temperature; // prywatne - nikt z zewnątrz nie dotknie tego bezpośrednio

    public Thermostat(double temperature) {
        setTemperature(temperature);
    }

    public boolean setTemperature(double temperature) {
        if (!isValidTemperature(temperature)) {
            System.out.println("Błąd: temperatura musi być między "
                    + MIN_TEMPERATURE + " a " + MAX_TEMPERATURE + " stopni.");
            return false;
        }
        this.temperature = temperature;
        return true;
    }

    private boolean isValidTemperature(double temperature) {
        return temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE;
    }

    public double getTemperature() {
        return temperature;
    }
}

/*
Teraz to samo, co próbowaliśmy zrobić w ThermostatBad:

    Thermostat t = new Thermostat(21.0);
    t.setTemperature(-500); // "Błąd: temperatura musi być między 10.0 a 30.0 stopni."
                             // temperatura NIE zmienia się na -500

Klasa sama pilnuje swoich danych. "Świat zewnętrzny" może tylko PROSIĆ
o zmianę (przez publiczną metodę) - a klasa decyduje, czy się zgodzić.
To jest właśnie hermetyczność: dane + reguły ich zmiany trzymane razem,
w jednym miejscu, a nie rozrzucone po całym programie.
*/
