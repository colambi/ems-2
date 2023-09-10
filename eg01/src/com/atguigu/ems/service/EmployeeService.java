package com.atguigu.ems.service;

import com.atguigu.ems.domain.Employee;

/**
 * ClassName: EmployeeService
 * Package: com.atguigu.ems.service
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/7 22:18
 * @Version 1.0
 */
public class EmployeeService {
    private Employee[] employees;
    private int realCount=0;//最大有数据index+1
    private int maxCount=0;//length-1

    public EmployeeService(int length){
        if (length<=0){
            System.out.println("输入大于零的数");
        }else {

            this.employees=new Employee[length];
            //   for (int i = 0; i < length; i++) {
            //this.employees[i]="null";
            //  }
            this.maxCount=length-1;
        }

    }
//    public boolean addEmployee(Employee emp){
//        if (realCount<=maxCount){
//            this.employees[realCount]=emp;
//            realCount++;
//            return true;
//        }else {
//            System.out.println("添加失败");
//            return false;
//        }
//
//    }
    public boolean addEmployee(Employee emp){
        if (maxCount==0){
            this.employees=new Employee[1];
           maxCount=1;
            this.addEmployee(emp);
            return true;

        }else if (realCount<maxCount){
            this.employees[realCount]=emp;
            realCount++;
            return true;
        }else if (realCount==maxCount){
            Employee[] employees1 = new Employee[maxCount++];
            for (int i = 0; i < realCount; i++) {
                employees1[i]=employees[i];
            }
            this.addEmployee(emp);
            return true;
        }

        else {
            System.out.println("添加失败");
            return false;
        }

    }
    public EmployeeService() {
    }

    /**
     * 返回所有已添加的员工
     * 新创建一个员工数组
     * 将this.employess的员工一一放入
     * 不放入null
     * @return
     */

    public Employee[] getAllEmployees() {
        Employee[] emps1=new Employee[realCount];
        for (int i = 0; i < realCount; i++) {
            emps1[i]=employees[i];
        }
        return emps1;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public int getRealCount() {
        return realCount;
    }
    //根据下标返回员工
    public Employee getEmployeeByIndex(int index){
        if (index<0||index>=realCount){
            System.out.println("index 越界");
            return null;
        }else {
            return this.employees[index];
        }

    }

//    public void setRealCount(int realCount) {
//        this.realCount = realCount;
//    }\

    /**
     *
     * @param index
     * 根据index 移除employees数组的对象
     * 将后面 的员工对象补上
     * @return
     */
    public boolean removeEmployee(int index){
        if (index<0||index>=realCount){
            System.out.println("index 越界");
            return false;
        }else{
            for (int i = index; i < realCount-1; i++) {
                this.employees[index]=this.employees[index+1];
            }
            employees[--realCount]=null;
            return true;
        }




    }

}
