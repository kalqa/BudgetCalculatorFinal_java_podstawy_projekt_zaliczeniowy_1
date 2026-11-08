# Zadanie 12: Smart Budget Analyzer na kolekcjach

**Moduł 3 — podsumowanie: `List`, `Set`, `Map`, `equals()` i `hashCode()`, kopiowanie kolekcji**

## Kontekst

Znasz już ten program z modułu 2: `Smart Budget Analyzer`, podzielony na klasy i obiekty (`Budget`, `ExpenseCategory`, `ExpenseTracker`, `SavingsGoal`, `BudgetPrinter`, `BudgetConsoleApp`, `Main`). Wtedy nie znałeś/aś jeszcze kolekcji, więc wszystko, co trzyma wiele rzeczy, było **tablicą**: `ExpenseCategory[]` w trackerze, `String[]` z nazwami, tablica wyników analizy 80/20.

Teraz znasz kolekcje, więc **przerabiamy ten sam kod tak, jak zrobiłbyś/zrobiłabyś to dzisiaj**. Punktem wyjścia jest kod, który już leży w `src/main/java/pl/javaready/projects/`: rozwiązanie zadania z modułu 2, podzielone na klasy. Możesz też pracować na własnym rozwiązaniu.

**Zasada ta sama co wtedy: poza jednym nowym wymogiem (niżej) program ma działać dokładnie tak samo.** Te same menu, te same liczby, te same napisy. To jest refaktoryzacja, nie przepisywanie od zera.

## Co zamieniasz

| Było (moduł 2) | Jest (moduł 3) | Po co |
|---|---|---|
| `ExpenseCategory[] categories` w `ExpenseTracker` | `List<ExpenseCategory>` | lista sama zna swój rozmiar (`size()`) i nie wymaga pilnowania indeksów |
| pętle `for (int i = 0; i < categories.length; i++)` | `for-each` | mniej szumu tam, gdzie indeks nie jest potrzebny |
| `String[] names` zbierane w `BudgetConsoleApp` | `List<String>` | nie trzeba z góry tworzyć tablicy o stałym rozmiarze |
| `findCategoryByName()` z pętlą po wszystkich | `Map<String, ExpenseCategory>` zbudowana w konstruktorze | jedno `get()` zamiast przeglądania wszystkiego |
| `findTopCategories()` zwraca `ExpenseCategory[]` | zwraca `List<ExpenseCategory>` | wynik ma tyle elementów, ile trzeba |
| `int[] sortedIndices` do sortowania | **kopia listy** (`new ArrayList<>(categories)`) sortowana ręcznie | nie psujesz oryginalnej kolejności kategorii |
| brak | `equals()` **i `hashCode()`** w `ExpenseCategory` | dopiero z `hashCode()` kategoria nadaje się na element zbioru i klucz mapy |

## Jeden nowy wymóg

**Nazwy kategorii nie mogą się powtarzać** (bez rozróżniania wielkości liter). Jeśli użytkownik poda nazwę, która już jest, program wypisuje komunikat i prosi o inną. Licznik „kategoria #N” nie rośnie, dopóki nazwa nie zostanie przyjęta.

Do tego użyj dwóch kolekcji naraz: **listy** (pilnuje kolejności, w jakiej użytkownik podał nazwy) i **zbioru** (pilnuje unikalności).

## Wymagane zmiany w klasach

| Klasa | Co się zmienia |
|---|---|
| `ExpenseCategory` | dopisz `hashCode()` spójne z `equals()` (porównujemy nazwę bez wielkości liter, więc hash musi liczyć się z tej samej, ujednoliconej nazwy). Przyda się metoda zwracająca nazwę małymi literami |
| `ExpenseTracker` | pole `List<ExpenseCategory>`, a obok `Map<String, ExpenseCategory>` budowana raz, w konstruktorze. `findCategoryByName()` korzysta z mapy. `getCategories()` zwraca **kopię** listy. `findTopCategories()` zwraca listę |
| `BudgetConsoleApp` | zbieranie nazw i kwot na listach, nowy wymóg z unikalnością nazw |
| `BudgetPrinter` | te same raporty, tylko pętle po liście i `List` w sygnaturach |
| `Budget`, `SavingsGoal`, `MathUtils`, `ConsoleInput`, `Main` | **bez zmian** |

## Zasady, których pilnujemy

- **Pola `private` i `final`, gdzie się da**, tak jak w module 2. Lista i mapa w `ExpenseTracker` też są `final` (zmienia się ich zawartość, nie to, na co wskazują).
- **Typ zmiennej to `List`, `Set`, `Map`** (nie `ArrayList`, `HashMap`) tam, gdzie tylko deklarujesz zmienną czy parametr. `new ArrayList<>()` piszesz dopiero po prawej stronie.
- **Wielkość liter w nazwie** nie ma znaczenia ani przy szukaniu (`transport` znajdzie `Transport`), ani przy sprawdzaniu duplikatów.
- **`ExpenseTracker` nadal niczego nie wypisuje.** Liczy i zwraca, wypisuje `BudgetPrinter`.
- **Stałe `final` dla magicznych liczb**, jak w module 2.

## Czego świadomie NIE używamy (jeszcze)

Interfejsów własnych, dziedziczenia, `Comparable` i `Comparator`, lambd, `removeIf`, `var`. Dlatego sortowanie kategorii po kwocie robisz **ręcznie** na kopii listy (`get`, `set`, zmienna pomocnicza): `Collections.sort` działa tylko dla `Integer` i `String`, a `ExpenseCategory` nie umie się jeszcze porównywać.

## Podpowiedzi do przemyślenia przed kodowaniem

1. Dlaczego `getCategories()` ma zwracać kopię listy, a nie samą listę? Co mogłaby zrobić klasa, która dostanie oryginał?
2. Mapa w trackerze i lista trzymają **te same obiekty**. Kiedy taka podwójna struktura jest bezpieczna, a kiedy zaczęłaby się rozjeżdżać? (Podpowiedź: czy tracker jest zmieniany po stworzeniu?)
3. Co się stanie z `HashSet<ExpenseCategory>`, jeśli dopiszesz `equals()` bez `hashCode()`? Spróbuj to sprawdzić na dwóch kategoriach `Food` i `food`.
4. Dlaczego sortujesz **kopię**, a nie `categories`? Co zobaczyłby użytkownik w raporcie miesięcznym, gdybyś posortował oryginał?
5. Czy do sprawdzania duplikatów potrzebujesz zbioru, skoro `List` ma `contains`? Co się zmienia, gdy kategorii jest dużo?

---

*Przykładowe rozwiązanie jest w folderze `example-solution-collections/`. Spróbuj najpierw zrobić zadanie samodzielnie: porównanie ma sens dopiero, gdy Twój kod działa (albo utknąłeś/aś na dobre). Nazwy metod nie muszą się zgadzać 1:1, liczy się to, co jest w której kolekcji i dlaczego.*
