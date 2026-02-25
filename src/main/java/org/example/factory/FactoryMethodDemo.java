package org.example.factory;

interface PhoneFactory_2{
    Phone createPhone();
}

// 第四步：实现具体工厂类（华为工厂 → 只生产华为手机）
class HuaweiFactory implements PhoneFactory_2 {
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }
}

// 第四步：实现具体工厂类（苹果工厂 → 只生产苹果手机）
class IPhoneFactory implements PhoneFactory_2 {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

// 第五步：测试（使用者）
public class FactoryMethodDemo {
    public static void main(String[] args) {
        // 使用者需要哪个产品，就创建对应的工厂
        PhoneFactory_2 huaweiFactory = new HuaweiFactory();
        Phone huawei = huaweiFactory.createPhone();
        huawei.call(); // 输出：华为手机：打电话 📱

        PhoneFactory_2 iphoneFactory = new IPhoneFactory();
        Phone iphone = iphoneFactory.createPhone();
        iphone.call(); // 输出：苹果手机：打电话 📱
    }
}
