package creational.staticfactory;


import org.junit.Test;


public class StaticFactoryTest {

    @Test
    public void test() {
        StaticFactoryTest test = new StaticFactoryTest();
        System.out.println(test.getPeople(PeopleType.URBAN).getName());
    }

    public IPeople getPeople(PeopleType type) {
        IPeople people = null;
        switch (type) {
            case RURAL:
                people = new CityPeople();
                break;
            case URBAN:
                people = new Villager();
                break;
            default:
                break;
        }
        return people;
    }

    static class CityPeople implements IPeople {
        @Override
        public String getName() {
            return "city People";
        }
    }

    interface IPeople {
        String getName();
    }

    enum PeopleType {
        RURAL,
        URBAN;
    }

    static class Villager implements IPeople {

        @Override
        public String getName() {
            return "Village Person";
        }
    }
}
