# Zadanie: Refaktoryzacja Smart Budget Analyzer na klasy i obiekty

**Moduł 2 — podsumowanie: klasy, obiekty, enkapsulacja, kompozycja, konstruktory, podział logiczny**

## Kontekst

`SmartBudgetAnalyzer` to ten sam kod, który widziałeś/aś na samym początku modułu (lekcja 02.02) — jedna klasa, same metody `static`, kilkaset linijek. Wtedy nie znałeś/aś jeszcze klas i obiektów, więc kod musiał tak wyglądać. Teraz znasz już wszystko, czego potrzeba, żeby zrobić to porządnie.

**Zadanie: ten sam program, ta sama funkcjonalność, zero nowej logiki biznesowej — tylko podział na klasy i obiekty.** To jest refaktoryzacja, nie przepisywanie od zera. Jeśli coś drukowało "Dostępne na elastyczne wydatki: 2500.0 PLN", po refaktoryzacji ma drukować dokładnie to samo, w tym samym miejscu.

Oryginalny kod siedzi w `src/main/java/pl/javaready/projects/SmartBudgetAnalyzer.java` — przeczytaj go najpierw w całości, zanim zaczniesz dzielić.

Zanim zaczniesz kodować, zobacz `architektura-budget-analyzer.html` — diagram pokazujący, jak docelowe klasy mają się ze sobą łączyć (kto kogo tworzy, kto do kogo woła).

## Co ma robić program (bez zmian)

Program konsolowy, który:
1. Pyta o miesięczny dochód netto i (opcjonalnie) koszty stałe → liczy dostępny budżet.
2. Pyta o kategorie wydatków i kwotę wydaną w każdej.
3. Pokazuje menu w pętli: **raport miesięczny**, **analiza 80/20**, **cel oszczędnościowy**, **wyjście**.

Wszystkie reguły liczenia (procenty, "zdrowy poziom" wydatków, które kategorie są "top", plan oszczędnościowy, proponowane cięcia) zostają identyczne co do liczby po przecinku.

## Jedna rzecz, którą WOLNO Ci zmienić (bo to tylko efekt starego stylu, nie logika biznesowa)

**`clearBuffer()` zniknie sam.** Oryginał miesza `scanner.nextInt()`/`nextDouble()` z `scanner.nextLine()`, stąd całe `clearBuffer()`. Jeśli użyjesz `ConsoleInput` (patrz niżej), które czyta wszystko przez `nextLine()` i parsuje, ten problem nie istnieje — nie musisz nic specjalnie odtwarzać.

Poza tym punktem: zachowanie identyczne.

## Wymagane klasy (minimum)

Nie musisz nazwać ich dokładnie tak, ale te odpowiedzialności muszą siedzieć w osobnych klasach:

| Klasa | Odpowiedzialność |
|---|---|
| `ConsoleInput` | opakowanie na `Scanner` — masz je z poprzedniej lekcji, dopisz tylko `readDouble()` (kwoty w tym programie to liczby dziesiętne, nie tylko całkowite) |
| `ExpenseCategory` | **jedna** kategoria wydatków: nazwa + kwota. Zastępuje dwie równoległe tablice (`categories[]` / `amounts[]`) z oryginału |
| `Budget` | dochód, koszty stałe, dostępny budżet (liczony raz, w konstruktorze) + ocena statusu budżetu |
| `SavingsGoal` | dane **jednego** celu oszczędnościowego i wszystkie wyliczenia wokół niego (ile pozostało, ile miesięcznie, ile pokryje dodatkowy dochód, ile trzeba docięć) |
| `ExpenseTracker` | przechowuje tablicę `ExpenseCategory`, liczy sumy, średnie, "zdrowy poziom", top kategorie 80/20, szuka kategorii po nazwie |
| `MathUtils` | **jedyne uzasadnione miejsce na `static`** w tym zadaniu (lekcja 02.11: funkcje `static` mają sens w klasach TOOL/UTIL) — `percentage(part, whole)` i `round(value)` |
| `BudgetPrinter` | wypisuje duże, wieloliniowe raporty na ekran (menu, raport miesięczny, analiza 80/20, szczegóły kategorii, plan oszczędnościowy) |
| `BudgetConsoleApp` | steruje całym programem: zbiera dane wejściowe, prowadzi menu w pętli, woła resztę klas |
| `Main` | tylko tworzy obiekty i je łączy — zero logiki, zero czytania wejścia |

Drobne, jednolinijkowe pytania do użytkownika (np. "Ile to kosztuje?", "tak/nie") możesz zadawać wprost z `BudgetConsoleApp` — nie każdy `System.out.println` musi iść przez `BudgetPrinter`. Przez `BudgetPrinter` powinny iść te fragmenty, które są **całym, wieloliniowym raportem**.

## Zasady, których pilnujemy (to wszystko było już w kursie)

