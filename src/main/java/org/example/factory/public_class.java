package org.example.factory;

interface Phone{
    void call();
}

class HuaweiPhone implements Phone{
    public void call(){
        System.out.println("华为手机，打电话");
    }
}

class IPhone implements Phone{
    public void call(){
        System.out.println("苹果手机，打电话");
    }
}

public class public_class {
}
