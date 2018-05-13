package ksiegarnia;

public class MenuPrinter {

    public void printMenu() {
        System.out.println();
        System.out.println("----Księgarnia----");
        System.out.println("1. EXIT");
        System.out.println("2. Wyświetl kontakt");
        System.out.println("3. Wybierz sposób wyświetlania");
        System.out.println("4. Wyświetl książki wg:");
        System.out.println("5. Wyświetl autorów");
        System.out.println("6. Wyświetl kategorie");
        System.out.println("7. Opcje edycji");
        System.out.println("8. Exportuj dane");
        System.out.println();
    }

    public void printBookShowingMenu() {
        System.out.println("1. Tytuł pierwszy");
        System.out.println("2. Rok wydania pierwszy");
        System.out.println("3. Isbn pierwszy");
    }

    public void printBookSortingMenu() {
        System.out.println("1. Wyświetl ksiązki wydane przed wybranym rokiem");
        System.out.println("2. Wyświetl ksiązki posortowane wg roku rosnąco");
        System.out.println("3. Wyświetl ksiązki posortowane wg roku malejąco");
        System.out.println("4. Wyświetl ksiązki z kategorii wzorce projektowe");
        System.out.println("5. Wyświetl ksiązki dla danego autora");
        System.out.println("6. Wyświetl ksiązki dla danej kategorii");
        System.out.println("7. Powrót do głównego menu");
    }

    public void printEditMenu() {
        System.out.println("1. Dodaj autora");
        System.out.println("2. Edytuj nazwę ksiązki");
        System.out.println("3. Edytuj wiek autora");
        System.out.println("4. Dodaj nową kategorię");
        System.out.println("5. Edytuj nazwę kategorii");
        System.out.println("6. Dodanie nowej ksiązki");
        System.out.println("7. Usuwanie ksiązki/autora/categorii");
        System.out.println("8. Powrót do głównego menu");
    }

    public void printDeleteMenu() {
        System.out.println("1. Usuń autora");
        System.out.println("2. Usuń kategorię");
        System.out.println("3. Usuń książkę");
        System.out.println("4. Powrót do głównego menu");
    }
}
