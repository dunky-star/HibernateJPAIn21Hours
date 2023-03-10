package com.dunky.in21hours.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses",
                query = "Select  c  From Course c"),
        @NamedQuery(name = "query_get_all_courses_join_fetch",
                query = "Select  c  From Course c JOIN FETCH c.students s")})
public class Course {

    private static Logger LOGGER = LoggerFactory.getLogger(Course.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name="lastUpdated")
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @Column(name="createdDate")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @Column(name="is_deleted")
    private boolean isDeleted;

    protected Course() {
    }
    public Course(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Long getId() {
        return id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @PreRemove
    private void preRemove(){
        LOGGER.info("Setting isDeleted to True");
        this.isDeleted = true;
    }
    @Override
    public String toString() {
        return String.format("\r\n Course[%s]", name);
    }


}
