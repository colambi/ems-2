package com.atguigu.ems.service;

/**
 * ClassName: Status
 * Package: com.atguigu.ems.service
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:39
 * @Version 1.0
 */
public enum Status {
    FREE("空闲"),
    USED("使用"),
    SCRAP("报废");
    private String info;

    Status() {
    }

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString(){
        return info;
    }
}
