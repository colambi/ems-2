package com.atguigu.ems.domain;

import com.atguigu.ems.service.Status;

import javax.swing.*;

/**
 * ClassName: NotePad
 * Package: com.atguigu.ems.domain
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:46
 * @Version 1.0
 */
public class NotePad extends Equipment{
    public NotePad(int id, String factory, int price, Status status) {
        super(id, factory, price, status);
    }

    public NotePad() {
    }

    @Override
    public String toString() {
        return super.toString()+  "\t\t"+  "\t"+getStatus()+  "\t"+"平板";
    }

    @Override
    public String toString2() {
        return super.toString2()+"平板";
    }
}
