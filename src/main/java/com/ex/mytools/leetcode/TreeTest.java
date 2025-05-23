package com.ex.mytools.leetcode;

import java.util.Scanner;

/**
 * @author zhengbingyuan
 * &#064;date 2025/4/29 8:22
 */
public class TreeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入树的总数：");
        int N = scanner.nextInt();
        System.out.println("请输入失活树的总数：");
        int M = scanner.nextInt();
        System.out.println("请输入失活树的编号（用空格隔开）：");
        String str =  scanner.next();
        String[] K = str.split(" ");
        if(!isNumber(K)){
            System.out.println("非数字,终止");
            return;
        }
        int[] lostTree = new int[K.length];
        for (int i = 0; i < K.length; i++) {
            lostTree[i] = Integer.valueOf(K[i]);
        }


        System.out.println("请输入补种树的数量：");
        int T = scanner.nextInt();
        System.out.println("最大的连续棵树："+getMaxCnt(N,M,lostTree,T));
    }

    private static int getMaxCnt(int N,int M,int[] lostTree,int T) {
        int[] treeList = new int[N];
        for (int i : lostTree) {
            treeList[i] = 1;
        }
        int left = 0;
        int right = 0;
        int nowDig = 0;
        for (right = 0; right < N; right++) {
            nowDig += treeList[right];//失活的树数
            int nowTreeCnt = right - left + 1;
            //两科树之间的失活树超过了可以补种的树
            if(nowDig>T){
                left++;
            }
        }
        return 0;
    }


    private static boolean isNumber(String K[]){
        for (String s : K) {
            for (int i = 0; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
