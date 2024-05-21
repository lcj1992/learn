package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午11:40
 */
public class PermuteTest {

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
        System.out.println("-------------");
        permute = permute2(new int[]{1, 2, 3});
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
                List<Integer> result2 = new ArrayList<>(subListResult);
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

    public List<List<Integer>> permute2(int[] nums) {
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
