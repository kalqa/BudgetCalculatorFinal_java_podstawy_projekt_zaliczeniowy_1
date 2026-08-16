package pl.javaready.projects;

// ANTY-WZÓR - tak NIE piszemy. Zobacz Mug.java dla poprawnej wersji.
public class Mugbad {

    public boolean canFill(int amountMl) {
        return amountMl <= 300; // skąd ta liczba? co ona znaczy? czemu akurat 300?
    }

    public int remainingSpace(int currentMl) {
        return 300 - currentMl; // ta sama liczba wpisana DRUGI RAZ, ręcznie
    }
}

/*
Problem: 300 pojawia się dwa razy, "z palca", bez nazwy i bez wyjaśnienia.
Jeśli ktoś zmieni pojemność kubka na 400, musi pamiętać, żeby poprawić
liczbę w OBU miejscach - i łatwo o jednym zapomnieć.
*/
