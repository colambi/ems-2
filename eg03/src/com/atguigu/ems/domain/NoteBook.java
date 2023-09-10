package com.atguigu.ems.domain;

import com.atguigu.ems.service.Status;

import javax.swing.*;

/**
 * ClassName: NoteBook
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:47
 * @Version 1.0
 */
public class NoteBook extends Equipment{
    private String model;

    public NoteBook(int id, String factory, int price, Status status,String model) {
        super(id, factory, price, status);
        this.model=model;
    }

    public NoteBook() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return super.toString()+  "\t"+model+  "\t"+getStatus()+  "\t"+"笔记本";
    }

    @Override
    public String toString2() {
        return super.toString2()+"笔记本";
    }
}
