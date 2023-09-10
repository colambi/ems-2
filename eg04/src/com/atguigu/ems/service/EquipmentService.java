package com.atguigu.ems.service;

import com.atguigu.ems.dao.EquipmentDao;
import com.atguigu.ems.domain.Equipment;
import com.atguigu.ems.domain.NoteBook;
import com.atguigu.ems.domain.NotePad;
import com.atguigu.ems.domain.PC;

import java.util.List;

/**
 * ClassName: EquipmentService
 * Package: com.atguigu.ems.service
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:49
 * @Version 1.0
 */
public class EquipmentService {//设备管理类
    private EquipmentDao dao =new EquipmentDao();
    List<Equipment> list;

    private static int total=1;//设备唯一id号



  //  private Equipment[] eqs;//设备数组

    public EquipmentService() {
        list=dao.getList();

        /*eqs = new Equipment[Data.EQUIPMENTS.length];
        for (int i = 0; i < eqs.length; i++) {
            String[] child = Data.EQUIPMENTS[i];
            int code=Integer.valueOf(child[0]);
            switch (code){
                case Data.PC:
                    eqs[i] =new PC(total++,child[1],Integer.parseInt(child[2]),Status.FREE,child[3]);//根据code new 相应的对象
                    break;
                case Data.NOTEBOOK:
                    eqs[i] =new NoteBook(total++,child[1],Integer.parseInt(child[2]),Status.FREE,child[3]);
                    break;
                case Data.NOTEPAD:
                    eqs[i] =new NotePad(total++,child[1],Integer.parseInt(child[2]),Status.FREE);
                    break;

            }



        }
        */
    }

     public  List<Equipment>  getAllEquipments(){
        return list;

    }



    public Equipment getEquipment(int id)throws EMSException{
        for (Equipment eq : list) {
            if (eq.getId()==id)
                return eq;
        }
        throw new EMSException("没有找到id"+id);
    }

    public void save(){
        dao.save(list);
    }
}
