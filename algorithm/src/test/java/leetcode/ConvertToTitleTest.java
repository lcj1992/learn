package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuangjian
 * @date 2023/8/17
 */
public class ConvertToTitleTest {

    @Test
    public void test() {
        String res = convertToTitle(701);
        System.out.println(res);
    }

    public String convertToTitle(int columnNumber) {
        List<Character> result = new ArrayList<>();
        Map<Integer, Character> letterMap = new HashMap<>();
        letterMap.put(1, 'A');
        letterMap.put(2, 'B');
        letterMap.put(3, 'C');
        letterMap.put(4, 'D');
        letterMap.put(5, 'E');
        letterMap.put(6, 'F');
        letterMap.put(7, 'G');
        letterMap.put(8, 'H');
        letterMap.put(9, 'I');
        letterMap.put(10, 'J');
        letterMap.put(11, 'K');
        letterMap.put(12, 'L');
        letterMap.put(13, 'M');
        letterMap.put(14, 'N');
        letterMap.put(15, 'O');
        letterMap.put(16, 'P');
        letterMap.put(17, 'Q');
        letterMap.put(18, 'R');
        letterMap.put(19, 'S');
        letterMap.put(20, 'T');
        letterMap.put(21, 'U');
        letterMap.put(22, 'V');
        letterMap.put(23, 'W');
        letterMap.put(24, 'X');
        letterMap.put(25, 'Y');
        letterMap.put(26, 'Z');
        while (columnNumber > 0) {
            int i = columnNumber % 26;
            Character character;
            if (i != 0) {
                character = letterMap.get(i);
                columnNumber = columnNumber / 26;
            } else {
                character = 'Z';
                columnNumber = columnNumber / 26 - 1;
            }
            result.add(character);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    public String convertToTitle2(int columnNumber) {
        List<Character> result = new ArrayList<>();
        while (columnNumber > 0) {
            columnNumber--;
            char i = (char) (columnNumber % 26 + 'A');
            columnNumber = columnNumber / 26;
            result.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }
}
