package com.notasapp.service;

import com.notasapp.database.Insert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private List<SchoolSubject> subjectList = new ArrayList<>();

//CONSTRUTORES
    public Student() {}

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public Student(int studentId, String firstName, String lastName) {
        this(studentId);
        this.studentFirstName = firstName;
        this.studentLastName = lastName;
    }


//MÉTODOS

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getName() {
        return studentFirstName + " " + studentLastName;

    }

    public void addSubject() {
        System.out.println("Matriculando o aluno em uma matéria");
        Scanner sc = new Scanner(System.in);
        System.out.println("Matéria");
        String subjectName = sc.nextLine();
        subjectList.add(new SchoolSubject(studentId, subjectName));
    }

    public void addGradesToSubject() {
        System.out.println("Inserindo as notas no banco de dados");
        Scanner reader = new Scanner(System.in);
        System.out.println("Matéria");
        String subjectName = reader.nextLine();
        System.out.println("Prova 1");
        double grade1 = reader.nextDouble();
        System.out.println("Prova 2");
        double grade2 = reader.nextDouble();

        for(int i = 0; i < subjectList.size(); i++) {
            if(subjectName.equals(subjectList.get(i).getSubjectName())) {
                subjectList.get(i).setGrade1(grade1);
                subjectList.get(i).setGrade2(grade2);
                subjectList.get(i).setAvrGrade();

                Insert subject = new Insert();
                subject.insertSubject(studentId,subjectList.get(i).getSubjectName(), subjectList.get(i).getGrade1(),
                        subjectList.get(i).getGrade2(), subjectList.get(i).getAvrGrade());
            }
        }
    }


}
