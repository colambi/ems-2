package com.atguigu.ems.domain;

/**
 * ClassName: Architect
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/8 23:56
 * @Version 1.0
 */
public class Architect extends Designer{
    private int stock;//股票

    public Architect() {
    }

    public Architect(String name, int id, double salary, int age, double bonus,int stock,Equipment equipment) {
        super(name, id, salary, age, bonus,equipment);
        this.stock=stock;
    }

    @Override
    public String toString() {
        return  super.say()+"\t 架构师"+"\t\t "+ getEquipment().toString2()+"\t\t "+ getBonus()+"\t\t "+ stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
