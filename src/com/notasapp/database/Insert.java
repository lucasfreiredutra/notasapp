package com.notasapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

//Conecta com o banco de dados
    private Connection connect() {

        String url = "jdbc:sqlite:C:/Users/lucas/IdeaProjects/NotasApp/db/student.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

//Insere aluno ao banco de dados
    public void insertStudent(int studentId, String studentFirstName,
                              String studentLastName)  {
        String sql = "INSERT INTO student (student_id, student_firstname, student_lastname) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);
            pstmt.setString(2, studentFirstName);
            pstmt.setString(3, studentLastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Os dados do aluno foram salvos.");
    }

//Insere as notas do aluno no banco de dados
    public void insertSubject(int studentId, String subjectName,
                              double grade1, double grade2, double avrgrade)  {
        String sql = "INSERT INTO subject (student_id, subject_name, grade1, grade2, avr_grade) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);
            pstmt.setString(2, subjectName);
            pstmt.setDouble(3, grade1);
            pstmt.setDouble(4, grade2);
            pstmt.setDouble(5, avrgrade);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("As notas do aluno foram salvas com sucesso.");
    }
}
