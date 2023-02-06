package com.dunky.in21hours.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="find_all_students", query="select p from Student p")
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;
    @Column(name="birth_date")
    private Date birthDate;

    // Default constructor
    public Student() {
    }

    // parametrized Constructor
    public Student(long id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Student(String name, String location, Date birthDate) {
        super();
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
        return "Student{\r\n " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
