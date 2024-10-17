package org.example;

import java.util.List;

public class Student extends University{
    private int id;
    private String name;
    private List<String> subjects;

    public Student(String name, int student_id, String uni) {
        this.name = name;
        id = student_id;
        super.university = uni;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
