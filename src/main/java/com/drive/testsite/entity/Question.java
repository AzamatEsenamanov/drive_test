package com.drive.testsite.entity;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    // ✅ Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ Getter and Setter for text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // ✅ Getter and Setter for test
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
