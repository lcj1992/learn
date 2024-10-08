package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuangjian
 * @date 2023/8/26
 */
public class ContainsDuplicateTest {

    @Test
    public void test() {
        boolean res = containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println(res);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> existSet = new HashSet<>();
        for (int num : nums) {
            if (existSet.contains(num)) {
                return true;
            }
            existSet.add(num);
        }
        return false;
    }
}
