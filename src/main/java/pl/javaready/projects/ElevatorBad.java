package pl.javaready.projects;

public class ElevatorBad {

    public boolean canBoard(int currentLoadKg, int personWeightKg) {
        return currentLoadKg + personWeightKg <= 400;
    }

    public int remainingCapacity(int currentLoadKg) {
        return 400 - currentLoadKg;
    }

    public boolean isOverloaded(int currentLoadKg) {
        return currentLoadKg > 400;
    }

    public String describeLoad(int currentLoadKg) {
        return currentLoadKg + "/400 kg";
    }

    public boolean isOverloadAlarm(int currentLoadKg) {
        // ta winda dawno temu miala udzwig 350 kg, ktos zmienil model na 400 kg
        // i poprawil TRZY metody powyzej, ale o tej zapomnial
        return currentLoadKg > 350;
    }

    public boolean isFull(int currentPassengers) {
        return currentPassengers >= 8;
    }

    public boolean doorsShouldClose(int secondsOpen) {
        return secondsOpen >= 10;
    }
}
