package com.notasapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SchoolSubject {
    //Cada matéria tem uma lista de objeto alunos

    //Atributos da matéria
    private int studentId;
    private String subjectName;
    private double grade1;
    private double grade2;
    private double avrgrade = (grade1 + grade2)/2;


    //Construtores da matéria
    public SchoolSubject() {}

    public SchoolSubject(int studentId, String subjectName,
                         double grade1, double grade2) {
        this.studentId = studentId;
        this.subjectName = subjectName;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public void setAvrGrade() {
        avrgrade = (grade1 + grade2)/2;
    }
    public double getAvrGrade() {
        return avrgrade;
    }
    public String getSubjectName() {
        return subjectName;
    }
}
