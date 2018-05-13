package ksiegarnia;

import java.util.List;

public class IdChecker {

    public void correctIdForBooks(List<Book> books, int choice) {
        if (choice < 1 || (choice - 1) >= books.size())
            throw new NoSuchIdException();
    }

    public void correctIdForAuthors(List<Author> authors, int choice) {
        if (choice < 1 || (choice - 1) >= authors.size())
            throw new NoSuchIdException();
    }

    public void correctIdForCategories(List<Category> categories, int choice) {
        if (choice < 1 || (choice - 1) >= categories.size())
            throw new NoSuchIdException();
    }

}
