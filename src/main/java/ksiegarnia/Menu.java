package ksiegarnia;

import ksiegarnia.template.HardCoverOrderReprint;
import ksiegarnia.template.OrderReprint;
import ksiegarnia.template.SoftCoverOrderReprint;

public class Menu {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.menuManager();

    }

    private MenuPrinter menuPrinter = new MenuPrinter();
    private BookSortingMenu bookSortingMenu = new BookSortingMenu();
    private EditMenu editMenu = new EditMenu();
    private BooksData booksData = BooksData.getInstance();
    private AuthorData authorData = AuthorData.getInstance();
    private CategoriesData categoriesData = CategoriesData.getInstance();
    private ImportFiles importFiles = new ImportFiles();
    private ExportFiles exportFiles = new ExportFiles();
    private AuthorService authorService = new AuthorService();
    private CategoryService categoryService = new CategoryService();
    private UserInteraction userInteraction = new UserInteraction();
    private static final String WRONGCHOICE = "Niewłaściwy wybór";


    private void menuManager() {

        authorData.setAuthorList(importFiles.importAuthors());
        categoriesData.setCategoriesList(importFiles.importCategories());
        booksData.setBooksList(importFiles.importBooks());

        while (true) {
            menuPrinter.printMenu();
            int choiceNumber = userInteraction.getNumber();
            switch (choiceNumber) {
                case 1:
                    return;
                case 2:
                    System.out.println("księgarnia@o2.pl");
                    break;
                case 3:
                    bookSortingMenu.bookShowingMenuManager();
                    break;
                case 4:
                    bookSortingMenu.bookSortingMenuManager();
                    break;
                case 5:
                    authorService.showAuthors(authorData.getAuthorList());
                    break;
                case 6:
                    categoryService.showCategories(categoriesData.getCategoriesList());
                    break;
                case 7:
                    editMenu.editingOptionManager();
                    break;
                case 8:
                    exportFiles.exportAllData(authorData, categoriesData, booksData);
                    break;
                case 11:
                    Book book = booksData.getBooksList().get(1);
                    OrderReprint orderReprint;
                    if (book.getBookBinding().equalsIgnoreCase("m")) {
                        orderReprint = new SoftCoverOrderReprint();
                    } else {
                        orderReprint = new HardCoverOrderReprint();
                    }
                    orderReprint.orderReprint();
                    break;
                default:
                    System.out.println(WRONGCHOICE);
            }
        }
    }
}