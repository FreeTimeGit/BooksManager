package ksiegarnia;

import java.util.List;

public class BooksPrinter {

    private BookPrinterStrategy bookPrinterStrategy;

    public BooksPrinter(BookPrinterStrategy bookPrinterStrategy) {
        this.bookPrinterStrategy = bookPrinterStrategy;
    }

    public void setBookPrinterStrategy(BookPrinterStrategy bookPrinterStrategy) {
        this.bookPrinterStrategy = bookPrinterStrategy;
    }

    public void showAllBooks(List<Book> books) {
        bookPrinterStrategy.print(books);
    }

    public void showBooksForEditTitle(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". "
                    + books.get(i).getTitle() + " "
                    + books.get(i).getAuthorList() + " "
                    + books.get(i).getCategory().getName());
        }
    }
}
