package com.qualityhouse.course.ait.executable_documentation.testdata;

import com.qualityhouse.course.ait.executable_documentation.testdata.models.Book;

import java.util.HashMap;

public class BooksTestData {

    private static HashMap<String, Book> books = new HashMap<>();

    private static HashMap<String, String> booksCategories = new HashMap<>();

    static {
        /* list all books' categories */
        booksCategories.put("Art", "books-art");
        booksCategories.put("Biographies", "books-biographies");
        booksCategories.put("Children’s books", "books-childrens");
        booksCategories.put("Finance", "books-finance");
        booksCategories.put("Computers", "books-computers");
        booksCategories.put("Cooking, food & wine", "books-cooking-food-wine");
        booksCategories.put("Entertainment", "books-entertainment");
        booksCategories.put("Mind & body", "books-mind-body");
        booksCategories.put("History", "books-history");
        booksCategories.put("Hobbies", "books-hobbies");
        booksCategories.put("Home & garden", "books-home-garden");
        booksCategories.put("Horror", "books-horror");
        booksCategories.put("Literature & fiction", "books-literature-fiction");
        booksCategories.put("Mystery & thrillers", "books-mystery-thrillers");
        booksCategories.put("Non-fiction", "books-non-fiction");
        booksCategories.put("Professional & technical", "books-professional-technical");
        booksCategories.put("Reference", "books-reference");
        booksCategories.put("Religion & spirituality", "books-religion-spirituality");
        booksCategories.put("Sports & outdoors", "books-sports-outdoors");
        booksCategories.put("Travel", "books-travel");
        booksCategories.put("Science & nature", "books-science-nature");
        booksCategories.put("Science fiction", "books-science-fiction");

        // Populate books using the builder pattern
        books.put("Autumn Colors", new Book.BookBuilder()
                .setTitle("Autumn Colors")
                .setCategory("Art")
                .setAuthor("Diana Jones")
                .setPublisher("Nature Books Ltd.")
                .setIsbn("55134124")
                .setPrice("12.99")
                .setProductId("6")
                .build());

        books.put("Yellow Flower Songs", new Book.BookBuilder()
                .setTitle("Yellow Flower Songs")
                .setCategory("Children’s books")
                .setAuthor("Lilly Penny")
                .setPublisher("Little World")
                .setIsbn("622513423")
                .setPrice("4.99")
                .setProductId("8")
                .build());

        books.put("Agile Technologies", new Book.BookBuilder()
                .setTitle("Agile Technologies")
                .setCategory("Computers")
                .setAuthor("William Nelson")
                .setPublisher("Bit")
                .setIsbn("5628423724")
                .setPrice("23.49")
                .setProductId("12")
                .build());
    }

    /* Books' categories actions */
    public static String getBooksCategoryURLParameter(String category) {
        return booksCategories.get(category);
    }

    /* Books' actions */
    public static String getBookCategory(String title) {
        return books.get(title).getCategory();
    }

    public static String getBookAuthor(String title) {
        return books.get(title).getAuthor();
    }

    public static String getBookPublisher(String title) {
        return books.get(title).getPublisher();
    }

    public static String getBookISBN(String title) {
        return books.get(title).getIsbn();
    }

    public static String getBookPrice(String title) {
        return books.get(title).getPrice();
    }

    public static String getBookProductId(String title) {
        return books.get(title).getProductId();
    }
}