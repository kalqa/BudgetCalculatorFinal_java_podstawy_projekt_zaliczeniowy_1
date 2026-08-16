package pl.javaready.projects;

class MainBad {
    public static void main(String[] args) {
        ThermostatBad t = new ThermostatBad(21.0);
        t.temperature = -500; // nic tego nie powstrzyma - kompiluje się bez problemu!
        t.temperature = 99999; // to też
    }
}
