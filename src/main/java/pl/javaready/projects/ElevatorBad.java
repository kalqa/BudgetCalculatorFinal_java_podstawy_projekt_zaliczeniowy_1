package pl.javaready.projects;

// ANTY-WZOR - tak wyglada to w prawdziwym, zaniedbanym kodzie: magic number
// (400 kg) rozjezdza sie po calej klasie, a jeden z nich jest juz NIESPOJNY.
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
}
