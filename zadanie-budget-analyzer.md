# Zadanie: Refaktoryzacja Smart Budget Analyzer na klasy i obiekty

**Moduł 2 — podsumowanie: klasy, obiekty, enkapsulacja, kompozycja, konstruktory, podział logiczny**

## Kontekst

`SmartBudgetAnalyzer` to ten sam kod, który widziałeś/aś na samym początku modułu (lekcja 02.02) — jedna klasa, same metody `static`, kilkaset linijek. Wtedy nie znałeś/aś jeszcze klas i obiektów, więc kod musiał tak wyglądać. Teraz znasz już wszystko, czego potrzeba, żeby zrobić to porządnie.

**Zadanie: ten sam program, ta sama funkcjonalność, zero nowej logiki biznesowej — tylko podział na klasy i obiekty.** To jest refaktoryzacja, nie przepisywanie od zera. Jeśli coś drukowało "Dostępne na elastyczne wydatki: 2500.0 PLN", po refaktoryzacji ma drukować dokładnie to samo, w tym samym miejscu.

Oryginalny kod siedzi w `src/main/java/pl/javaready/projects/SmartBudgetAnalyzer.java` — przeczytaj go najpierw w całości, zanim zaczniesz dzielić.

## Architektura — jak klasy mają się ze sobą łączyć

Przerywane strzałki to `tworzy`, ciągłe miedziane to `łączy / woła`. `MathUtils` stoi z boku bez strzałek — to narzędzie (`static`), nie "uczestnik rozmowy" jak reszta klas.

