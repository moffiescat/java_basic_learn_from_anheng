package org.example.MultiThread.ThreadPrintTestInRunnable;

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
        while(true){
            synchronized(lock){
                if(count[0] >= maxNum){
                    lock.notifyAll();
                    break;
                }

                while(count[0] % 2 == 0){
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                System.out.printf("%s:%d%n", Thread.currentThread().getName(), count[0]);
                count[0]++;
                lock.notifyAll();
            }
        }
    }
}