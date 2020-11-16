package ru.geekbrains.java.lesson5;
/**
 * Class for storing employee data
 * @author Sergey Somkov
 * @version 1.0
 */
public class Employee {

    private String firstName;
    private String lastName;
    private String surName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String firstName, String lastName, String surName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
    }

    public Employee(String firstName, String lastName, String surName, String position, String email, String phone, double salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
