package com.dunky.in21hours.entities;

public class Person{
    private long id;
    private String name;
    private String location;

    // Constructor
    public Person(long id, String name, String location) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getter methods
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // To string  method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + location + '\'' +
                '}';
    }
}
