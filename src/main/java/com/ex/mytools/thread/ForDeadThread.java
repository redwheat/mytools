package com.ex.mytools.thread;

/**
 * @author zhengbingyuan
 * &#064;date 2025/2/18 7:48
 */
public class ForDeadThread implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(true){
            i = i+1;
        }
    }
}
