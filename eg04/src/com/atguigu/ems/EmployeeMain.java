package com.atguigu.ems;

import com.atguigu.ems.domain.Equipment;
import com.atguigu.ems.service.EMSException;
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

}
