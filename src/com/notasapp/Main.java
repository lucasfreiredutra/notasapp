package com.notasapp;

import com.notasapp.database.Insert;
import com.notasapp.database.Search;
import com.notasapp.service.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scMain = new Scanner(System.in);

        printMessage("Bem vindo ao Notas app");
        printMessage("Escolha uma opção:" +
                            "\n 1 - Inserir notas do aluno" +
                            "\n 2 - Pesquisar notas do aluno");
        String answerMain = scMain.nextLine();

        if (answerMain.equals("1")) {
            newStudent();
        } else if (answerMain.equals("2")) {
            studentSearch();
        } else {
            printMessage("Obrigado!");
        }

    }

    //Método para adicionar as notas de um aluno
    public static void newStudent() {
        Scanner read = new Scanner(System.in);

        System.out.println("Inserir Id do aluno");
        int studentId = read.nextInt();

        Scanner read1 = new Scanner(System.in);

        System.out.println("Inserir primeiro nome do aluno");
        String studentFirstName = read1.nextLine();
        System.out.println("Inserir sobrenome do aluno");
        String studentLastName = read1.nextLine();

        Insert students = new Insert();
        students.insertStudent(studentId, studentFirstName, studentLastName);

        Student student = new Student(studentId, studentFirstName,
                studentLastName);
        student.studentSubject();
    }

    //Método para buscar as notas de um aluno em uma matéria
    public static void studentSearch() {
        Scanner read1 = new Scanner(System.in);

        printMessage("Qual o nome do aluno?");
        String studentName = read1.nextLine();

        Search student = new Search();
        student.studentSearch(studentName);
    }

    //Método para imprimir mensagens no prompt
    public static void printMessage(String text) {
        System.out.println(text);
    }
}
