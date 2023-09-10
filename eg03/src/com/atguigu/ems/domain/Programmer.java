package com.atguigu.ems.domain;

/**
 * ClassName: Programmer
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/8 23:54
 * @Version 1.0
 */
public class Programmer extends Employee{
    private Equipment equipment;
    public Programmer() {
    }

    public Programmer(String name, int id, double salary, int age,Equipment equipment) {
        super(name, id, salary, age);
        this.equipment=equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return   super.say()+"\t 程序员"+"\t "+equipment.toString2();
    }
}
