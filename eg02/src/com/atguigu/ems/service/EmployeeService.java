package com.atguigu.ems.service;

import com.atguigu.ems.domain.Architect;
import com.atguigu.ems.domain.Designer;
import com.atguigu.ems.domain.Employee;
import com.atguigu.ems.domain.Programmer;

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

    private static int total =1;
    private Employee[] employees=new Employee[15];
    private int realCount=0;//最大有数据index+1
    private int maxCount=15;//length-1

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

    //上面已限定员工15人，无需动态增长数组
//    public boolean addEmployee(Employee emp){
//        if (maxCount==0){
//            this.employees=new Employee[1];
//           maxCount=1;
//            this.addEmployee(emp);
//            return true;
//
//        }else if (realCount<maxCount){
//            this.employees[realCount]=emp;
//            realCount++;
//            return true;
//        }else if (realCount==maxCount){
//            Employee[] employees1 = new Employee[maxCount++];
//            for (int i = 0; i < realCount; i++) {
//                employees1[i]=employees[i];
//            }
//            this.addEmployee(emp);
//            return true;
//        }
//
//        else {
//            System.out.println("添加失败");
//            return false;
//        }
//
//    }
// /0∶添加成功

//1 ∶开发人员已满，无法添加
// 2:最多只能有两名架构师/
// 3:最多只能有三名设计师/
// 4:最多只能有五名程序员
// 5∶数组已满无法添加

    //在添加时 重新给id

    public int addEmployee(Employee emp){
        if(realCount== employees.length){
            return 5;//数组已满
        }else {

            int arcNum=0;
            int desNum=0;
            int proNum=0;
            //因为 架构师、设计师继承、属于程序员 所以 要先判子类再判断父类 要用elseif
            for (int i = 0; i < realCount; i++) {
                if (employees[i] instanceof Architect) {
                    arcNum++;
                } else if (employees[i] instanceof Designer) {
                        desNum++;
                    } else if (employees[i] instanceof Programmer) {
                            proNum++;
                        }
            }
            if ((arcNum+desNum+proNum==10)&&emp instanceof Programmer){//程序员 包括架构师、设计师
                return 1;
            }
            if (emp instanceof Architect){
                if (arcNum==2) return 2;
            }else if (emp instanceof Designer){
                if (desNum ==3)return 3;
            }else if (emp instanceof Programmer){
                if (proNum==5) return 4;
            }

            emp.setId(total++);
            this.employees[realCount++]=emp;
            return 0;//成功添加
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
     * @param id
     * 根据id 移除employees数组中 id相等的对象
     * 将后面 的员工对象补上
     * @return
     */
    public boolean removeEmployee(int id){
        int index=-1;
            for (int i = 0; i < realCount; i++) {
                if (this.employees[i].getId()==id){
                    index=i;
                    break;
                }
        }
            if (index==-1){
                System.out.println("未找到该id");
                return false;
            }else {
                for (int i = index; i < realCount-1; i++) {
                    this.employees[index]=this.employees[index+1];
                }
                employees[--realCount]=null;
                return true;
            }


    }

    /**
     * 根据员工id 检索员工的代码
     * @param id
     * @return
     */
    public Employee getEmployeeById(int id){
        for (int i = 0; i < realCount; i++) {
            if (this.employees[i].getId()==id){
                return this.employees[i];
            }

        }
        return null;
    }
}
