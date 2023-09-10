package com.atguigu.ems.domain;

/**
 * ClassName: Employee
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/7 22:17
 * @Version 1.0
 */
public class Employee {
    private String name;
    private String phone;
    private String email;
    private char gender;
    private int age;

    public Employee(String name, String phone, String email, char gender, int age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "name+=" + name  +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
