package com.dunky.in21hours.entity;

import java.util.Date;


public class Person{
    private long id;
    private String name;
    private String location;

    private Date birthDate;

    // Default constructor
    public Person() {
    }

    // parametrized Constructor
    public Person(long id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
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

    public Date getBirth_date() {
        return birthDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // To string  method
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
