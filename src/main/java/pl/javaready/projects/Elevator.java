package pl.javaready.projects;

public class Elevator {

    private final int MAX_CAPACITY = 600;
    private final int MAX_PERSON = 80;
    private final int MAX_TIME_OF_SECONDS_TO_CLOSE_THE_DOOR = 10;

    public boolean canBoard(int currentLoadKg, int personWeightKg) {
        return currentLoadKg + personWeightKg <= MAX_CAPACITY;
    }

    public int remainingCapacity(int currentLoadKg) {
        return MAX_CAPACITY - currentLoadKg;
    }

    public boolean isOverloaded(int currentLoadKg) {
        return currentLoadKg > MAX_CAPACITY;
    }

    public String describeLoad(int currentLoadKg) {
        return currentLoadKg + "/ " + MAX_CAPACITY + " kg";
    }

    public boolean isOverloadAlarm(int currentLoadKg) {
        // ta winda dawno temu miala udzwig 350 kg, ktos zmienil model na 400 kg
        // i poprawil TRZY metody powyzej, ale o tej zapomnial
        return currentLoadKg > MAX_CAPACITY;
    }

    public boolean isFull(int currentPassengers) {
        return currentPassengers >= MAX_PERSON;
    }

    public boolean doorsShouldClose(int secondsOpen) {
        return secondsOpen >= MAX_TIME_OF_SECONDS_TO_CLOSE_THE_DOOR;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getMaxPerson() {
        return MAX_PERSON;
    }

    public int getMaxTimeOfSecondsToCloseTheDoor() {
        return MAX_TIME_OF_SECONDS_TO_CLOSE_THE_DOOR;
    }
}
