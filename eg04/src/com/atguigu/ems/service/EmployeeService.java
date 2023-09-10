package com.atguigu.ems.service;

import com.atguigu.ems.dao.EmployeeDao;
import com.atguigu.ems.domain.*;

import java.util.List;


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
  //  private Employee[] employees=new Employee[15];

   // private int realCount=0;//最大有数据index+1
  //  private int maxCount=15;//length-1

    //关联 Dao
    private EmployeeDao dao= new EmployeeDao();
   private EquipmentService eqs =new EquipmentService();
    private List<Employee> list;
    public EmployeeService(EquipmentService eqs){
        this.eqs=eqs;
        this.list= dao.getList();
        //动态设备领用
        for (Employee employee : list) {
            if (employee instanceof Programmer){
                int id = ((Programmer) employee).geteId();
                try {
                    Equipment equipment = eqs.getEquipment(id);
                    ((Programmer) employee).setEquipment(equipment);
                    equipment.setStatus(Status.USED);
                } catch (EMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public EmployeeService(int length){
//        if (length<=0){
//            System.out.println("输入大于零的数");
//        }else {
//
//            this.employees=new Employee[length];
//            //   for (int i = 0; i < length; i++) {
//            //this.employees[i]="null";
//            //  }
//            this.maxCount=length-1;
//        }
//
//    }
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
    //改 抛出异常

    //在添加时 重新给id

    public void addEmployee(Employee emp) throws EMSException {
//        if(realCount== employees.length){
//            //return 5;//数组已满
//            throw new EMSException("数组已满");
//        }else {

            int arcNum=0;
            int desNum=0;
            int proNum=0;
            //因为 架构师、设计师继承、属于程序员 所以 要先判子类再判断父类 要用elseif
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Architect) {
                    arcNum++;
                } else if (list.get(i) instanceof Designer) {
                        desNum++;
                    } else if (list.get(i) instanceof Programmer) {
                            proNum++;
                        }
            }
            if ((arcNum+desNum+proNum==10)&&emp instanceof Programmer){//程序员 包括架构师、设计师

                throw new EMSException("开发人员已满，无法添加");
            }
            if (emp instanceof Architect){
                if (arcNum==2)     throw new EMSException("最多只能有两名架构师");
            }else if (emp instanceof Designer){
                if (desNum ==3)    throw new EMSException("最多只能有三名设计师");
            }else if (emp instanceof Programmer){
                if (proNum==5)     throw new EMSException("最多只能有五名程序员");
            }

            emp.setId(total++);
            list.add(emp);
          //  this.employees[realCount++]=emp;

            //return 0;//成功添加
       // }

    }
//    public EmployeeService() {
//    }

    /**
     * 返回所有已添加的员工
     * 新创建一个员工数组
     * 将this.employess的员工一一放入
     * 不放入null
     * @return
     */

    public List<Employee> getAllEmployees() {
       return list;
    }

    /**
     *
     * @param id
     * 根据id 移除employees数组中 id相等的对象
     * 将后面 的员工对象补上
     * @return
     */
    public void removeEmployee(int id)throws EMSException {
        for (Employee employee : list) {
            if (employee.getId() == id) {
                if (employee instanceof Programmer) {//是开发人员有设备
                    ((Programmer) employee).getEquipment().setStatus(Status.FREE);//归还设备
                }
                list.remove(employee);
                return;
            }
        }
        throw new EMSException("未找到该id");
    }


    /**
     * 根据员工id 检索员工的代码
     * @param id
     * @return
     */
    public Employee getEmployeeById(int id) throws EMSException{
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==id){
                return list.get(i);
            }

        }
        throw new EMSException("没有找到");
    }


    /**
     * 保存所有员工
     * @param list
     */
    public void save() {
        dao.save(list);
    }
}
