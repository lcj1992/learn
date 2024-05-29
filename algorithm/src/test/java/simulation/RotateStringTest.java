package simulation;

/**
 * <a href="https://leetcode.cn/problems/rotate-string/description/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class RotateStringTest {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
