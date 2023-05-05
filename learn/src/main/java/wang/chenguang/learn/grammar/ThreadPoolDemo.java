package wang.chenguang.learn.grammar;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(1);


        new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(),    // 工作队列
                Executors.defaultThreadFactory(),       // 线程工厂，定义线程名称，是否为守护线程，线程优先级
                new ThreadPoolExecutor.AbortPolicy());  // 饱和策略，中止、拒绝、抛弃最旧的、调用者调用
    }


}
