package ksiegarnia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ExportFiles {

    private static final String CATEGORY_PATH = "C:\\Users\\niedb\\IdeaProjects\\Księgarnia\\src\\main\\resources\\categories.csv";
    private static final String AUTHOR_PATH = "C:\\Users\\niedb\\IdeaProjects\\Księgarnia\\src\\main\\resources\\authors.csv";
    private static final String BOOK_PATH = "C:\\Users\\niedb\\IdeaProjects\\Księgarnia\\src\\main\\resources\\books (2).csv";

    public void exportAllData(AuthorData authorData, CategoriesData categoriesData, BooksData booksData) {
        try {
            exportAuthorData(authorData);
            exportCategoryData(categoriesData);
            exportBookData(booksData);
        } catch (IOException e) {
            System.out.println("Błąd zapisywania danych");
        }
    }

    private void exportAuthorData(AuthorData authorData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(AUTHOR_PATH))) {
            for (String element : getAuthorsDataAsStringToExport(authorData)) {
                writer.write(element);
                writer.newLine();
            }
        }
    }

    private void exportCategoryData(CategoriesData categoriesData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CATEGORY_PATH))) {
            for (String element : getCategoryDataAsStringToExport(categoriesData)) {
                writer.write(element);
                writer.newLine();
            }
        }
    }

    private void exportBookData(BooksData booksData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_PATH))) {
            for (String element : getBookDataAsStringToExport(booksData)) {
                writer.write(element);
                writer.newLine();
            }
        }
    }

    private List<String> getAuthorsDataAsStringToExport(AuthorData authorData) {
        List<String> listToExport = new ArrayList<>();
        for (Author author : authorData.getAuthorList()) {
            StringJoiner sj = new StringJoiner(";");
            sj.add(Integer.toString(author.getAuthorId()))
                    .add(author.getName())
                    .add(Integer.toString(author.getAge()));
            listToExport.add(sj.toString());
        }
        return listToExport;
    }

    private List<String> getCategoryDataAsStringToExport(CategoriesData categoriesData) {
        List<String> listToExport = new ArrayList<>();
        for (Category category : categoriesData.getCategoriesList()) {
            StringJoiner sj = new StringJoiner(";");
            sj.add(Integer.toString(category.getCategoryId()))
                    .add(category.getName())
                    .add(Integer.toString(category.getPriorityNumber()));
            listToExport.add(sj.toString());
        }
        return listToExport;
    }

    private List<String> getBookDataAsStringToExport(BooksData booksData) {
        List<String> listToExport = new ArrayList<>();
        for (Book book : booksData.getBooksList()) {
            StringJoiner sj = new StringJoiner(";");
            sj.add(book.getTitle())
                    .add(book.getIsbn())
                    .add(Integer.toString(book.getPublicationYear()))
                    .add(book.getBookBinding())
                    .add(getAuthorsDataAsInteger(book))
                    .add(Integer.toString(book.getCategory().getCategoryId()));
            listToExport.add(sj.toString());
        }
        return listToExport;
    }

    private String getAuthorsDataAsInteger(Book book) {
        StringJoiner sj = new StringJoiner(",");
        for (Author author : book.getAuthorList()) {
            sj.add(Integer.toString(author.getAuthorId()));
        }
        return sj.toString();
    }
}
