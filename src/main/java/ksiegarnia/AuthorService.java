package ksiegarnia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorService {

    public void addAuthor(List<Author> authors, String name, int age) {
        authors.add(new Author(name, age));
    }

    public void editAuthorName(List<Author> authors, int choice, int age) {
        authors.get(choice - 1).setAge(age);
    }

    public void showAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    public void printAuthorsWithNumberOfBooks(List<Author> authorList) {
        Integer number;
        Map<Author, Integer> tempList = new HashMap<>();
        BooksData booksData = BooksData.getInstance();
        for (Author author : authorList) {
            number = countAuthorBooks(booksData, author);
            tempList.put(author, number);
        }
        System.out.println(tempList);
    }

    private Integer countAuthorBooks(BooksData booksData, Author author) {
        int number = 0;
        for (Book book : booksData.getBooksList()) {
            if (book.getAuthorList().contains(author)) {
                number++;
            }
        }
        return number;
    }
}
