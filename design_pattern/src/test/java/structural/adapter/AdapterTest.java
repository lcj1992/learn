package structural.adapter;

import org.junit.Test;

public class AdapterTest {
    @Test
    public void test() {
        USPowerOutlet usOutlet = new USWallSocket();
        EuropeanAppliance adapter = new VoltageAdapter(usOutlet);
        EuropeanAppliance europeanDevice = new EuropeanHairDryer();

        // 使用适配器让欧洲电器设备在美国电源插座上运行
        adapter.plugIn();
        adapter.powerOn();
        europeanDevice.powerOn();
    }

    public interface EuropeanAppliance {
        void plugIn();

        void powerOn();
    }

    public static class EuropeanHairDryer implements EuropeanAppliance {
        @Override
        public void plugIn() {
            System.out.println("Plugged in using a round plug.");
        }

        @Override
        public void powerOn() {
            System.out.println("Device is on and running at 230V");
        }
    }

    public interface USPowerOutlet {
        void providePower();
    }

    public static class USWallSocket implements USPowerOutlet {
        @Override
        public void providePower() {
            System.out.println("Providing 120V AC through flat prongs.");
        }
    }

    public static class VoltageAdapter implements EuropeanAppliance {
        private final USPowerOutlet outlet;

        public VoltageAdapter(USPowerOutlet outlet) {
            this.outlet = outlet;
        }

        @Override
        public void plugIn() {
            outlet.providePower();
            System.out.println("Adapter converted voltage to 230V");
        }

        @Override
        public void powerOn() {
            System.out.println("Adapter powering device");
        }
    }
}
