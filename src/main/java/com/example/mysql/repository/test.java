package com.example.mysql.repository;

public class test
{
    public static void main(String[] args)
    {
        StudentsRepository repo = new StudentsRepository();

        //System.out.println(repo.getAllStudents());
        System.out.println(repo.getStudent(2));
    }
}
