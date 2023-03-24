package com.paradigms.cs;
public class Student
{
    public String name;
    public int computerNumber;
    

    public Student(String name,int comp)
    {
        this.name = name;
        this.computerNumber = comp;
    }

    
    public String toString()
    {
        return name;
    }
}