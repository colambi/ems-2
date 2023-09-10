package com.atguigu.ems;

import com.atguigu.ems.domain.Employee;
import com.atguigu.ems.service.EmployeeService;
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
        EmployeeView employeeView = new EmployeeView();
        employeeView.enterMainMenu();

    }
    public static void main2(String[] args) {
        System.out.println("hello,world");
        Employee employee = new Employee("张三", "18319227806", "2970279044@qq.com", '男', 18);
        System.out.println(employee.toString());
        EmployeeService employeeService = new EmployeeService(10);//创建员工对象数组，可以存放对象

        employeeService.addEmployee(employee);
        employeeService.addEmployee(new Employee("李四", "18319337806", "2970279044@qq.com", '女', 18));
        employeeService.addEmployee(new Employee("王五", "18319337806", "2970279044@qq.com", '女', 18));
        employeeService.addEmployee(new Employee("小刘", "18319337806", "2970279044@qq.com", '女', 18));

        Employee employeeByIndex = employeeService.getEmployeeByIndex(2);//封装的 给出方法 employees【i】
        if (employeeByIndex!=null){//等于null 用toString() 报空指针异常
            System.out.println("getEmployeeByIndex"+employeeByIndex.toString());
        }
        employeeService.removeEmployee(20);

        employeeByIndex = employeeService.getEmployeeByIndex(2);//封装的 给出方法 employees【i】
        if (employeeByIndex!=null){//等于null 用toString() 报空指针异常
            System.out.println("getEmployeeByIndex"+employeeByIndex.toString());
        }

        Employee[] employees = employeeService.getAllEmployees();//封装的 拿出一个复制值的 新的数组
        for (int i = 0; i < employees.length; i++) {
            if (i<employeeService.getRealCount()){
                System.out.println(employees[i].toString());
            }else {
              // System.out.println(employees[i]);
                System.out.println("null");
            }

        }

    }
}
