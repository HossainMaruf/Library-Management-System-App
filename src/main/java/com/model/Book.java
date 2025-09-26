package com.model;

public class Book {
   private int id; 
   private String title;
   private String author;
   private String isbn;
   private String publishedYear;

   public Book(String title, String author, String isbn, String publishedYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
   }
   public Book(int id, String title, String author, String isbn, String publishedYear) {
        this(title, author, isbn, publishedYear);
        this.id = id;
   }
   public int getId() { return id; }
   public String getTitle() { return title; }
   public String getAuthor() { return author; }
   public String getIsbn() { return isbn; }
   public String getPublishedYear() { return publishedYear; }
   public void setTitle(String title) { this.title = title; }
   public void setAuthor(String author) { this.author = author; }
   public void setIsbn(String isbn) { this.isbn = isbn; }
   public void setPublishedYear(String publishedYear) { this.publishedYear = publishedYear; }
}
