package com.atguigu.ems.domain;

import com.atguigu.ems.service.Status;

/**
 * ClassName: PC
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:43
 * @Version 1.0
 */
public class PC extends Equipment{
    private String display;

    public PC(int id, String factory, int price, Status status,String display) {
        super(id, factory, price, status);
        this.display=display;
    }

    public PC() {
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return super.toString()+  "\t\t"+  "\t"+getStatus()+  "\t"+"台式机";
    }

    @Override
    public String toString2() {
        return super.toString2()+"台式机";
    }
}
