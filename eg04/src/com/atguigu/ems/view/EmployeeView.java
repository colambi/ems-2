package com.atguigu.ems.view;

import com.atguigu.ems.domain.*;
import com.atguigu.ems.service.EMSException;
import com.atguigu.ems.service.EmployeeService;
import com.atguigu.ems.service.EquipmentService;
import com.atguigu.ems.service.Status;

import java.util.List;

/**
 * ClassName: EmployeeView
 * Package: com.atguigu.ems.view
 * Description:
 *
 *
 * （1）对象的创建：
 *
 * 创建了EMSUtility类的对象、创建了Employeeservice类的对象
 *
 * （2）成员方法：
 *
 * ①进入主菜单：public void enterMainMenu()
 *
 * ②添加员工信息：private void addNewEmployee()
 *
 * ③修改员工信息：private void modifyEmployee()
 *
 * ④删除员工信息：private void deleteEmployee()
 *
 * ⑤员工列表信息：private void listAllEmployees()

 * @Author xzf
 * @Create 2023/9/7 22:18
 * @Version 1.0
 */

/*
Date by 2022.7.24
界面的设计
 */
public class EmployeeView {
    //创建EMSUtility类的对象，用于调用该类的方法
    private EMSUtility ems = new EMSUtility();
    private EquipmentService eqs=new EquipmentService();
    private EmployeeService es = new EmployeeService(eqs);


    //进入主菜单
    public void enterMainMenu() {
        //使用while结构进行循环
        while (true) {
            System.out.println("---------------员工信息-----------------");
            listAllEmployees();
            System.out.print("\t\t1 添加员工");
            System.out.print("\t\t2 修改员工");
            System.out.print("\t\t3 删除员工");
            System.out.print("\t\t4 员工列表");
            System.out.println("\t\t5 退 出");
            System.out.print("请选择（1-5）：");
            //调用EMSUtility类中的“读菜单选项”方法，返回值是char类型，使用一个char变量进行接收
            char select = ems.readMenuSelection();
            switch (select) {
                case '1':
                    addNewEmployee();
                  //  listAllEmployees();
                    break;
                case '2':
                    modifyEmployee();
                 //   listAllEmployees();
                    break;
                case '3':
                    deleteEmployee();
                  //  listAllEmployees();
                    break;
                case '4':
                  //  listAllEmployees();
                    break;
                case '5':
                    //查看用户是否真的退出
                    System.out.println("是否真的退出（Y/N）？");
                    //调用EMSUtility类中的“readConfirmSelection()”方法
                    char confim = ems.readConfirmSelection();
                    if (confim == 'Y') {
                        saveEmployee();
                        return;
                    }
            }
            ems.readContinue();
        }
    }

