package cn.factory;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-08 14:02
 * @Description: 使用开闭原则来分析下工厂方法模式。当有新的产品（即暴发户的汽车）产生时，
 * 只要按照抽象产品角色、抽象工厂角色提供的合同来生成，那么就可以被客户使用，而不必去修改任何已有的代码。（即当有新产品时，只要创建并基础抽象产品；新建具体工厂继承抽象工厂；而不用修改任何一个类）工厂方法模式是完全符合开闭原则的！
 */
abstract class Cars{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Benzs extends Cars{
    @Override
    public void drive() {
        System.out.println(this.getName()+"----go-----------------------");

    }
}

class Bmws extends Cars{
    @Override
    public void drive() {
        System.out.println(this.getName()+"----go-----------------------");
    }
}

//抽象工厂
class Drivers{
    public Cars createCar(String car) throws Exception {
        return null;
    }
}

//具体工厂（每个具体工厂负责一个具体产品）
class BenzDriver extends Drivers{
    public Cars createCar(String car) throws Exception {
        return new Benzs();
    }
}
class BmwDriver extends Drivers{
    public Cars createCar(String car) throws Exception {
        return new Bmws();
    }
}

public class BossFactory {
    public static void main(String[] args) throws Exception {
        Drivers d = new BenzDriver();
        Cars c = d.createCar("benzs");
        c.setName("benzs");
        c.drive();
    }
}
