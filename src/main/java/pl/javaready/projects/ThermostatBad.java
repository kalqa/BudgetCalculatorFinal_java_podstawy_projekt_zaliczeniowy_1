package pl.javaready.projects;

// ANTY-WZÓR - tak NIE piszemy klas. Zobacz Thermostat.java dla poprawnej wersji.
public class ThermostatBad {

    public double temperature; // publiczne pole - KAŻDY może wpisać cokolwiek

    public ThermostatBad(double temperature) {
        this.temperature = temperature;
    }
}

/*
Gdzieś zupełnie indziej w kodzie, ktoś inny pisze:

    ThermostatBad t = new ThermostatBad(21.0);
    t.temperature = -500; // nic tego nie powstrzyma - kompiluje się bez problemu!
    t.temperature = 99999; // to też

Klasa nie ma ŻADNEJ kontroli nad własnymi danymi. "Ktoś z zewnątrz"
może ustawić cokolwiek, w dowolnym miejscu kodu, bez pytania klasy o zdanie.
*/