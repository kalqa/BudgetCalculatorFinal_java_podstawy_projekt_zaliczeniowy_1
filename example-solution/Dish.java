package pl.javaready.projects;

// Danie - ma w srodku obiekt Restaurant jako pole (kompozycja/matrioszka,
// dokladnie jak Engine w Car albo Artist w Song). Cena NIE wchodzi do
// equals() - nie definiuje tozsamosci dania, to tylko dodatkowa
// informacja (ta sama Pizza Margherita moze kosztowac rozne kwoty
// w roznych wpisach, a to wciaz to samo danie).
public class Dish {

    private final String name;
    private final double price;
    private final Restaurant restaurant;

    public Dish(String name, double price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    // Metoda, ktora odwoluje sie do wlasnych pol przez this i deleguje
    // porownanie do metody equals() obiektu restaurant.
    public boolean isFromSameRestaurant(Dish other) {
        return this.restaurant.equals(other.restaurant);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dish other = (Dish) o;
        return name.equalsIgnoreCase(other.name) && restaurant.equals(other.restaurant);
    }

    @Override
    public String toString() {
        return name + " @ " + restaurant + " - " + price + " PLN";
    }
}
