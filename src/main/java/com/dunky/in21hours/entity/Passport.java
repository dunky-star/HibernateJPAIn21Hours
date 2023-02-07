package com.dunky.in21hours.entity;

import javax.persistence.*;

@Entity
@Table(name="passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    protected Passport() {
    }
    public Passport(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
