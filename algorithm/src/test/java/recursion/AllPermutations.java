package recursion;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/23
 * Time: 下午2:35
 */
public class AllPermutations {

    public static void main(String[] args) {
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        Set result = allPermutations(set);
        System.out.println(result);
    }

    private static Set<String> allPermutations(Set<Integer> set) {
        Preconditions.checkNotNull(set);
        Preconditions.checkArgument(!set.isEmpty());
        Set<String> result = Sets.newHashSet();
        for (Integer integer : set) {
            Set<Integer> newSet = Sets.newHashSet(set);
            if (newSet.size() == 1) {
                return Sets.newHashSet(newSet.iterator().next().toString());
            }
            newSet.remove(integer);
            Set<String> strings = allPermutations(newSet);
            for (String string : strings) {
                result.add(string + integer.toString());
                result.add(integer.toString() + string);
            }
        }
        return result;
    }
}
