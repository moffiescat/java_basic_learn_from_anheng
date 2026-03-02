package org.example.MultiThread.ThreadPrintTest;

public class OddPrintRunnable implements Runnable{
    private final Object lock;
    private volatile int[] count;
    private final int maxNum;

    public OddPrintRunnable(Object lock,int[] count,int maxNum){
        this.lock = lock;
        this.count = count;
        this.maxNum = maxNum;
    }

    @Override
    public void run(){
        while(count[0] <= maxNum){
            synchronized(lock){
                if(count[0] % 2 == 1){
                    System.out.printf("%s:%d%n",Thread.currentThread().getName(),count[0]);
                    count[0]++;
                    lock.notify();
                }else{
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }
}