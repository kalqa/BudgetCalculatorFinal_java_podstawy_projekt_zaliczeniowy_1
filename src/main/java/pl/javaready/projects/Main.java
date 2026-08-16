package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = new Pizza("L", 20);
        PizzaOrder order = new PizzaOrder(pizza, 80);

        order.placeOrder();
    }
}
