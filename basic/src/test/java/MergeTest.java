import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/11
 * Time: 下午1:47
 */
public class MergeTest {
    public List<Character> mergeArray(List<Character> array1, List<Character> array2) {
        if (CollectionUtils.isEmpty(array1)) {
            return Lists.newArrayList(array2);
        }
        if (CollectionUtils.isEmpty(array2)) {
            return Lists.newArrayList(array1);
        }
        int array1Size = array1.size();
        int array2Size = array2.size();
        int maxSize = Math.max(array1Size, array2Size);
        List<Character> results = Lists.newArrayList();
        for (int i = 0; i < maxSize; i++) {
            if (i < array1Size) {
                results.add(array1.get(i));
            }
            if (i < array2Size) {
                results.add(array2.get(i));
            }
        }
        return results;
    }

    public List<Character> mergeAnyArray(List<List<Character>> inputParam) {
        // 最长数组的长度
        int maxSize = inputParam.stream().mapToInt(List::size).max().getAsInt();

        // 数组的个数
        int arraySize = inputParam.size();
        List<Character> results = Lists.newArrayList();

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (i < inputParam.get(j).size()) {
                    results.add(inputParam.get(j).get(i));
                }
            }
        }
        return results;
    }

    @Test
    public void testMerge() throws Exception {
        List<Character> array1 = Lists.newArrayList('1', '2', '3', '4', '5');
        List<Character> array2 = Lists.newArrayList('a', 'b', 'c');
        List<List<Character>> inputArray = Lists.newArrayList(array1, array2);

        List<Character> expectedResult = Lists.newArrayList('1', 'a', '2', 'b', '3', 'c', '4', '5');
        List<Character> actualResult1 = mergeArray(array1, array2);
        List<Character> actualResult2 = mergeAnyArray(inputArray);

        Assert.assertTrue(isEquals(expectedResult, actualResult1));
        Assert.assertTrue(isEquals(expectedResult, actualResult2));
    }

    private boolean isEquals(List<Character> expectedResult, List<Character> actualResult) {
        boolean sizeEqual = !CollectionUtils.isEmpty(expectedResult) &&
                !CollectionUtils.isEmpty(actualResult) &&
                expectedResult.size() == actualResult.size();
        if (!sizeEqual) {
            return false;
        }
        for (int i = 0; i < expectedResult.size(); i++) {
            if (!expectedResult.get(i).equals(actualResult.get(i))) {
                return false;
            }
        }
        return true;
    }

}
