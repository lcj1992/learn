package math;

/**
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 * 找出游戏的获胜者
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class FindTheWinnerTest {

    public int findTheWinner(int n, int k) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + k) % i;
        }
        return x + 1;
    }

}
