package com.notasapp;

import com.notasapp.database.Insert;
import com.notasapp.database.Search;
import com.notasapp.service.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        programStart();

    }

//Começa o programa
    public static void programStart() {
        Scanner scMain = new Scanner(System.in);

        printMessage("Bem vindo ao Notas app");
        printMessage("Escolha uma opção:" +
                "\n 1 - Inserir notas de um novo aluno" +
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

//Cria aluno
    public static void newStudent() {
        printMessage("ID do aluno");
        Scanner readerNewStudent = new Scanner(System.in);
        int studentId = readerNewStudent.nextInt();
        printMessage("Primeiro nome e Sobrenome");
        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        String[] parts = studentName.split(" ");

        Student student = new Student(studentId, parts[0], parts[1]);

        Insert newStudent = new Insert();
        newStudent.insertStudent(studentId, parts[0], parts[1]);

        student.addSubject();
        scanner.nextLine();
        student.addGradesToSubject();

    }

//Adiciona matéria e notas a um aluno já existente no banco de dados
    public static void addSubjectToStudent(); {

    }


//Busca notas do aluno em uma matéria
    public static void studentSearch() {
        Scanner read1 = new Scanner(System.in);

        printMessage("Qual o nome do aluno?");
        String studentName = read1.nextLine();

        Search student = new Search();
        student.studentSearch(studentName);
    }

//Imprime mensagens no prompt
    public static void printMessage(String text) {
        System.out.println(text);
    }
}
