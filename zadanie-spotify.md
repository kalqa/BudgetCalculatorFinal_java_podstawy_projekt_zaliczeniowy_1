# Zadanie: SpotifyConsoleApp

**Moduł 2 — podsumowanie: klasy, obiekty, enkapsulacja, warstwy**

## Kontekst

To zadanie podsumowuje cały moduł 2. Nie ma tu żadnej nowej wiedzy — jest za to spory kawałek kodu, w którym masz **świadomie przesadzić z liczbą klas**. W prawdziwych projektach każda z tych rzeczy (dane, reguły, wejście, wyjście, sterowanie) siedzi w osobnej klasie — tu masz to poćwiczyć na małą skalę, zanim zobaczysz to w dużym projekcie zaliczeniowym.

Domena: **biblioteka piosenek** (jak uproszczony Spotify). Użytkownik dodaje piosenki i przegląda listę.

## Co ma robić program

Konsolowe menu w pętli:

```
1. Dodaj piosenkę
2. Pokaż listę
3. Wyjście
```

- **Dodaj piosenkę** — pyta o tytuł, wykonawcę i długość w sekundach, dodaje piosenkę do biblioteki.
- **Pokaż listę** — wypisuje wszystkie dodane piosenki, ponumerowane, w formacie:
  `1. Bohemian Rhapsody - Queen (5:55)` (sekundy przeliczone na minuty:sekundy).
- **Wyjście** — kończy program.

## Wymagane klasy (minimum)

Nie musisz nazwać ich dokładnie tak, ale każda z tych **odpowiedzialności** musi siedzieć w osobnej klasie:

| Klasa | Odpowiedzialność |
|---|---|
| `Artist` | reprezentuje wykonawcę (na razie: samo imię/nazwa) |
| `Song` | dane jednej piosenki — tytuł, `Artist`, długość w sekundach |
| `Library` | przechowuje piosenki, pilnuje limitu pojemności |
| `SongPrinter` | wypisuje menu i listę piosenek na ekran |
| `SpotifyConsoleApp` | steruje przepływem — czyta wybór, woła resztę |
| `Main` | tylko tworzy obiekty i je łączy |

**Uwaga:** `ConsoleInput` (opakowanie na `Scanner`) już masz z poprzedniej lekcji — użyj go bez zmian. To jest dokładnie ten moment, o którym była mowa: klasa napisana raz, używana w kolejnym, zupełnie innym programie.

## Zasady, których pilnujemy (to wszystko było już w kursie)

- **Pola zawsze `private final`.** Wartość ustawiana raz, w konstruktorze — żadnych setterów. Jeśli coś ma się zmieniać w czasie działania programu (np. licznik piosenek w `Library`), to pole nie jest `final`, ale nadal jest `private`.
- **Żadnego `static`** poza jednym wyjątkiem: stałą liczbową dla limitu pojemności biblioteki (`private static final int MAX_SONGS = ...`) — to jest WŁAŚCIWOŚĆ KLASY, nie obiektu, więc `static` ma tu sens. Nigdzie indziej `static` nie jest potrzebny.
- **Każda klasa ma konstruktor**, który ustawia wszystkie pola.
- **Gettery tam, gdzie inna klasa faktycznie potrzebuje odczytać wartość.** Nie dodawaj gettera "na zapas", jeśli nic z niego nie korzysta.
- **`toString()` nadpisany w `Song` i `Artist`** — żeby `System.out.println(song)` dawał czytelny tekst, a nie `Song@3b9a45`.
- **Kompozycja ("matrioszka"):** `Song` ma pole typu `Artist` (obiekt), a nie sam `String` z imieniem wykonawcy — dokładnie ten sam wzorzec co `Car` z `Engine` w środku.
- **Metody prywatne vs publiczne.** Tam gdzie metoda publiczna robi więcej niż 3–4 linijki logiki, wydziel sobie prywatną metodę pomocniczą i wywołaj ją ze środka (tak jak `run()` w `SpotifyConsoleApp` woła prywatne `handleAddSong()` / `handleShowSongs()`).
- **Klasy rozmawiają wyłącznie przez metody publiczne.** Żadna klasa nie sięga bezpośrednio do pola innej klasy (i tak by się nie dało, skoro wszystko jest `private` — ale miej to z tyłu głowy przy projektowaniu).
- **`Main` jest chudy.** Tworzy `Scanner`, `ConsoleInput`, `Library`, `SongPrinter`, `SpotifyConsoleApp` — i tyle. Żadnej logiki, żadnego czytania wejścia w `Main`.

## Czego świadomie NIE używamy (jeszcze)

`ArrayList` i inne kolekcje, dziedziczenie, interfejsy, `equals()`/`hashCode()` — tego jeszcze nie było w kursie. Piosenki trzymaj w zwykłej tablicy `Song[]`, tak jak `TaskBoard` trzymał `Task[]`.

## Podpowiedź, jeśli utkniesz

Ten sam układ klas już widziałeś w kursie jako `TaskBoard` / `TaskConsoleApp` / `TaskPrinter`. To zadanie to ten sam szkielet przeniesiony na inną domenę, plus jeden dodatkowy poziom kompozycji (`Song` → `Artist`).