- **Pola `private`.** Zero bezpośredniego dostępu z zewnątrz — tylko przez publiczne metody.
- **Pola `final`, gdzie się da.** Prawie wszystko w tym programie ustawia się raz i się nie zmienia (dokładnie jak kwoty kategorii w oryginale — nikt ich po zebraniu nie modyfikuje). Wyjątek: `budget` i `tracker` w `BudgetConsoleApp` nie mogą być `final`, bo dostają wartość dopiero w `run()`, nie w konstruktorze — i to jest OK, dopóki nadal są `private`.
- **Konstruktory ustawiają wszystkie pola**, z `this.` tam, gdzie parametr nazywa się tak jak pole.
- **Gettery tam, gdzie inna klasa faktycznie czyta wartość.** Żadnego gettera "na wszelki wypadek".
- **Żadnych setterów, które psują reguły.** Skoro w oryginale nic nigdy nie zmienia kwoty kategorii po zebraniu danych — nie dodawaj `setAmount()`, którego nikt nie potrzebuje i który tylko otworzyłby furtkę do bałaganu.
- **Metody prywatne vs publiczne.** Każda publiczna metoda, która robi więcej niż 3-4 linijki, powinna wołać prywatne metody pomocnicze (np. `ExpenseTracker.findTopCategories()` publiczne, ale sortowanie i liczenie 80% — prywatne).
- **Stałe `final` (WIELKIE_LITERY) dla magicznych liczb.** W oryginale jest sporo liczb wklepanych na żywca w kodzie — przynajmniej te muszą dostać nazwę: próg 80% (top kategorie), limit 3 kategorii, 20% (proponowane cięcie), 12 (miesięcy w roku), 0.67 (cel redukcji użycia), 70 i 100 (progi statusu budżetu).
- **Kompozycja, nie równoległe tablice.** `ExpenseTracker` trzyma `ExpenseCategory[]`, a nie osobną tablicę nazw i osobną tablicę kwot.
- **`equals()` w `ExpenseCategory`**, porównujące dwie kategorie po nazwie (bez rozróżniania wielkości liter) — tak jak `User` w zagadce z lekcji 12.28. **Nie musisz** nadpisywać `hashCode()` — to jeszcze przed nami.
- **`toString()` w `ExpenseCategory`**, żeby `System.out.println(category)` dawało czytelny tekst, a nie `ExpenseCategory@3b9a45`.
- **Prymityw, nie obiekt, jeśli nie musi być obiektem.** `int`, `double`, `boolean` wszędzie, gdzie się da — nie zamieniaj ich na `Integer`/`Double` tylko dlatego, że "to też by zadziałało".
- **`Main` jest chudy.** Tworzy `Scanner`, `ConsoleInput`, `BudgetPrinter`, `BudgetConsoleApp` — i tyle. Żadnego czytania danych, żadnej logiki.
- **Klasy rozmawiają wyłącznie przez publiczne metody.** Żadna klasa nie sięga do pola innej klasy po kropce (poza tym, że i tak by się nie dało, skoro wszystko jest `private`).

## Czego świadomie NIE używamy (jeszcze)

`ArrayList` i inne kolekcje, dziedziczenie, interfejsy, `hashCode()`, wyjątki / `try-catch`. Tego jeszcze nie było w kursie — tablice (`ExpenseCategory[]`) są w pełni wystarczające.

## Podpowiedzi do przemyślenia przed kodowaniem

1. Dlaczego dwie równoległe tablice (`categories[]`, `amounts[]`) są ryzykowne, i jak jedna klasa `ExpenseCategory` to rozwiązuje? Co by się stało, gdyby ktoś posortował jedną tablicę, a zapomniał o drugiej?
2. `setSavingsGoal()` w oryginale ma naraz 7 lokalnych zmiennych, które zawsze idą w parze i są przekazywane razem z metody do metody. Czym to pachnie, i jak wygląda to samo po przeniesieniu do klasy `SavingsGoal`?
3. Gdzie powinna mieszkać logika "policz top kategorie 80/20" (sortowanie, sumowanie), a gdzie wypisywanie wyniku na ekran — czy to ta sama odpowiedzialność?
4. `ExpenseTracker` trzyma tablicę obiektów, nie dwie tablice prymitywów. Narysuj sobie (na boku, nie w kodzie), jak to wygląda na stosie i stercie dla jednej kategorii — gdzie leży obiekt `ExpenseCategory`, a co trzyma zmienna w tablicy.

---

*Poniżej (w folderze `example-solution/`) znajduje się przykładowe rozwiązanie. Spróbuj najpierw zrobić zadanie samodzielnie — porównanie z gotowym rozwiązaniem ma sens dopiero, gdy Twój kod działa (albo utknąłeś/aś na dobre). Nazwy klas/metod nie muszą się zgadzać 1:1 — liczy się podział odpowiedzialności, nie identyczne nazewnictwo.*