    private void saveEmployee() {
        es.save();
        eqs.save();
    }
    //添加员工信息
    private void addNewEmployee() {
        System.out.println("---------------添加员工-----------------");
        System.out.print("姓名：");
        //调用调用EMSUtility类中的方法
        String name = ems.readString(20);//不超过20个字符



        System.out.print("年龄：");
        int age = ems.readInt();
        System.out.print("工资：");
        double salary = ems.readDouble();
        System.out.println("---------------职位信息列表-----------------");
        System.out.println("1.普通员工 2.程序员 3.设计师 4.架构师");
        System.out.println("--------------------------------------------");
        System.out.println("职位：");
        int jobId = ems.readInt();
        Double bonus;
        Employee employee =null;
        switch (jobId){
            case 1:
                employee=new Employee(name,0,salary,age);
                break;
            case 2:
                employee = new Programmer(name, 0, salary, age,null);
                break;
            case 3:
                System.out.print("奖金：");
                bonus=ems.readDouble();
                employee = new Designer(name,0,salary,age,bonus,null);
                break;
            case 4:
                System.out.print("奖金：");
                bonus = ems.readDouble();
                System.out.print("股票：");
                int stock = ems.readInt();
                employee = new Architect(name,0,salary,age,bonus,stock,null);
                break;
            default:
                System.out.println("错误的职位信息，输入1~4");
        }
        //已在上面创建了Employeeservice类的对象，将emp对象添加到对象数组中
        if (jobId>1){
            List<Equipment> list = eqs.getAllEquipments();
            System.out.println("---------------设备列表-----------------");
            System.out.println("ID\t厂家\t型号\t状态\t设备类型");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                
            }
            System.out.println("--------------------------------");
            System.out.print("领用设备：");
            int eqId = ems.readInt();
            try {
                Equipment equipment = eqs.getEquipment(eqId);
                //设备正在使用中，无法领用设备已经报废，无法领用
                if (equipment.getStatus()== Status.USED)
                    throw new EMSException("设备正在使用中，无法领用");
                if (equipment.getStatus()== Status.SCRAP)
                    throw new EMSException("设备已经报废，无法领用");
                ((Programmer) employee).setEquipment(equipment);
                equipment.setStatus(Status.USED);//调整设备状态
            } catch (EMSException e) {
                System.out.println("---------------添加失败，"+e.getMessage()+"-----------------");
                return;
            }
        }
        try {
            es.addEmployee(employee);//添加员工
            System.out.println("---------------添加完成-----------------");
        } catch (EMSException e) {
            System.out.println("---------------添加失败，"+e.getMessage()+"-----------------");
        }
      /*  int retValue = es.addEmployee(employee);
        switch (retValue){
            case 0:
                System.out.println("---------------添加完成-----------------");
                break;
            case 1:
                System.out.println("---------------开发人员已满，无法添加-----------------");
                break;
            case 2:
                System.out.println("---------------最多只能有两名架构师-----------------");
                break;

            case 3:
                System.out.println("---------------最多只能有三名设计师-----------------");
                break;
            case 4:
                System.out.println("---------------最多只能有五名程序员-----------------");
                break;
            case 5:
                System.out.println("---------------容量已满，无法添加-----------------");
                break;
            default:
                System.out.println("---------------添加失败，未知错误-----------------");
                break;
        }
        */



    }

    //修改员工信息
    private void modifyEmployee() {
        System.out.println("---------------修改员工-----------------");
        System.out.print("请选择待修改员工ID（-1）退出：");
        //输入编号
        int id = ems.readInt();
        //退出判断
        if (id == -1) {
            return;//退出修改功能，返回主菜单
        }
        //正常情况
        //输入员工的编号，得到员工信息，进行修改
        //此处调用Employeeservice类的getEmployee()方法
        Employee employee = null;
        try {
            employee = es.getEmployeeById(id);
        } catch (EMSException e) {

            System.out.println(e.getMessage());
        }

        //异常1：employee为null
//        if (employee == null) {
//            System.out.println(id + "员工对象不存在");
//            return;
//        }
        //修改员工信息
        System.out.print("姓名：（" + employee.getName() + "）");
        //接收输入修改的值
        String name = ems.readString(20, employee.getName());//不超过20个字符
        employee.setName(name);




        System.out.print("年龄：（" + employee.getAge() + "）");
        int age = ems.readInt(employee.getAge());
        employee.setAge(age);

        System.out.print("工资：(" + employee.getSalary() + "）");
        double salary = ems.readDouble(employee.getSalary());
        employee.setSalary(salary);
        if (employee instanceof Designer){
            System.out.print("奖金：(" + ((Designer) employee).getBonus() + "）");
            double bonus = ems.readDouble(((Designer) employee).getBonus());
            ((Designer) employee).setBonus(bonus);
        }
        if (employee instanceof Architect){
            System.out.print("股票：(" + ((Architect) employee).getStock() + "）");
            int stock = ems.readInt(((Architect) employee).getStock());
            ((Architect) employee).setStock(stock);
        }





        System.out.println("---------------修改完成-----------------");
    }

    //删除员工信息
    private void deleteEmployee() {
        System.out.println("---------------删除员工-----------------");
        System.out.print("请选择待删除员工编号（-1）退出：");
        //输入编号
        int id = ems.readInt();
        //退出判断
        if (id == -1) {
            return;//退出删除功能，返回主菜单
        }
        //判断用户是否真的删除
        System.out.println("是否真的删除（Y/N）？");
        //调用EMSUtility类中的“readConfirmSelection()”方法
        char confim = ems.readConfirmSelection();
        if (confim == 'N') {
            return;//退出删除功能，返回主菜单
        }
        //调用Employeeservice类中的removeEmployee()方法
        //用一个boolean类型的变量进行接收
        try {
            es.removeEmployee(id);
            System.out.println("---------------删除完成-----------------");
        } catch (EMSException e) {
            System.out.println("---------------"+e.getMessage()+"---------------");
        }
     //   System.out.println(result ? "删除成功" : "删除失败");


    }

    //员工列表信息
    private void listAllEmployees() {
        //得到从Employeeservice类中已添加的员工信息，并遍历输出

        List<Employee> allEmployees = es.getAllEmployees();
        System.out.println("---------------员工列表--------------------\n");
        System.out.println("ID\t姓名\t年龄\t工资\t\t职位\t\t领用设备\t\t奖金\t\t股票");
        //使用for循环进行输出
        for (int i = 0; i < allEmployees.size(); i++) {
            System.out.println(allEmployees.get(i).toString());
        }
        System.out.println("---------------员工列表完成-----------------\n");
    }
}
