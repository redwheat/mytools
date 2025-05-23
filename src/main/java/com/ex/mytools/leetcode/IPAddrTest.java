package com.ex.mytools.leetcode;

import java.util.Scanner;

/**
 * @author zhengbingyuan
 * &#064;date 2025/4/27 8:20
 */
public class IPAddrTest {
    public static void main(String[] args) {
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String param = scanner.next();


//        String param = "103#02#4#5";
        System.out.println(convert(param));
    }


    public static String convert(String param){
        String[] split = param.split("#");
        if(split.length!=4){
            System.out.println("存在空节");
            return "";
        }
        for (String s : split) {
            if(!isNumeric(s)){
                System.out.println("不是数字");
                return "";
            }
            //是否存在前导0
            if(s.startsWith("0")){
                System.out.println("Invalid IP");
                return "";
            }
        }
        return "";
    }



    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false; // 如果有非数字字符则返回false
            }
        }
        return true; // 全部为数字则返回true
    }
}
