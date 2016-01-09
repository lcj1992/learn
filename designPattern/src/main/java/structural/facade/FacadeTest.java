package structural.facade;

/**
 * Created by lcj on 15-10-31.
 */

class CarModel{
    public void setModel(){
        System.out.println("CarModel - setModel");
    }
}

class CarEngine{
    public void setEngine(){
        System.out.println("CarEngine - setEngine");
    }
}

class CarBody{
    public void setBody(){
        System.out.println("CarBody - SetBody");
    }
}

class CarAccessories{
    public void setAccessories(){
        System.out.println("CarAccessories - SetAccessories");
    }
}

class CarFacade{
    private CarModel model;
    private CarEngine engine;
    private CarBody body;
    private CarAccessories accessories;

    public CarFacade(){
        this.model= new CarModel();
        this.engine = new CarEngine();
        this.body = new CarBody();
        this.accessories = new CarAccessories();
    }

    public void createCompleteCar(){
        System.out.println("*****create a car*****");
        model.setModel();
        engine.setEngine();
        body.setBody();
        accessories.setAccessories();
        System.out.println("*****end!*****");
    }
}

public class FacadeTest{


    public static void main(String[] args) {
        CarFacade facade = new CarFacade();
        facade.createCompleteCar();
    }
}