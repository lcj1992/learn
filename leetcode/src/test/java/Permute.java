import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午11:40
 */
public class Permute {

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> param = new ArrayList<>();
        for (int num : nums) {
            param.add(num);
        }
        return permute(param);
    }

    public List<List<Integer>> permute(List<Integer> param) {
        List<List<Integer>> results = new ArrayList<>();
        if (param.size() == 1) {
            List<Integer> e = new ArrayList<>();
            results.add(e);
            e.add(param.get(0));
            return results;
        }

        Map<String, Boolean> placed = new HashMap<>();
        for (Integer integer : param) {
            List<Integer> subParam = new ArrayList<>(param);
            subParam.remove(integer);
            List<List<Integer>> subListResults = permute(subParam);
            for (List<Integer> subListResult : subListResults) {
                List<Integer> result = new ArrayList<>();
                result.add(integer);
                result.addAll(subListResult);
                String collect = result.stream().map(String::valueOf).collect(Collectors.joining());
                if (null == placed.get(collect) || !placed.get(collect)) {
                    results.add(result);
                    placed.put(collect, true);
                }
                List<Integer> result2 = new ArrayList<>();
                result2.addAll(subListResult);
                result2.add(integer);
                String collect1 = result2.stream().map(String::valueOf).collect(Collectors.joining());
                if (null == placed.get(collect1) || !placed.get(collect1)) {
                    results.add(result2);
                    placed.put(collect1, true);
                }
            }
        }
        return results;
    }
}
