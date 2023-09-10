package com.atguigu.ems.dao;

import com.atguigu.ems.domain.Employee;
import com.atguigu.ems.service.EMSException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: EmployeeDao
 * Package: com.atguigu.ems.dao
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/10 0:02
 * @Version 1.0
 */
public class EmployeeDao {

    //save 序列化
    //get 反序列化

    private String fileName="employees.dat";
    public List<Employee> getList(){
        List<Employee> list;
        FileInputStream fis = null;
        ObjectInputStream ois =null;
        try {
        fis=new FileInputStream(fileName);
        ois=new ObjectInputStream(fis);
        list= (List<Employee>) ois.readObject();
            return list;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("---------------未找到文件-----------------");
            return new ArrayList<>();
        }finally {
            if (ois!=null){
                try {
                    ois.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      //  throw new EMSException("读文件错误");
    }

    public void save(List<Employee> list) {
        //使用对象序列化 ObjectOutPutStream
        FileOutputStream fos=null;
        ObjectOutputStream oos =null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (oos !=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
