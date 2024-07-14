package ds.graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/course-schedule/">...</a>
 * 课程表
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class CanFinishTest {

    @Test
    public void test() {
        boolean res = canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(res);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建依赖关系
        Map<Integer, Set<Integer>> dependencies = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int c1 = prerequisite[0];
            int c2 = prerequisite[1];
            Set<Integer> d = dependencies.get(c1);
            if (d == null) {
                d = new HashSet<>();
            }
            d.add(c2);
            dependencies.put(c1, d);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        for (Integer i : dependencies.keySet()) {
            if (checkCircle(i, visited, stack, dependencies)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCircle(Integer i, Set<Integer> visited, Set<Integer> stack, Map<Integer, Set<Integer>> dependencies) {
        if (stack.contains(i)) {
            return true;
        }
        if (visited.contains(i)) {
            return false;
        }
        visited.add(i);
        stack.add(i);
        Set<Integer> d = dependencies.get(i);
        if (d != null) {
            for (Integer integer : d) {
                boolean circle = checkCircle(integer, visited, stack, dependencies);
                if (circle) {
                    return true;
                }
            }
        }
        stack.remove(i);
        return false;
    }

}
