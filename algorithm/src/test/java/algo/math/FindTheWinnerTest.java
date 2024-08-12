package algo.math;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/find-the-winner-of-the-circular-game/">...</a>
 * 找出游戏的获胜者,约瑟夫环
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class FindTheWinnerTest {

    @Test
    public void test() {
        int res = findTheWinner(10, 3);
        System.out.println(res);
        res = findTheWinner2(10, 3);
        System.out.println(res);
    }

    /**
     * <a href="https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solutions/1/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/">...</a>
     */
    public int findTheWinner(int n, int k) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + k) % i;
        }
        return x + 1;
    }

    public int findTheWinner2(int n, int k) {
        if (k == 1) {
            return n;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        while (deque.size() > 1) {
            for (int i = 1; i < k; i++) {
                int x = deque.removeFirst();
                deque.addLast(x);
            }
            deque.removeFirst();
        }
        return deque.removeFirst();
    }

}
