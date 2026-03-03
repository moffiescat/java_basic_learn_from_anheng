package org.example.MultiThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池简单应用示例：FixedThreadPool（固定线程数）
 * 场景：用3个线程执行10个打印数字的任务
 */
public class ThreadPoolSimpleDemo {
    public static void main(String[] args) {
        // 1. 创建固定线程数的线程池（核心线程数=最大线程数=3）
        // 核心参数：3 → 线程池始终保持3个线程处理任务
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            // 2. 提交10个任务给线程池执行
            for (int i = 1; i <= 10; i++) {
                // 为避免lambda变量捕获问题，定义final变量
                final int taskNum = i;

                // 提交Runnable任务（核心：任务与线程解耦）
                threadPool.submit(new Runnable() {
                    @Override
                    public void run() {
                        // 任务逻辑：打印当前线程名 + 任务编号
                        System.out.printf("线程[%s] 执行任务：打印数字 %d%n",
                                Thread.currentThread().getName(), taskNum);

                        // 模拟任务耗时（比如处理业务逻辑）
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("任务被中断：" + taskNum);
                        }
                    }
                });
            }
        } finally {
            // 3. 关闭线程池（必须操作，否则主线程退出后线程池仍存活）
            // shutdown()：不再接收新任务，等待已提交任务执行完毕后关闭
            threadPool.shutdown();

            // 可选：等待线程池关闭（超时控制）
            /*
            try {
                if (!threadPool.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                    threadPool.shutdownNow(); // 超时则强制关闭
                }
            } catch (InterruptedException e) {
                threadPool.shutdownNow();
            }
            */
        }

        System.out.println("所有任务已提交，主线程继续执行...");
    }
}