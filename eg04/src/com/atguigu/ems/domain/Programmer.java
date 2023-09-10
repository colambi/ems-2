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
    private int eId;//设备id 根据is 获取设备对象 从文件生成对象地址不对 不与列表关联
    private transient Equipment equipment; //transient 反序列化

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

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
        this.eId=equipment.getId();
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return   super.say()+"\t 程序员"+"\t "+equipment.toString2();
    }
}
