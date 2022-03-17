package com.notasapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SchoolSubject {
    private int studentId;
    private String subjectName;
    private double grade1;
    private double grade2;
    private double avrgrade = (grade1 + grade2)/2;

//CONSTRUTORES
    public SchoolSubject() {}

    public SchoolSubject(int studentId) {
        this.studentId = studentId;
    }

    public SchoolSubject(int studentId, String subjectName) {
        this(studentId);
        this.subjectName = subjectName;
    }

    public SchoolSubject(int studentId, String subjectName,
                         double grade1, double grade2) {
        this(studentId);
        this.subjectName = subjectName;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

//MÉTODOS

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setAvrGrade() {
        avrgrade = (grade1 + grade2)/2;
    }

    public double getAvrGrade() {
        return avrgrade;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
