package ksiegarnia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInteraction {

    private Scanner scanner = new Scanner(System.in);
    private CategoriesData categoriesData = CategoriesData.getInstance();
    private CategoryService categoryService = new CategoryService();
    private AuthorData authorData = AuthorData.getInstance();
    private AuthorService authorService = new AuthorService();
    private BooksPrinter booksPrinter = new BooksPrinter(new TitleFirstBookPrintStrategy());
    private BooksData booksData = BooksData.getInstance();
    private IdChecker idChecker = new IdChecker();

    public Book getBookInformation() {

        String title = getNewBookTitle();
        String isbn = getIsbn();
        String publicationYear = getPublicationYear();
        String bookBinding = getCover();
        List<Author> authorList = getNewBookAuthorList();
        Category category = getNewBookCategory();

        return new Book(title, isbn, Integer.parseInt(publicationYear), bookBinding.toUpperCase(), authorList, category);
    }

    public String getNewBookTitle() {
        System.out.println("Proszę podaj tytuł nowej książki albo (A) aby anulować");
        return scanner.nextLine();
    }

    public int getAuthorId() {
        authorService.showAuthors(authorData.getAuthorList());
        int id = 1000;
        System.out.println("Podaj ID autora albo (A) aby anulować");
        boolean incorrectId = true;
        while (incorrectId) {
            String idToParse = scanner.nextLine();
            if(idToParse.equalsIgnoreCase("a")){
                throw new AbortActionException();
            }
            try {
                id = Integer.parseInt(idToParse);
                idChecker.correctIdForAuthors(authorData.getAuthorList(), id);
                incorrectId = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj ID jako liczbę:");
            } catch (NoSuchIdException e) {
                System.out.println("Nie posiadamy takiego ID! Podaj jeszcze raz:");
            }
        }
        return id;
    }

    public int getNumber() {
        int choiceNumber = 1000;
        String choice = scanner.nextLine();
        try {
            choiceNumber = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return choiceNumber;
    }

    public int getYear() {
        boolean wrongYearFormat = true;
        int choiceNumber = 1000;
        System.out.println("Podaj rok:");
        while (wrongYearFormat) {
            String choice = scanner.nextLine();
            try {
                choiceNumber = Integer.parseInt(choice);
                wrongYearFormat = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj rok jako liczba:");
            }
        }
        return choiceNumber;
    }

    public String getNewRandomNameOrAbort() {
        System.out.println("Podaj nową nazwę lub naciśnij A aby anulować");
        return scanner.nextLine();
    }

    public String getNewAuthorName() {
        System.out.println("Podaj imię i nazwisko autora:");
        return scanner.nextLine();
    }

    public String getNewCategoryName() {
        categoryService.showCategories(categoriesData.getCategoriesList());
        System.out.println("Podaj nazwę nowej kategorii albo (A) aby anulować");
        String categoryName = scanner.nextLine();
        if(categoryName.equalsIgnoreCase("a")){
            throw new AbortActionException();
        }
        return categoryName;
    }

    public int getNewCategoryPriorityNumber() {
        int parsedPriorityNumber;
        System.out.println("Podaj priorytet nowej kategorii");
        while (true) {
            try {
                String priorityNumber = scanner.nextLine();
                parsedPriorityNumber = Integer.parseInt(priorityNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Podaj priorytet jako liczbę");
            }
        }
        return parsedPriorityNumber;
    }

    public int getNewAge() {
        boolean keepEditing = true;
        int parsedNewAge = 1000;
        while (keepEditing) {
            try {
                System.out.println("Podaj nowy wiek:");
                String newAge = scanner.nextLine();
                parsedNewAge = Integer.parseInt(newAge);
                keepEditing = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj wiek jako liczbę");
            }
        }
        return parsedNewAge;
    }

    public int getBookId() {
        int bookId = 1000;
        boolean incorrectId = true;
        while (incorrectId) {
            booksPrinter.showBooksForEditTitle(booksData.getBooksList());
            System.out.println("Podaj ID książki albo (A) aby anulować");
            String stringBookId = scanner.nextLine();
            if (stringBookId.equalsIgnoreCase("a")) {
                throw new AbortActionException();
            }
            try {
                bookId = Integer.parseInt(stringBookId);
                idChecker.correctIdForBooks(booksData.getBooksList(), bookId);
                incorrectId = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj ID jako liczbę");
            } catch (NoSuchIdException e) {
                System.out.println("Nie posiadamy ksiązki o takim ID");
            }
        }
        return bookId;
    }

    public int getCategoryId() {
        categoryService.showCategories(categoriesData.getCategoriesList());
        int categoryId = 1000;
        System.out.println("Podaj ID kategorii albo (A) aby anulować");
        boolean incorrectId = true;
        while (incorrectId) {
            String categoryIdString = scanner.nextLine();
            if (categoryIdString.equalsIgnoreCase("a")) {
                throw new AbortActionException();
            }
            try {
                categoryId = Integer.parseInt(categoryIdString);
                idChecker.correctIdForCategories(categoriesData.getCategoriesList(), categoryId);
                incorrectId = false;
            } catch (NumberFormatException e) {
                System.out.println("Podaj ID jako liczbę:");
            } catch (NoSuchIdException e) {
                System.out.println("Nie posiadamy takiego ID! Podaj jeszcze raz:");
            }
        }
        return categoryId;
    }

    private String getIsbn() {
        System.out.println("Podaj isbn:");
        return scanner.nextLine();
    }

    private String getPublicationYear() {
        System.out.println("Podaj rok wydania:");
        return scanner.nextLine();
    }

    private String getCover() {
        System.out.println("Podaj rodzaj okładki");
        return scanner.nextLine();
    }

    private String decideToAddNextAuthor() {
        String choice;
        while (true) {
            System.out.println("Wciśnij (A) żeby dodać autora z listy lub (Z) żeby zakończyć dodawanie");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("z")) {
                break;
            }
        }
        return choice;
    }

    private Category getNewBookCategory() {
        int choice = getCategoryId();
        return categoriesData.getCategoriesList().get(choice - 1);
    }

    private List<Author> getNewBookAuthorList() {
        List<Author> authorList = new ArrayList<>();
        boolean keepAddingAuthor = true;
        while (keepAddingAuthor) {
            String choice = decideToAddNextAuthor();
            switch (choice.toLowerCase()) {
                case "a":
                    authorList.add(getAuthorFromList());
                    break;
                case "z":
                    keepAddingAuthor = false;
                    break;
                default:
                    System.out.println("Zły wybór");
            }
        }
        return authorList;
    }

    private Author getAuthorFromList() {
        int choice = getAuthorId();
        return authorData.getAuthorList().get(choice - 1);
    }
}
