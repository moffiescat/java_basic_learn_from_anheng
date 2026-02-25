package org.example.singleton;

public class singleton {
    private singleton(){}
    private static final singleton INSTANCE = new singleton();
    public static singleton getInstance(){
        return INSTANCE;
    }

    public void showmessage(){
        System.out.print("这是饿汉式的唯一实例");
    }

}
