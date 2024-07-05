package algo.math;

import org.junit.Test;

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
    }

    /**
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solutions/1/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     */
    public int findTheWinner(int n, int k) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + k) % i;
        }
        return x + 1;
    }

}
