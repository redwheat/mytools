package com.ex.mytools.leetcode;

import java.util.Scanner;

/**
 * @author zhengbingyuan
 * &#064;date 2025/4/28 8:23
 */
public class TangguoTest {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            System.out.println("共需要"+getCnt(x)+"次才能分到一颗");
        }

    }

    private static int getCnt(int x) {
        int t = 0;
        for (int i = x; i !=1; i=i/2,t++) {
            if(i==3){
                t+=2;
                return t;
            }
            if(i%2!=0){
                //不是偶数，判断+1或者-1哪个更加优先
                if((i+1)/2%2==0){
                    i=i+1;
                }else{
                    i=i-1;
                }
                //取出，放回都记住一次
                t++;
            }

        }
        return t;
    }
}
