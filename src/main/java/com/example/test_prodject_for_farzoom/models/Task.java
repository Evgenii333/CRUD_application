package com.example.test_prodject_for_farzoom.models;
import java.util.Date;

public class Task {
    private Long id;
    private String name;
    private String description;
    Date data = new Date();

    public Task(Long id, String name, String description, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
       // this.data = data;
    }

    public Task(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }


}


