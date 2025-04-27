package com.ex.mytools;

import com.ex.mytools.thread.ForDeadThread;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MytoolsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testDateUtil(){

    }


   /* public static void main(String[] args) {
        Thread threaforDeadThreadd1 = new Thread(new ForDeadThread());
        threaforDeadThreadd1.start();
    }*/


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));
        for (int i = 0; i < 20 ; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"执行任务");
            });
        }

    }

}
