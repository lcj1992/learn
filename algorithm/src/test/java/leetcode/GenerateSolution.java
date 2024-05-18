package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/8/15
 */
public class GenerateSolution {

    public static void main(String[] args) {
        GenerateSolution solution = new GenerateSolution();
        List<List<Integer>> generate = solution.generate(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> before = new ArrayList<>();
        for (int i = 1; i < numRows + 1; i++) {
            List<Integer> result = new ArrayList<>(i + 1);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    result.add(1);
                    continue;
                }
                result.add(before.get(j - 1) + before.get(j));
            }
            results.add(result);
            before = result;
        }
        return results;
    }
}
