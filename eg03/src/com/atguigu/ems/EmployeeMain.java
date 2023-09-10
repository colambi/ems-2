package com.atguigu.ems;

import com.atguigu.ems.domain.Equipment;
import com.atguigu.ems.service.EMSException;
import com.atguigu.ems.service.EmployeeService;
import com.atguigu.ems.service.EquipmentService;
import com.atguigu.ems.view.EmployeeView;

/**
 * ClassName: EmployeeMain
 * Package: com.atguigu.ems
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/7 22:15
 * @Version 1.0
 */
public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeView employeeView=new EmployeeView();
        employeeView.enterMainMenu();
    }
    public static void main2(String[] args) {
        EquipmentService equipmentService = new EquipmentService();
        try {
            System.out.println(equipmentService.getEquipment(20).toString());
        } catch (EMSException e) {
            e.printStackTrace();
        }
        Equipment[] allEquipments = equipmentService.getAllEquipments();
        for (int i = 0; i < allEquipments.length; i++) {
            System.out.println(allEquipments[i].toString());
        }



    }

}
