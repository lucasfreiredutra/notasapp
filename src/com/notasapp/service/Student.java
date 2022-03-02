package com.notasapp.service;

import com.notasapp.database.Insert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    //Atributos do aluno

    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private List<SchoolSubject> subjects = new ArrayList<>();


    //Construtores do aluno
    public Student() {}

    public Student (int id, String firstName, String lastName) {
        this.studentId = id;
        this.studentFirstName = firstName;
        this.studentLastName = lastName;
    }

    //Método para retornar a Id do aluno
    public int getStudentId() {
        return studentId;
    }
    //Método para retornar o nome do aluno
    public String getName() {
        return studentFirstName + studentLastName;

    }

    //Método para inserir matéria e notas
    public void studentSubject() {
        //Cria scanner para pegar input do usuário
        Scanner sc = new Scanner(System.in);

        //Input data da matéria
        System.out.println("Inserir id do Aluno");
        int studentId = sc.nextInt();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Inserir o nome da matéria?");
        String subjectName = sc1.nextLine();
        System.out.println("Inserir nota da prova 1");
        double grade1 = sc.nextDouble();
        System.out.println("Inserir nota da prova 2");
        double grade2 = sc.nextDouble();

        this.subjects.add(new SchoolSubject(studentId, subjectName,
                grade1, grade2));



        for (int i = 0; i < subjects.size(); i++) {
            String name = subjects.get(i).getSubjectName();
            if (name.equals(subjectName)) {
                subjects.get(i).setAvrGrade();
                double avrGrade = subjects.get(i).getAvrGrade();

                Insert subject = new Insert();
                subject.insertSubject(studentId, subjectName, grade1, grade2, avrGrade);

                System.out.println("As notas do " + studentFirstName +
                        " na matéria " + subjectName +
                        " foram inseridas com sucesso");
            }
        }
    }
}
