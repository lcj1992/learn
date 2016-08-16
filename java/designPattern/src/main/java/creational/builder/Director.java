package creational.builder;
/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/16
 * Time: 下午4:27
 */

class Car {
    private int wheels;

    private String color;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [wheels=" + wheels + ", color=" + color + "]";
    }
}

interface CarBuilder{
    void buildView();

    Car getResult();
}

class RedCarBuilder implements CarBuilder{

    private Car car;


    public RedCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildView() {
        car.setColor("Red");
        car.setWheels(4);
    }

    @Override
    public Car getResult() {
        return car;
    }
}

public class Director {


    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car construct(){
        carBuilder.buildView();
        return carBuilder.getResult();
    }
    public static void main(String[] args) {
        CarBuilder carBuilder  = new RedCarBuilder();
        Director director = new Director(carBuilder);
        System.out.println(director.construct());
    }
}