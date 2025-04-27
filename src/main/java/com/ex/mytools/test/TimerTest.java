package com.ex.mytools.test;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengbingyuan
 * &#064;date 2025/3/23 13:55
 */
public class TimerTest {
    public static void main(String[] args) {
        // 创建一个 HashedWheelTimer 实例
        // 参数说明：
        // - tickDuration: 每个时间格的时间跨度，默认 100ms
        // - ticksPerWheel: 时间轮的格子数，默认 512
        HashedWheelTimer timer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS, 512);

        // 定义一个延时任务
        TimerTask task = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("延时任务触发，当前时间: " + System.currentTimeMillis());
            }
        };

        // 提交延时任务，延迟 3 秒执行
        System.out.println("提交延时任务，当前时间: " + System.currentTimeMillis());
        timer.newTimeout(task, 3, TimeUnit.SECONDS);

        // 主线程等待，防止程序立即退出
        try {
            Thread.sleep(5000); // 等待 5 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止定时器
        timer.stop();
    }
}
