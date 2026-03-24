package org.example.Jvm;

public class stackoverflow {
    public static void recursive() {
        recursive(); // 无限调用自己
    }
    public static void main(String[] args) {
        recursive(); // 执行后抛出 StackOverflowError
    }
}
