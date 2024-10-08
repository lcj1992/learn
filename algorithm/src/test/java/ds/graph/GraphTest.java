package ds.graph;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.*;

public class GraphTest {


    @Test
    public void testCircle() {
        Map<String, Set<String>> dependencies = Maps.newHashMap();
        dependencies.put("A", Sets.newHashSet("B"));
        dependencies.put("B", Sets.newHashSet("C"));
        dependencies.put("C", Sets.newHashSet("D"));
        dependencies.put("D", Sets.newHashSet("E"));
        dependencies.put("E", Sets.newHashSet());
        boolean result = checkCircleDependency(dependencies);
        System.out.println(result);
    }

    public boolean checkCircleDependency(Map<String, Set<String>> dependencies) {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        List<String> results = new ArrayList<>();

        for (String node : dependencies.keySet()) {
            if (isCyclicUtil(node, visited, recStack, dependencies, results)) {
                return true;
            }
        }
        System.out.println(results);
        return false;
    }

    private boolean isCyclicUtil(String node, Set<String> visited, Set<String> recStack, Map<String, Set<String>> dependencies, List<String> results) {
        if (recStack.contains(node)) {
            return true; // 检测到循环依赖
        }
        if (visited.contains(node)) {
            return false; // 已经访问过该节点，不需要再次访问
        }
        visited.add(node);
        recStack.add(node);

        Set<String> children = dependencies.get(node);
        if (children != null) {
            for (String adjNode : children) {
                if (isCyclicUtil(adjNode, visited, recStack, dependencies, results)) {
                    return true;
                }
            }
        }
        recStack.remove(node);
        results.add(node);
        return false;
    }
}
