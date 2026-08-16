package pl.javaready.projects;

public class Thermostat {

    private double temperature; // prywatne - nikt z zewnątrz nie dotknie tego bezpośrednio

    public Thermostat(double temperature) {
        setTemperature(temperature);
    }

    public boolean setTemperature(double temperature) {
        if (!isValidTemperature(temperature)) {
            System.out.println("Błąd: temperatura musi być między "
                    + 10.0 + " a " + 30.0 + " stopni.");
            return false;
        }
        this.temperature = temperature;
        return true;
    }

    private boolean isValidTemperature(double temperature) {
        return temperature >= 10.0 && temperature <= 30.0;
    }

    public double getTemperature() {
        return temperature;
    }
}

/*Klasa sama pilnuje swoich danych. "Świat zewnętrzny" może tylko PROSIĆ
o zmianę (przez publiczną metodę) - a klasa decyduje, czy się zgodzić.
To jest właśnie hermetyczność: dane + reguły ich zmiany trzymane razem,
w jednym miejscu, a nie rozrzucone po całym programie.
*/

