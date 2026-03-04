package org.example.MultiThread.callable;

import java.util.concurrent.*;

/**
 * Callable + Future 简单多线程 Demo
 * 功能：计算 1~N 的累加和，每个任务计算不同的 N 值
 */
public class CallableDemo001 {

    // 1. 定义 Callable 任务：计算 1~num 的累加和
    static class SumTask implements Callable<Integer> {
        private int num; // 要计算到的数字

        // 构造方法传入计算上限
        public SumTask(int num) {
            this.num = num;
        }

        // 核心方法：执行任务并返回结果
        @Override
        public Integer call() throws Exception {
            System.out.println("线程 " + Thread.currentThread().getName() + " 开始计算 1~" + num + " 的和");
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
                // 模拟任务耗时（方便观察多线程执行）
                Thread.sleep(100);
            }
            System.out.println("线程 " + Thread.currentThread().getName() + " 计算完成");
            return sum;
        }
    }

    public static void main(String[] args) {
// 2. 创建线程池（固定3个线程）
//        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = new ThreadPoolExecutor(3,6,100L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));

        try {
            // 3. 提交 Callable 任务，获取 Future 对象（用于接收结果）
            Future<Integer> future1 = executor.submit(new SumTask(10)); // 计算1~10的和
            Future<Integer> future2 = executor.submit(new SumTask(20)); // 计算1~20的和
            Future<Integer> future3 = executor.submit(new SumTask(30)); // 计算1~30的和

            // 4. 获取任务结果（get() 是阻塞方法，直到任务完成）
            Integer result1 = future1.get();
            Integer result2 = future2.get();
            Integer result3 = future3.get();

            // 5. 打印结果
            System.out.println("1~10 的和：" + result1);
            System.out.println("1~20 的和：" + result2);
            System.out.println("1~30 的和：" + result3);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭线程池（必须关闭，否则程序不会退出）
            executor.shutdown();
        }
    }
}
