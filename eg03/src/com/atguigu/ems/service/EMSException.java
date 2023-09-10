package com.atguigu.ems.service;

/**
 * ClassName: EMSException
 * Package: com.atguigu.ems.service
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/9 13:54
 * @Version 1.0
 */
public class EMSException extends Exception {
    public EMSException(String message) {
        super(message);
    }

    public EMSException(Throwable cause) {
        super(cause);
    }
}
