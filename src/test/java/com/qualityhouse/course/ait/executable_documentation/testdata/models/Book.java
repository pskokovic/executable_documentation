package com.qualityhouse.course.ait.executable_documentation.testdata.models;

public class Book {
    private String title;
    private String category;
    private String author;
    private String publisher;
    private String isbn;
    private String price;
    private String productId;

    // Private constructor
    private Book() {}

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    // Inner Builder class
    public static class BookBuilder {
        private String title;
        private String category;
        private String author;
        private String publisher;
        private String isbn;
        private String price;
        private String productId;

        // Builder methods
        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        public BookBuilder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        // Build method to create a Book object
        public Book build() {
            Book book = new Book();
            book.title = this.title;
            book.category = this.category;
            book.author = this.author;
            book.publisher = this.publisher;
            book.isbn = this.isbn;
            book.price = this.price;
            book.productId = this.productId;
            return book;
        }
    }
}
