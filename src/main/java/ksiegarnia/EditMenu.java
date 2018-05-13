package ksiegarnia;

import java.util.Scanner;

public class EditMenu {

    private static final String WRONGCHOICE = "Niewłaściwy wybór";
    private Scanner scanner = new Scanner(System.in);
    private UserInteraction userInteraction = new UserInteraction();
    private MenuPrinter menuPrinter = new MenuPrinter();
    private BooksFunctions booksFunctions = new BooksFunctions();
    private BooksData booksData = BooksData.getInstance();
    private AuthorData authorData = AuthorData.getInstance();
    private CategoriesData categoriesData = CategoriesData.getInstance();
    private CategoryService categoryService = new CategoryService();
    private AuthorService authorService = new AuthorService();

    public void editingOptionManager() {
        boolean exit = false;
        while (!exit) {
            menuPrinter.printEditMenu();
            int choice = userInteraction.getNumber();
            switch (choice) {
                case 1:
                    addingAuthorManager();
                    break;
                case 2:
                    editingBookTitleManager();
                    break;
                case 3:
                    editingAuthorAgeManager();
                    break;
                case 4:
                    addingNewCategoryManager();
                    break;
                case 5:
                    editingCategoryManager();
                    break;
                case 6:
                    addingBookManager();
                    break;
                case 7:
                    deletingManager();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println(WRONGCHOICE);
            }
        }
    }

    private void deletingManager() {
        while (true) {
            menuPrinter.printDeleteMenu();
            int choice = userInteraction.getNumber();
            switch (choice) {
                case 1:
                    deletingAuthorManager();
                    break;
                case 2:
                    deletingCategoryManager();
                    break;
                case 3:
                    deletingBookManager();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Zły wybór");
            }
        }
    }

    private void deletingBookManager() {
        try {
            int bookId = userInteraction.getBookId();
            booksData.getBooksList().remove(bookId - 1);
        } catch (AbortActionException e) {
            e.getMessage();
        }
    }

    private void deletingCategoryManager() {
        try {
            int categoryId = userInteraction.getCategoryId();
            categoriesData.getCategoriesList().remove(categoryId - 1);
        } catch (AbortActionException e) {
            e.getMessage();
        }
    }

    private void deletingAuthorManager() {
        try {
            int authorId = userInteraction.getAuthorId();
            authorData.getAuthorList().remove(authorId - 1);
        } catch (AbortActionException e) {
            e.getMessage();
        }
    }

    private void addingBookManager() {
        try {
            Book book = userInteraction.getBookInformation();
            booksData.getBooksList().add(book);
        } catch (AbortActionException e) {
            e.getMessage();
        }

    }

    private void editingCategoryManager() {
        try {
            int categoryId = userInteraction.getCategoryId();
            String newCategory = userInteraction.getNewCategoryName();
            if (newCategory.equalsIgnoreCase("a"))
                return;
            categoryService.editCategoryName(newCategory, categoryId);
        } catch (AbortActionException e) {
            e.getMessage();
        }
    }

    private void addingNewCategoryManager() {
        try {
            String newCategory = userInteraction.getNewCategoryName();
            int priorityNumber = userInteraction.getNewCategoryPriorityNumber();
            categoryService.addNewCategory(newCategory, priorityNumber);
        } catch (AbortActionException e) {
            e.getMessage();
        }
    }

    private void editingAuthorAgeManager() {
        try {
            int authorID = userInteraction.getAuthorId();
            int parsedNewAge = userInteraction.getNewAge();
            authorService.editAuthorName(authorData.getAuthorList(), authorID, parsedNewAge);
        } catch (AbortActionException e) {
            e.getMessage();
        }
    }

    private void editingBookTitleManager() {
        int bookId = userInteraction.getBookId();
        String newTitle = userInteraction.getNewBookTitle();
        if (newTitle.equalsIgnoreCase("a"))
            return;
        booksFunctions.editBookTitle(booksData.getBooksList(), bookId, newTitle);
    }

    private void addingAuthorManager() {
        int ageParsed = 0;
        boolean addAuthor = true;
        String name = userInteraction.getNewAuthorName();
        while (true) {
            System.out.println("Podaj wiek autora albo naciśnij A, aby anulować dodawanie");
            String age = scanner.nextLine();
            if (age.equalsIgnoreCase("a")) {
                addAuthor = false;
                break;
            }
            try {
                ageParsed = Integer.parseInt(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Zły format!");
            }
        }
        if (addAuthor) {
            authorService.addAuthor(authorData.getAuthorList(), name, ageParsed);
        }
    }
}