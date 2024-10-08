package algo.simulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class ZConvertTest {

    @Test
    public void test() {
        String res = convert("PAYPALISHIRING", 3);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        // 行的坐标
        int rowId = 0;
        // 调整行的坐标遍历
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(rowId).append(c);
            if (rowId == 0 || rowId == numRows - 1) {
                flag = -flag;
            }
            rowId += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
