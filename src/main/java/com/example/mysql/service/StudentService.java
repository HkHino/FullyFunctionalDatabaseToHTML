package com.example.mysql.service;

import com.example.mysql.model.Student;
import com.example.mysql.repository.StudentsRepository;

import java.util.List;

public class StudentService
{
    StudentsRepository repo = new StudentsRepository();

    public List<Student> getAllStudents(){
        return repo.getAllStudents();
    }

    public Student getStudent(int id)
    {
        return repo.getStudent(id);
    }
}
