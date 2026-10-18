package pl.javaready.projects;

// Dane restauracji - nazwa + miasto. Czysty data object: same pola,
// equals() i toString(), zadnej logiki biznesowej.
public class Restaurant {

    private final String name;
    private final String city;

    public Restaurant(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    // Dwie restauracje sa "takie same", jesli maja ta sama nazwe
    // w tym samym miescie (bez rozniciu wielkosci liter).
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant other = (Restaurant) o;
        return name.equalsIgnoreCase(other.name) && city.equalsIgnoreCase(other.city);
    }

    @Override
    public String toString() {
        return name + " (" + city + ")";
    }
}
