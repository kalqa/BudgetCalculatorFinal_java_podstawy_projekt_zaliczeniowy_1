package pl.javaready.projects;

public class Elevator {

    // final (bez static) - to WLASCIWOSC TEJ KONKRETNEJ windy.
    // Ustawiana raz, w konstruktorze, i juz nigdy sie nie zmienia
    // (chyba ze ktos zmieni kod i skompiluje program od nowa).
    private final int maxLoadKg;

    public Elevator(int maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }

    public boolean canBoard(int currentLoadKg, int personWeightKg) {
        return currentLoadKg + personWeightKg <= maxLoadKg;
    }

    public int remainingCapacity(int currentLoadKg) {
        return maxLoadKg - currentLoadKg;
    }

    public boolean isOverloaded(int currentLoadKg) {
        return currentLoadKg > maxLoadKg;
    }

    public String describeLoad(int currentLoadKg) {
        return currentLoadKg + "/" + maxLoadKg + " kg";
    }

    public boolean isOverloadAlarm(int currentLoadKg) {
        // liczone ZAWSZE na podstawie maxLoadKg tej windy,
        // wiec nigdy nie moze sie "rozjechac" jak w ElevatorBad
        return currentLoadKg > maxLoadKg;
    }

    public int getMaxLoadKg() {
        return maxLoadKg;
    }
}

/*
Zamiast liczby "400" wpisanej w czterech miejscach (i "350" zgubionego w piatym),
mamy JEDNO pole "maxLoadKg" z sensowna nazwa. Java pilnuje, ze nikt
go juz nie zmieni:

    Elevator elevator = new Elevator(400);
    elevator.maxLoadKg = 1000; // BLAD KOMPILACJI - "maxLoadKg"
                                // jest final, nie da sie go przypisac drugi raz

Kazda winda moze miec inny udzwig (400 kg w bloku mieszkalnym, 1000 kg winda
towarowa...) - final nie znaczy "ta sama wartosc dla wszystkich", tylko
"ta wartosc, RAZ ustawiona, juz sie nie zmieni w TYM obiekcie".
*/
