package org.example.singleton;

// 线程安全的懒汉式（双重检查锁 DCL）
public class LazySingleton {
    private LazySingleton() {}

    // volatile 关键字：防止指令重排序，保证 INSTANCE 实例化完成后才被读取
    private static volatile LazySingleton INSTANCE = null;

    public static LazySingleton getInstance() {
        // 第一层检查：避免每次调用都加锁（提高性能）
        if (INSTANCE == null) {
            // 加锁：保证同一时间只有一个线程进入
            synchronized (LazySingleton.class) {
                // 第二层检查：防止多个线程等待锁后重复创建实例
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }

    // 测试
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2); // true
    }
}