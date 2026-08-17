package pl.javaready.projects;

public class Elevator {

    private final int MAX_LOAD_KG = 400;
    private final int MAX_PASSENGERS = 8;
    private final int DOOR_OPEN_SECONDS = 10;

    public Elevator(){
    }

    public boolean canBoard(int currentLoadKg, int personWeightKg) {
        return currentLoadKg + personWeightKg <= MAX_LOAD_KG;
    }

    public int remainingCapacity(int currentLoadKg) {
        return MAX_LOAD_KG - currentLoadKg;
    }

    public boolean isOverloaded(int currentLoadKg) {
        return currentLoadKg > MAX_LOAD_KG;
    }

    public String describeLoad(int currentLoadKg) {
        return currentLoadKg + "/" + MAX_LOAD_KG + " kg";
    }

    public boolean isOverloadAlarm(int currentLoadKg) {
        // liczone ZAWSZE na podstawie MAX_LOAD_KG tej windy,
        // wiec nigdy nie moze sie "rozjechac" jak w ElevatorBad
        return currentLoadKg > MAX_LOAD_KG;
    }

    public boolean isFull(int currentPassengers) {
        return currentPassengers >= MAX_PASSENGERS;
    }

    public boolean doorsShouldClose(int secondsOpen) {
        return secondsOpen >= DOOR_OPEN_SECONDS;
    }

    public int getMaxLoadKg() {
        return MAX_LOAD_KG;
    }

    public int getMaxPassengers() {
        return MAX_PASSENGERS;
    }

    public int getDoorOpenSeconds() {
        return DOOR_OPEN_SECONDS;
    }
}
