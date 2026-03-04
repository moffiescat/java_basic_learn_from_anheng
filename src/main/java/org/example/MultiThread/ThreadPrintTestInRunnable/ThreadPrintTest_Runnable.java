package org.example.MultiThread.ThreadPrintTestInRunnable;

public class ThreadPrintTest_Runnable{
    public static void main(String[] args){
        Object lock = new Object();
        int[] count = {1};
        int maxNum = 20;

        Runnable oddTask = new OddPrintRunnable(lock,count,maxNum);
        Runnable evenTask = new EvenPrintRunnable(lock,count,maxNum);

        new Thread(oddTask,"奇数线程").start();
        new Thread(evenTask,"偶数线程").start();
    }
}

