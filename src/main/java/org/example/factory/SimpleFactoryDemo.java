package org.example.factory;

class PhoneFactory_1{
    public static Phone createPhone(String type){
        if ("huawei".equals(type)) {
            return new HuaweiPhone();
        } else if ("iphone".equals(type)) {
            return new IPhone();
        } else {
            throw new IllegalArgumentException("不支持的手机类型：" + type);
        }
    }
}


public class SimpleFactoryDemo {
    public static void main(String[] args) {
        // 使用者只需要告诉工厂“要什么”，不用自己 new 对象
        Phone huawei = PhoneFactory_1.createPhone("huawei");
        huawei.call(); // 输出：华为手机：打电话 📱

        Phone iphone = PhoneFactory_1.createPhone("iphone");
        iphone.call(); // 输出：苹果手机：打电话 📱
    }
}
