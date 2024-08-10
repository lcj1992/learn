package leetcode;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午10:39
 */
public class GetImportanceTest {

    @Test
    public void test() {
        Employee employee3 = new Employee(3, 3, Lists.newArrayList());
        Employee employee2 = new Employee(2, 3, Lists.newArrayList());
        Employee employee = new Employee(1, 5, Lists.newArrayList(2, 3));
        int importance = getImportance(Lists.newArrayList(employee, employee2, employee3), 1);
        Assert.assertEquals(importance, 11);
    }

    @Test
    public void testDFS() {
        Employee employee3 = new Employee(3, 3, Lists.newArrayList());
        Employee employee2 = new Employee(2, 3, Lists.newArrayList());
        Employee employee = new Employee(1, 5, Lists.newArrayList(2, 3));
        int importance = getImportanceDFS(Lists.newArrayList(employee, employee2, employee3), 1);
        Assert.assertEquals(importance, 11);
    }


    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return 0;
        }
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(each -> each.id, each -> each));
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            return 0;
        }
        Stack<Employee> stack = new Stack<>();
        stack.push(employee);
        int result = 0;
        while (!stack.isEmpty()) {
            Employee top = stack.pop();
            result += top.importance;
            List<Integer> subordinates = top.subordinates;
            if (subordinates != null && !subordinates.isEmpty()) {
                subordinates.stream().map(employeeMap::get).filter(Objects::nonNull).forEach(stack::push);
            }
        }
        return result;
    }


    public int getImportanceDFS(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) {
            return 0;
        }
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(each -> each.id, each -> each));
        return dfs(id, employeeMap);
    }

    public int dfs(int eid, Map<Integer, Employee> employeeMap) {
        Employee employee = employeeMap.get(eid);
        int ans = employee.importance;
        for (Integer subId : employee.subordinates)
            ans += dfs(subId, employeeMap);
        return ans;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

    }
}
