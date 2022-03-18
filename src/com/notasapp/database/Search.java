package com.notasapp.database;

import com.notasapp.service.Student;

import java.sql.*;

public class Search {

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

//Busca notas do aluno em uma matéria
        public void studentSearch(String nome) {

            String sql = "SELECT student_firstname, student_lastname ,subject_name, grade1, grade2, avr_grade" +
            " FROM student" +
            " INNER JOIN subject" +
            " ON subject.student_id = student.student_id" +
            " WHERE student_firstname = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, nome);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    System.out.println("Aluno: " + rs.getString("student_firstname") +  "\n" +
                            "Sobrenome: "  + rs.getString("student_lastname") + "\n" +
                            "Matéria: "  + rs.getString("subject_name") + "\n" +
                            "Nota 1: " + rs.getDouble("grade1") + "\n" +
                            "Nota 2: " + rs.getDouble("grade2") + "\n" +
                            "Média: " + rs.getDouble("avr_grade") + "\n");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

//Quantas matérias o aluno está matriculado
        public void whatSubject(int studentId) {
            String sql = "SELECT student_id, subject_name, avr_grade FROM subject WHERE subject.student_id = ?";


            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, studentId);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    System.out.println("Aluno ID: " + rs.getInt("student_id") +  "\n" +
                            "Matéria: "  + rs.getString("subject_name") + "\n" +
                            "Média: " + rs.getDouble("avr_grade"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}

