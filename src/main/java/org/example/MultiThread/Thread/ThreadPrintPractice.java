package org.example.MultiThread.Thread;

public class ThreadPrintPractice extends Thread{
    private static final Object lock = new Object();
    private static volatile int count = 1;
    private static final int max = 20;

    public ThreadPrintPractice(String name){
        super(name);
    }

    @Override
    public void run(){
        while(count <= max){
            synchronized(lock){
                System.out.printf("%s:%d%n",Thread.currentThread().getName(),count);
                count++;

                if(count <= max){
                    lock.notify();
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        System.out.printf("%s:被中断",Thread.currentThread().getName());
                        break;
                    }
                }else{
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args){
        ThreadPrintPractice thread1 = new ThreadPrintPractice("Thread_a");
        ThreadPrintPractice thread2 = new ThreadPrintPractice("Thread_b");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        System.out.println("finished!");
    }
}
