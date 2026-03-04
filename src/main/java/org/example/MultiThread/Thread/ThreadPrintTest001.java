package org.example.MultiThread.Thread;

public class ThreadPrintTest001 extends Thread{
    private static final Object lock = new Object();
    private static volatile int count = 1;
    private static final int MAX = 20;

    public ThreadPrintTest001(String name){
        super(name);
    }

    @Override
    public void run(){
        while(count <= MAX){
            synchronized(lock){
                System.out.printf("%s: %d%n",Thread.currentThread().getName(),count);
                count++;

                if(count <= MAX){
                    lock.notify();
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        System.out.printf("%s:被中断，退回打印%n",Thread.currentThread().getName());
                        break;
                    }
                }else{
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args){
        ThreadPrintTest001 thread1 = new ThreadPrintTest001("thread_a");
        ThreadPrintTest001 thread2 = new ThreadPrintTest001("thread_b");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        System.out.println("打印完成");
    }
}
