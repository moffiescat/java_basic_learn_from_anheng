package org.example.proxypattern;


interface Performable{
    void perform();
}

class Star implements Performable{
    @Override
    public void perform(){
        System.out.println("start to perform");
    }
}

class StarAgent implements Performable{
    private Star star;
    public StarAgent(){
        this.star = new Star();
    }

    @Override
    public void perform() {
        // 1. 调用目标对象前：代理的额外逻辑（审核、收费）
        checkRequest();
        collectDeposit();

        // 2. 调用目标对象的核心功能（经纪人安排明星演出）
        star.perform();

        // 3. 调用目标对象后：代理的额外逻辑（收尾）
        arrangeTrip();
    }

    // 代理的额外功能：审核演出请求
    private void checkRequest() {
        System.out.println("经纪人：审核演出请求，确认合规且安全 ✅");
    }

    // 代理的额外功能：收取定金
    private void collectDeposit() {
        System.out.println("经纪人：收取演出定金，签订合同 💰");
    }

    // 代理的额外功能：安排行程
    private void arrangeTrip() {
        System.out.println("经纪人：安排演出后的返程行程 🚌");
    }
}

// 第四步：测试类（使用者：演出主办方）
public class ProxyPatternDemo {
    public static void main(String[] args) {
        // 使用者只和代理（经纪人）交互，不直接接触目标对象（明星）
        Performable agent = new StarAgent();
        // 调用代理的perform方法，底层会触发明星的核心功能+代理的额外逻辑
        agent.perform();
    }
}