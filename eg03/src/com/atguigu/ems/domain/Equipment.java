package com.atguigu.ems.domain;

import com.atguigu.ems.service.Status;


/**
 * ClassName: Equipment
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:41
 * @Version 1.0
 */
public abstract class Equipment {
    private int id;
    private String factory;
    private int price;
    private Status status;

    public Equipment(int id, String factory, int price, Status status) {
        this.id = id;
        this.factory = factory;
        this.price = price;
        this.status = status;
    }

    public Equipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  id +
                "\t"+ factory;
    }

    public String toString2() {//用于员工列表展示
        return  getFactory();
    }
}