<svg viewBox="0 0 820 560" xmlns="http://www.w3.org/2000/svg" style="width:100%;max-width:820px;height:auto;font-family:ui-sans-serif,sans-serif;background:#f3f5f6;border:1px solid #ccd3d7;border-radius:10px;">
  <defs>
    <marker id="archArrowDashed" viewBox="0 0 10 10" refX="8" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
      <path d="M0,0 L10,5 L0,10 z" fill="#131a1f" opacity="0.7"/>
    </marker>
    <marker id="archArrowWire" viewBox="0 0 10 10" refX="8" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
      <path d="M0,0 L10,5 L0,10 z" fill="#b5651d"/>
    </marker>
  </defs>

  <!-- Main -->
  <rect x="340" y="16" width="140" height="54" rx="8" fill="#e7ebed" stroke="#131a1f" stroke-opacity="0.4"/>
  <text x="410" y="39" text-anchor="middle" font-family="ui-monospace,monospace" font-size="13" font-weight="700" fill="#131a1f">Main</text>
  <text x="410" y="56" text-anchor="middle" font-size="10" fill="#131a1f" opacity="0.65">tworzy i łączy</text>

  <!-- row2: created by Main -->
  <g stroke="#131a1f" stroke-opacity="0.55" stroke-width="1.2" stroke-dasharray="3 4" fill="none" marker-end="url(#archArrowDashed)">
    <line x1="370" y1="70" x2="125" y2="128"/>
    <line x1="400" y1="70" x2="345" y2="128"/>
    <line x1="440" y1="70" x2="655" y2="128"/>
  </g>
  <text x="410" y="90" text-anchor="middle" font-size="10" fill="#131a1f" opacity="0.6">tworzy 3 obiekty</text>

  <g font-family="ui-monospace,monospace" font-size="12">
    <rect x="30" y="130" width="190" height="64" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.45"/>
    <text x="125" y="154" text-anchor="middle" font-weight="700" fill="#131a1f">ConsoleInput</text>
    <text x="125" y="170" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.65" font-family="ui-sans-serif,sans-serif">czyta z klawiatury</text>

    <rect x="250" y="130" width="190" height="64" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.45"/>
    <text x="345" y="154" text-anchor="middle" font-weight="700" fill="#131a1f">BudgetPrinter</text>
    <text x="345" y="170" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.65" font-family="ui-sans-serif,sans-serif">wyświetlanie raportów</text>

    <rect x="560" y="130" width="220" height="64" rx="8" fill="#b5651d" fill-opacity="0.1" stroke="#b5651d" stroke-width="1.4"/>
    <text x="670" y="154" text-anchor="middle" font-weight="700" fill="#b5651d">BudgetConsoleApp</text>
    <text x="670" y="170" text-anchor="middle" font-size="9.5" fill="#b5651d" opacity="0.9" font-family="ui-sans-serif,sans-serif">steruje przepływem</text>
  </g>

  <!-- wiring: ConsoleInput / BudgetPrinter -> BudgetConsoleApp -->
  <g stroke="#b5651d" stroke-width="1.3" opacity="0.8" fill="none" marker-end="url(#archArrowWire)">
    <path d="M120,194 Q400,250 557,160"/>
    <path d="M345,194 Q460,232 557,172"/>
  </g>
  <text x="500" y="218" text-anchor="middle" font-size="10" fill="#b5651d">wstrzyknięte przez konstruktor</text>

  <!-- row3: created by BudgetConsoleApp w run() -->
  <g stroke="#131a1f" stroke-opacity="0.55" stroke-width="1.2" stroke-dasharray="3 4" fill="none" marker-end="url(#archArrowDashed)">
    <line x1="620" y1="194" x2="150" y2="262"/>
    <line x1="650" y1="194" x2="380" y2="262"/>
    <line x1="690" y1="194" x2="665" y2="262"/>
  </g>
  <text x="670" y="222" text-anchor="middle" font-size="10" fill="#131a1f" opacity="0.6">tworzy w run()</text>

  <g font-family="ui-monospace,monospace" font-size="12">
    <rect x="30" y="264" width="190" height="64" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.45"/>
    <text x="125" y="288" text-anchor="middle" font-weight="700" fill="#131a1f">Budget</text>
    <text x="125" y="304" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.65" font-family="ui-sans-serif,sans-serif">dochód, koszty, status</text>

    <rect x="250" y="264" width="220" height="64" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.45"/>
    <text x="360" y="288" text-anchor="middle" font-weight="700" fill="#131a1f">ExpenseTracker</text>
    <text x="360" y="304" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.65" font-family="ui-sans-serif,sans-serif">sumy, top kategorie 80/20</text>

    <rect x="560" y="264" width="220" height="64" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.45"/>
    <text x="670" y="288" text-anchor="middle" font-weight="700" fill="#131a1f">SavingsGoal</text>
    <text x="670" y="304" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.65" font-family="ui-sans-serif,sans-serif">jeden cel + wyliczenia</text>
  </g>

  <!-- ExpenseTracker -> ExpenseCategory (composition) -->
  <g stroke="#b5651d" stroke-width="1.3" opacity="0.8" fill="none" marker-end="url(#archArrowWire)">
    <line x1="360" y1="328" x2="360" y2="400"/>
  </g>
  <rect x="316" y="356" width="88" height="16" rx="3" fill="#f3f5f6"/>
  <text x="360" y="368" text-anchor="middle" font-size="10" fill="#b5651d">przechowuje[]</text>

  <!-- ExpenseCategory -->
  <rect x="250" y="402" width="220" height="64" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.45"/>
  <text x="360" y="426" text-anchor="middle" font-family="ui-monospace,monospace" font-size="12" font-weight="700" fill="#131a1f">ExpenseCategory</text>
  <text x="360" y="442" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.65">nazwa + kwota, equals()</text>

  <!-- MathUtils - off to the side, no arrows -->
  <rect x="600" y="412" width="180" height="56" rx="8" fill="none" stroke="#131a1f" stroke-opacity="0.35" stroke-dasharray="3 3"/>
  <text x="690" y="436" text-anchor="middle" font-family="ui-monospace,monospace" font-size="12" font-weight="700" fill="#131a1f" opacity="0.8">MathUtils</text>
  <text x="690" y="452" text-anchor="middle" font-size="9.5" fill="#131a1f" opacity="0.55">narzędzie (static)</text>
</svg>

**Main** tworzy trzy obiekty i wstrzykuje **ConsoleInput** oraz **BudgetPrinter** do **BudgetConsoleApp**. Dopiero **BudgetConsoleApp**, w swojej metodzie `run()` (po zebraniu danych od użytkownika), tworzy **Budget**, **ExpenseTracker** i (przy każdym celu) **SavingsGoal**. **ExpenseTracker** przechowuje tablicę **ExpenseCategory** — **BudgetPrinter** dostaje te obiekty jako parametry metod i je formatuje, bez trzymania ich u siebie. **MathUtils** stoi z boku — kilka klas woła jej statyczne metody, ale to nie jest obiekt, z którym się "rozmawia" jak z resztą.

*(Ta sama grafika, w wersji z obsługą dark mode, jest też w `architektura-budget-analyzer.html`.)*

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
