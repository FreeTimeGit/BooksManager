package ksiegarnia;

public class BookSortingMenu {

    private MenuPrinter menuPrinter = new MenuPrinter();
    private UserInteraction userInteraction = new UserInteraction();
    private BooksPrinter booksPrinter = new BooksPrinter(new TitleFirstBookPrintStrategy());
    private BooksFunctions booksFunctions = new BooksFunctions();
    private BooksData booksData = BooksData.getInstance();

    public void bookShowingMenuManager() {
        menuPrinter.printBookShowingMenu();
        int choiceNumber = userInteraction.getNumber();
        switch (choiceNumber) {
            case 1:
                booksPrinter.setBookPrinterStrategy(new TitleFirstBookPrintStrategy());
                break;
            case 2:
                booksPrinter.setBookPrinterStrategy(new YearFirstBookPrintStrategy());
                break;
            case 3:
                booksPrinter.setBookPrinterStrategy(new IsbnFirstBookPrintStrategy());
                break;
            default:
                System.out.println("Błąd podczas zmiany spospobu wyświetlania");
        }
    }

    public void bookSortingMenuManager() {
        boolean exit = false;
        while (!exit) {
            menuPrinter.printBookSortingMenu();
            int choice = userInteraction.getNumber();
            switch (choice) {
                case 1:
                    choice = userInteraction.getYear();
                    booksPrinter.showAllBooks(booksFunctions.getBooksPublishedBeforeYear(booksData.getBooksList(), choice));
                    break;
                case 2:
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByYearIncreasing(booksData.getBooksList()));
                    break;
                case 3:
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByYearDecreasing(booksData.getBooksList()));
                    break;
                case 4:
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByWzorceProjektowe(booksData.getBooksList()));
                    break;
                case 5:
                    int authorId = userInteraction.getAuthorId();
                    booksPrinter.showAllBooks(booksFunctions.sortBookByAuthor(booksData.getBooksList(), authorId));
                    break;
                case 6:
                    int categoryId = userInteraction.getCategoryId();
                    booksPrinter.showAllBooks(booksFunctions.sortBooksByCategory(booksData.getBooksList(), categoryId));
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Niewłaściwy wybór");
            }
        }
    }
}