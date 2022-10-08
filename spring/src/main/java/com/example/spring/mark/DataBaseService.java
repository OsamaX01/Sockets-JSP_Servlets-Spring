package com.example.spring.mark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataBaseService {
    private JdbcTemplate jdbc;

    @Autowired
    public DataBaseService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public boolean isValidStudent(int studentId) {
        final String SQL = "select password from STUDENTS where id=" + studentId;
        int size = jdbc.query(SQL, new PasswordRowMapper()).size();
        return (size > 0);
    }

    public boolean isValidPassword(int studentId, String password) {
        final String SQL = "select password from STUDENTS where id=" + studentId;
        String correctPassword = jdbc.query(SQL, new PasswordRowMapper()).get(0);
        return correctPassword.equals(password);
    }

    public ArrayList<Mark> getAllStudentMarks(int studentId)  {
        final String SQL = "select cpp_mark, java_mark, ruby_mark from MARKS where id=" + studentId;
        ArrayList<Mark> courses = jdbc.query(SQL, new MarksRowMapper()).get(0);
        return courses;
    }

    public Mark getStudentMark(int studentId, String courseName)  {
        final String SQL = "select " + courseName + "_mark from MARKS where id=" + studentId;
        Double mark = jdbc.query(SQL, new MarkRowMapper()).get(0);
        return new Mark(courseName, mark);
    }

    public Mark getAverage(String courseName) {
        final String SQL = "select AVG(" + courseName + "_mark) from MARKS";
        Double mark = jdbc.query(SQL, new MarkRowMapper()).get(0);
        return new Mark(courseName, mark);
    }

    public Mark getMax(String courseName) {
        final String SQL = "select MAX(" + courseName + "_mark) from MARKS";
        Double mark = jdbc.query(SQL, new MarkRowMapper()).get(0);
        return new Mark(courseName, mark);
    }

    public Mark getMin(String courseName) {
        final String SQL = "select MIN(" + courseName + "_mark) from MARKS";
        Double mark = jdbc.query(SQL, new MarkRowMapper()).get(0);
        return new Mark(courseName, mark);
    }
}
