package com.atguigu.ems.dao;

import com.atguigu.ems.domain.Equipment;
import com.atguigu.ems.domain.NoteBook;
import com.atguigu.ems.domain.NotePad;
import com.atguigu.ems.domain.PC;
import com.atguigu.ems.service.Data;
import com.atguigu.ems.service.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: EquipmentDao
 * Package: com.atguigu.ems.dao
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/10 0:01
 * @Version 1.0
 */
public class EquipmentDao {//设备 数据
    private String fileName;
    private static int total=1;



    /**
     *
     * @return list //获取数据的list
     */
    public List<Equipment> getList(){
        List<Equipment> list=new ArrayList<>();
       // eqs = new Equipment[Data.EQUIPMENTS.length];
        for (int i = 0; i < Data.EQUIPMENTS.length; i++) {
            String[] child = Data.EQUIPMENTS[i];
            int code=Integer.valueOf(child[0]);
            switch (code){
                case Data.PC:
                 list.add(new PC(total++,child[1],Integer.parseInt(child[2]), Status.FREE,child[3]));//根据code new 相应的对象
                    break;
                case Data.NOTEBOOK:
                    list.add(new NoteBook(total++,child[1],Integer.parseInt(child[2]),Status.FREE,child[3]));
                    break;
                case Data.NOTEPAD:
                    list.add(new NotePad(total++,child[1],Integer.parseInt(child[2]),Status.FREE));
                    break;
            }
        }
        return list;
    }
    //保存数据到文件
    public void save(  List<Equipment> list){


    }

}
