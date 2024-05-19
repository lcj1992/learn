package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LargestNumberSolutionTest {

    @Test
    public void testLargestNumber() {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String result = largestNumber(nums);
        Assert.assertEquals(result, "9534330");
    }

    public String largestNumber(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                String order1 = num1 + "" + num2;
                String order2 = num2 + "" + num1;
                int temp;
                if (order2.compareTo(order1) > 0) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            results.add(nums[i]);
        }
        if (results.isEmpty()) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean zeroStart = true;
        for (Integer integer : results) {
            if (integer == 0 && zeroStart) {
                continue;
            }
            result.append(integer);
            zeroStart = false;
        }
        if (result.toString().isEmpty()) {
            return "0";
        }
        return result.toString();
    }
}
