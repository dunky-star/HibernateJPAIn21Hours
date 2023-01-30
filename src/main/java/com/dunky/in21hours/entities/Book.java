package com.dunky.in21hours.entities;

public class Book {
    private long id;
    private String name;
    private String author;

    // Constructor
    public Book(long id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
    }

    // Getter methods
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    // To string  method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
