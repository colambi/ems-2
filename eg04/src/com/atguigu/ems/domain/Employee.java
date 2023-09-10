package com.atguigu.ems.domain;

import java.io.Serializable;

/**
 * ClassName: Employee
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/7 22:17
 * @Version 1.0
 */
public class Employee implements Serializable {
    private String name;
    private int id;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(String name, int id, double salary, int age) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.age = age;
    }

    public String say(){
        return   id+
                "\t"+name+
                "\t"+age+
                "\t\t"+salary
                ;
    }
    @Override
    public String toString() {
        return id+
                "\t"+name+
                "\t"+age+
                "\t"+salary
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
