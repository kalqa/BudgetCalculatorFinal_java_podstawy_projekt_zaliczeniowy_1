package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = new Pizza("L", 3);
        PizzaOrder order = new PizzaOrder(pizza, 2);

        order.placeOrder();

        // Porównaj: to dwie linijki. Cała logika liczenia ceny (rozmiar,
        // dodatki, rabat przy większej ilości) i drukowania paragonu jest
        // ukryta wewnątrz PizzaOrder - Main nic o niej nie wie.
    }
}
