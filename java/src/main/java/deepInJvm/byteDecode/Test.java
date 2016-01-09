package deepInJvm.byteDecode;

import java.io.IOException;

/**
 * Created by lcj on 15-6-11.
 */
public class Test {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        String fileName = "/home/lcj/TestClass.class";
        JavapVerbose javapVerbose = new JavapVerbose(fileName);
        javapVerbose.conduct();
    }
}
