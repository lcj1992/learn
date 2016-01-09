package creational.staticfactory;


import java.util.Calendar;

/**
 * Created by lcj on 15-10-31.
 */

interface IPeople {
    String getName();
}

class CityPeople implements IPeople {
    @Override
    public String getName() {
        return "city People";
    }
}

class Villager implements IPeople {

    @Override
    public String getName() {
        return "Village Person";
    }
}

enum PeopleType {
    RURAL,
    URBAN;
}


public class StaticFactoryTest {

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

    public static void main(String[] args) {
        StaticFactoryTest test = new StaticFactoryTest();
        System.out.println(test.getPeople(PeopleType.URBAN).getName());

        Calendar calendar = Calendar.getInstance();

    }
}
