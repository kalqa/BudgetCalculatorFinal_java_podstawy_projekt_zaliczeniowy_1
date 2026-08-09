# Zadanie praktyczne: Mini System Bankowy

## Cel

Zbuduj prosty system zarządzania kontami bankowymi, który wykorzysta wszystko, czego nauczyłeś/aś się w tym module: klasy i obiekty, enkapsulację, konstruktory, gettery/settery, metody prywatne, stałe `final`, oraz podstawową obsługę wyjątków.

## Wymagania funkcjonalne

Program konsolowy z menu, które pozwala:

1. **Utworzyć nowe konto** (imię i nazwisko właściciela + saldo początkowe)
2. **Wpłacić pieniądze** na wybrane konto
3. **Wypłacić pieniądze** z wybranego konta
4. **Wyświetlić stan** wybranego konta
5. **Wyświetlić wszystkie konta**
6. **Zmienić właściciela** wybranego konta
7. **Zakończyć** program

Program działa w pętli, dopóki użytkownik nie wybierze wyjścia.

## Reguły biznesowe

Te zasady mają realny wpływ na kod — każda z nich powinna dać się "złamać" w prosty sposób, jeśli o niej zapomnisz, a program ma się przed tym bronić:

**Zakładanie konta**
- Saldo początkowe nie może być ujemne. Jeśli użytkownik poda ujemną kwotę, konto **nie powstaje** i program pokazuje komunikat błędu.
- Każde konto dostaje unikalny, rosnący numer (1, 2, 3...), nadawany automatycznie — użytkownik go nie wpisuje.
- System pamięta, ile kont zostało utworzonych **w sumie od startu programu** (licznik statyczny, wspólny dla wszystkich obiektów klasy).

**Wpłata (`deposit`)**
- Kwota wpłaty musi być większa od zera. Wpłata `0` albo kwoty ujemnej jest odrzucana z komunikatem błędu, a saldo się nie zmienia.
- Nie ma górnego limitu wpłaty.

**Wypłata (`withdraw`)**
- Kwota wypłaty musi być większa od zera — tak samo jak przy wpłacie.
- Nie można wypłacić więcej, niż wynosi aktualne saldo konta (saldo nie może spaść poniżej `0`).
- Jednorazowa wypłata nie może przekroczyć limitu **10 000 zł** — to osobna zasada od "brak pokrycia": nawet mając 50 000 zł na koncie, nie można wypłacić więcej niż 10 000 zł za jednym razem.
- Każda z tych trzech reguł (kwota > 0, wystarczające środki, limit jednorazowej wypłaty) powinna dawać **inny, konkretny komunikat błędu** — użytkownik ma wiedzieć, co dokładnie poszło nie tak.

**Zmiana danych właściciela**
- Imię i nazwisko właściciela można zmienić, ale nie może być puste ani składać się z samych spacji.

**Ogólnie**
- Żadna z powyższych walidacji nie powinna wywalać programu (żadnych nieobsłużonych wyjątków) — w razie błędnych danych program pokazuje komunikat i wraca do menu.

## Wymagania techniczne (na czym będziesz oceniany)

- [ ] Klasa `BankAccount` ma **wszystkie pola prywatne** (`private`) — żadnego bezpośredniego dostępu z zewnątrz
- [ ] Konstruktor przyjmuje dane i używa `this.` tam, gdzie parametr nazywa się tak samo jak pole
- [ ] Są **gettery** dla danych, które mają być tylko do odczytu (np. numer konta, właściciel, saldo)
- [ ] **Nie ma** publicznego settera dla salda — saldo zmienia się **tylko** przez metody `deposit()` i `withdraw()`, które **walidują** dane (np. nie można wpłacić/wypłacić kwoty ujemnej, nie można wypłacić więcej niż jest na koncie)
- [ ] Jest przynajmniej jedna **metoda prywatna**, która chowa logikę pomocniczą (np. walidację) przed metodami publicznymi
- [ ] Jest przynajmniej jedna stała `final` (np. minimalne saldo, limit wypłaty) nazwana `WIELKIMI_LITERAMI`
- [ ] Jest **statyczne pole** liczące, ile kont zostało utworzonych w sumie (i statyczna metoda/getter, żeby to sprawdzić)
- [ ] Klasa nadpisuje `toString()`, żeby ładnie wypisywać stan konta
- [ ] Program **nie wybucha** gdy użytkownik wpisze literki zamiast liczby (`NumberFormatException`) ani gdy poda nieistniejący numer konta (`IndexOutOfBoundsException` / sprawdzenie zakresu)
- [ ] Tablica kont jest zainicjalizowana poprawnie — program nie wywala `NullPointerException` przy próbie wyświetlenia pustych slotów

## Podpowiedź do przemyślenia przed kodowaniem

Zastanów się, zanim zaczniesz pisać kod:

1. Dlaczego `balance` nie powinno mieć zwykłego settera typu `setBalance(double balance)`? Co by się mogło stać, gdyby ktoś taki setter miał?
2. Gdzie sensowniej umieścić walidację kwoty (>0) — bezpośrednio w `deposit()`/`withdraw()`, czy w osobnej metodzie prywatnej wywoływanej przez obie? Dlaczego?
3. Jak sprawdzisz, czy dany slot w tablicy kont jest jeszcze pusty (nikt tam jeszcze nie założył konta)?

---

*Poniżej znajduje się przykładowe rozwiązanie. Spróbuj najpierw zrobić zadanie samodzielnie — porównanie z gotowym rozwiązaniem ma sens dopiero, gdy Twój kod działa (albo utknąłeś/aś na dobre).*