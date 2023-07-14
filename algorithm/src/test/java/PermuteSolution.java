import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Desc: 全排列
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/23
 * Time: 下午2:35
 */
public class PermuteSolution {

    public static void main(String[] args) {
        PermuteSolution solution = new PermuteSolution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> results = solution.permute(nums);
        System.out.println(results);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return permuteRecursion(input);
    }

    private List<List<Integer>> permuteRecursion(List<Integer> input) {
        List<List<Integer>> results = new ArrayList<>();
        if (input.size() == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(input.get(0));
            results.add(result);
            return results;
        }
        Integer first = input.get(0);
        List<List<Integer>> lists = permuteRecursion(input.subList(1, input.size()));
        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size() + 1; i++) {
                List<Integer> result = new ArrayList<>(list);
                result.add(i, first);
                results.add(result);
            }
        }
        return results;
    }
}
