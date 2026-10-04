package pl.javaready.projects;

public class ZagadkaUserRowneUser {

    public static void main(String[] args) {
        System.out.println("## Zagadka 2: User != User?");

        Integer liczba = 1000;
        User user1 = new User("Ala", 30);
        User user2 = new User("Ala", 30);

        System.out.println("user1 == user2:        " + (user1 == user2));
        System.out.println("user1.equals(user2):   " + user1.equals(user2));

        // Pytanie: oba obiekty maja w srodku dokladnie to samo imie "Ala".
        // Dlaczego Java i tak mowi, ze to NIE to samo?
    }
}
