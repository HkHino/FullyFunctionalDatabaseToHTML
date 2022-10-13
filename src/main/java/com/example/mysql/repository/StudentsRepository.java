package com.example.mysql.repository;

import com.example.mysql.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentsRepository
{
    private Connection conn = DatabaseConnectionManager.getConnection();


    public List<Student> getAllStudents()
    {

        List<Student> students = new ArrayList<>();
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from kea.student");
            ResultSet resaultSet = psts.executeQuery();
            while (resaultSet.next())
            {
                students.add(new Student(
                        resaultSet.getInt("id"),
                        resaultSet.getString("name"),
                        resaultSet.getString("email"),
                        resaultSet.getBoolean("gender")));

            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return students;
    }

    //metode til kun at vælge en af emnerne i databasen

    public Student getStudent(int id)
    {
        try
        {
            PreparedStatement psts = conn.prepareStatement("select * from kea.student where id=?"); // spørgsmålstegnet gør vores querry dynamisk i stedet for statisk
            psts.setInt(1, id);
            ResultSet resaultSet = psts.executeQuery();

            if (resaultSet.next())
            {
                return new Student(
                        resaultSet.getInt("id"),
                resaultSet.getString("name"),
                resaultSet.getString("email"),
                resaultSet.getBoolean("gender"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null; // normalt ville den returnere en Student
    }
}
