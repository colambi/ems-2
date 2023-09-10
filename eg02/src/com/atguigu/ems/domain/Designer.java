package com.atguigu.ems.domain;

/**
 * ClassName: Designer
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/8 23:54
 * @Version 1.0
 */
public class Designer extends Programmer{
    private double bonus; //奖金

    public Designer() {
    }

    public Designer(String name, int id, double salary, int age, double bonus) {
        super(name, id, salary, age);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return  super.say()+"\t 设计师"+"\t\t "+ bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
