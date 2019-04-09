package cn.factory;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-08 14:27
 * @Description:   用来生产不同产品族的全部产品。（不支持拓展增加产品；支持增加产品族）
 */
//抽象产品
    abstract class BenzCar{
        private String name;
        public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//具体产品
class BenzSportCar extends BenzCar{
    @Override
    public void drive() {
        System.out.println(this.getName()+"----BenzSportCar-----------------------");
    }
}
class BenzBusinessCar extends BenzCar{
    @Override
    public void drive() {
        System.out.println(this.getName()+"----BenzBusinessCar-----------------------");
    }
}


abstract class BmwCar{
        private String name;
        public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




class BmwSportCar extends BmwCar{
    public void drive(){
        System.out.println(this.getName()+"----BmwSportCar-----------------------");
    }
}
class BmwBusinessCar extends BmwCar{
    public void drive(){
        System.out.println(this.getName()+"----BmwBusinessCar-----------------------");
    }
}

abstract class AudiCar{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class AudiSportCar extends AudiCar{
    public void drive(){
        System.out.println(this.getName()+"----AudiSportCar-----------------------");
    }
}
class AudiBusinessCar extends AudiCar{
    public void drive(){
        System.out.println(this.getName()+"----AudiBusinessCar-----------------------");
    }
}
//抽象工厂
abstract class Driver3{
    public abstract BenzCar createBenzCar(String car) throws Exception;

    public abstract BmwCar createBmwCar(String car) throws Exception;

    public abstract AudiCar createAudiCar(String car) throws Exception;
}

//具体工厂
class SportDriver extends Driver3{
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzSportCar();
    }
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwSportCar();
    }
    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiSportCar();
    }
}
class BusinessDriver extends Driver3{
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzBusinessCar();
    }
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwBusinessCar();
    }
    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiBusinessCar();
    }
}


public class FactoryBossAbstract {
    public static void main(String[] args) throws Exception {
        Driver3 d = new BusinessDriver();
        AudiCar car = d.createAudiCar("");
        car.drive();
    }
}
