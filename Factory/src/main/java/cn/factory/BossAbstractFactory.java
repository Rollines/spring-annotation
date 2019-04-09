package cn.factory;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-08 14:02
 * @Description: 简单工厂模式
 */
abstract class Car{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Benz extends Car{
    @Override
    public void drive() {
        System.out.println(this.getName()+"----go-----------------------");

    }


}

class Bmw extends Car{
    @Override
    public void drive() {
        System.out.println(this.getName()+"----go-----------------------");
    }
}

//简单工厂
class Driver{
    public static Car createCar(String car){
        Car c = null;
        if ("Benz".equalsIgnoreCase(car))
            c = new Benz();
        else if("Bmw".equalsIgnoreCase(car))
            c= new Bmw();
        return c;
    }
}
public class BossAbstractFactory {
    public static void main(String[] args) {
        Car car=Driver.createCar("benz");
        car.setName("benz");
        car.drive();
    }
}
