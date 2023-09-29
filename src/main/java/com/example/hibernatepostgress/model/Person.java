package com.example.hibernatepostgress.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyyy")
    private Date dob;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
