package behavioral.mediator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */
public class MediatorTest {

    @Test
    public void test() {
        //一个房主、一个租房者、一个中介机构
        MediatorStructure mediator = new MediatorStructure();

        System.out.println("张三是房主，李四是租户");
        //房主和租房者只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("李四", mediator);

        //中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.contact("听说你那里有三室的房主出租.....");
        houseOwner.contact("是的!请问你需要租吗?");
    }

    public static abstract class Mediator {
        //申明一个联络方法
        public abstract void contact(String message, Person person);
    }

    public static abstract class Person {
        String name;
        Mediator mediator;

        Person(String name, Mediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }
    }

    public static class HouseOwner extends Person {

        HouseOwner(String name, Mediator mediator) {
            super(name, mediator);
        }

        void contact(String message) {
            mediator.contact(message, this);
        }

        void getMessage(String message) {
            System.out.println("房主" + name + ",获得信息：" + message);
        }
    }

    public static class Tenant extends Person {

        Tenant(String name, Mediator mediator) {
            super(name, mediator);
        }


        void contact(String message) {
            mediator.contact(message, this);
        }


        void getMessage(String message) {
            System.out.println("租户" + name + "获得信息：" + message);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class MediatorStructure extends Mediator {
        //首先中介结构必须知道所有房主和租房者的信息
        private HouseOwner houseOwner;
        private Tenant tenant;

        public void contact(String message, Person person) {
            if (person == houseOwner) {          //如果是房主，则租房者获得信息
                tenant.getMessage(message);
            } else {       //反正则是房主获得信息
                houseOwner.getMessage(message);
            }
        }
    }
}