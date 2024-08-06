package structural.facade;

import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */

public class FacadeTest {

    @Test
    public void test() {
        CarFacade facade = new CarFacade();
        facade.createCompleteCar();
    }

    static class CarModel {
        public void setModel() {
            System.out.println("CarModel - setModel");
        }
    }

    static class CarEngine {
        public void setEngine() {
            System.out.println("CarEngine - setEngine");
        }
    }

    static class CarBody {
        public void setBody() {
            System.out.println("CarBody - SetBody");
        }
    }

    static class CarAccessories {
        public void setAccessories() {
            System.out.println("CarAccessories - SetAccessories");
        }
    }

    static class CarFacade {
        private final CarModel model;
        private final CarEngine engine;
        private final CarBody body;
        private final CarAccessories accessories;

        public CarFacade() {
            this.model = new CarModel();
            this.engine = new CarEngine();
            this.body = new CarBody();
            this.accessories = new CarAccessories();
        }

        public void createCompleteCar() {
            System.out.println("*****create a car*****");
            model.setModel();
            engine.setEngine();
            body.setBody();
            accessories.setAccessories();
            System.out.println("*****end!*****");
        }
    }
}