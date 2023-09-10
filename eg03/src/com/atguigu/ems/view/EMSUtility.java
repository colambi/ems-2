package com.atguigu.ems.view;

/**
 * ClassName: EMSUtility
 * Package: com.atguigu.ems.view
 * Description:
 *
 * @Author xzf
 * @Create 2023/9/7 22:21
 * @Version 1.0
 */

import java.util.Scanner;
/*
Date by 2022.7.24
对Scanner功能的扩展
 */
public class EMSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /*
    读菜单选择
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    /*
    读单个字符，用于添加
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /*
    读单个字符，用于修改，形参(char defaultValue)是表示如果修改性别时，没有输入新的性别，那么默认用原来的性别表示4
    defaultValue表示原来的性别
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /*
    读一个整数，用于添加
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(11, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /*
    读一个整数，用于修改
   */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(11, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /*
    读一个小数，用于添加
     */
    public static double readDouble() {
        double n;
        for (; ; ) {
            String str = readKeyBoard(12, false);
            try {
                n = Double.parseDouble(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /*
    读一个小数，用于修改
     */
    public static double readDouble(double defaultValue) {
        double n;
        for (; ; ) {
            String str = readKeyBoard(12, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Double.parseDouble(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /*
    读一个字符串，用于添加
    limit表示最多能输入几个字符。即字符串长度有限制。
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /*
    读一个字符串，用于修改
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    /*
    读一个字符，通常用于读取确认字符，Y/N，
    是否退出，是否删除时，作为确认用
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }
    /*
    按回车键继续
     */
    public void readContinue(){
        System.out.println("按回车键继续...");
        scanner.nextLine();
    }
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}