package lang;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

public class FinalTest {

    @Test
    public void test() {
        FinalObj finalObj = new FinalObj(10);
    }


    @Getter
    @Setter

    private static class FinalObj {

        private final int age;

        public FinalObj(int a) {
            this.age = a;
        }
    }
}


