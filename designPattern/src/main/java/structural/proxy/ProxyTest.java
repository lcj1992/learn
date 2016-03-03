package structural.proxy;

/**
 * Created by lcj on 15-10-31.
 */

interface ICar{
    void driveCar();
}

class Car implements ICar{


    public void driveCar() {
        System.out.println("car has been driven!");
    }
}

class ProxyCar implements ICar{
    private Driver driver;
    private ICar realCar;

    public ProxyCar(Driver driver){
        this.driver = driver;
        realCar = new Car();
    }


    public void driveCar() {
        if(driver.getAge() <= 16){
            System.out.println("sorry, the driver is too young to drive");
        }else{
            realCar.driveCar();
        }
    }
}

class Driver{
    private int age;

    public Driver(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        ICar car = new ProxyCar(new Driver(15));
        car.driveCar();

        car = new ProxyCar(new Driver(25));
        car.driveCar();
    }
}
