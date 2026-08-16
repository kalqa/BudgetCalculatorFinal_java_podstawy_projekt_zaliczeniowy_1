package pl.javaready.projects;

public class Mug {

    // final (bez static) - to WŁAŚCIWOŚĆ TEGO KONKRETNEGO kubka.
    // Ustawiana raz, w konstruktorze, i już nigdy się nie zmienia
    // (chyba że ktoś zmieni kod i skompiluje program od nowa).
    private final int capacityMl;

    public Mug(int capacityMl) {
        this.capacityMl = capacityMl;
    }

    public boolean canFill(int amountMl) {
        return amountMl <= capacityMl;
    }

    public int remainingSpace(int currentMl) {
        return capacityMl - currentMl;
    }

    public int getCapacityMl() {
        return capacityMl;
    }
}

/*
Zamiast liczby "300" wpisanej w dwóch miejscach, mamy JEDNO pole
"capacityMl" z sensowną nazwą. Java pilnuje, że nikt go już nie zmieni:

    Mug mug = new Mug(300);
    mug.capacityMl = 500; // BŁĄD KOMPILACJI - "capacityMl" jest final,
                           // nie da się go przypisać drugi raz

Każdy Mug może mieć inną pojemność (250, 300, 400...) - final nie znaczy
"ta sama wartość dla wszystkich", tylko "ta wartość, RAZ ustawiona,
już się nie zmieni w TYM obiekcie". To jest różnica względem static final
z Ticket.java, gdzie BASE_PRICE było jedną, wspólną liczbą dla WSZYSTKICH biletów.
*/
