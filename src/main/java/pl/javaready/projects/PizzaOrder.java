package pl.javaready.projects;

public class PizzaOrder {

    private Pizza pizza;
    private int quantity;

    public PizzaOrder(Pizza pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }

    // ===== JEDYNA metoda publiczna - to widzi "świat zewnętrzny" (np. Main) =====
    // Świat wywołuje placeOrder() i nie musi wiedzieć NIC o tym, jak liczymy cenę.
    public double placeOrder() {
        double total = calculateBasePrice();
        total += calculateToppingsCost();
        total = applyBulkDiscount(total);
        printReceipt(total);
        return total;
    }

    // ===== Metody prywatne - szczegóły ukryte przed światem =====

    private double calculateBasePrice() {
        if (pizza.getSize().equals("S")) {
            return 20.0 * quantity;
        }
        if (pizza.getSize().equals("L")) {
            return 30.0 * quantity;
        }
        return 25.0 * quantity; // "M" domyślnie
    }

    private double calculateToppingsCost() {
        return pizza.getToppingsCount() * 4.0 * quantity;
    }

    private double applyBulkDiscount(double total) {
        if (quantity >= 4) {
            return total * 0.9; // 10% rabatu przy 4 lub więcej pizzach
        }
        return total;
    }

    private void printReceipt(double total) {
        System.out.println("Zamówienie: " + quantity + "x pizza " + pizza.getSize()
                + " (" + pizza.getToppingsCount() + " dodatków)");
        System.out.println("Do zapłaty: " + total + " zł");
    }
}

/*
Porównaj:

    PizzaOrder order = new PizzaOrder(new Pizza("L", 3), 2);
    order.placeOrder();

...z tym, jak wyglądałby ten sam kod, gdyby całą logikę wrzucić bezpośrednio
do main() - 25-30 linijek liczenia cen, rabatów i drukowania, zamiast
dwóch czytelnych linijek. PizzaOrder "chowa" tę złożoność za jedną metodą.
*/
