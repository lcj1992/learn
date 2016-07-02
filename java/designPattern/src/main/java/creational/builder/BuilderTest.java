package creational.builder;

import java.awt.*;

/**
 * Created by lcj on 15-10-31.
 */
public class BuilderTest {
    public static void main(String[] args) {
        StreetMap map = new StreetMap.Builder(new Point(50, 50), new Point(100,
                100)).landColor(Color.GRAY).waterColor(Color.BLUE.brighter())
                .build();
    }
}
