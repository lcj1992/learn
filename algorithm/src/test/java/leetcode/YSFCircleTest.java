package leetcode;

import org.junit.Test;

public class YSFCircleTest {

    @Test
    public void test() {
        int n = 5; // 总人数
        int m = 1; // 开始计数的位置
        int k = 2; // 每数 k 个人，第 k 个人会被杀掉

        int result = josephus(n, m, k);
        System.out.println("The winner is: " + result);

    }

    public static int josephus(int n, int m, int k) {
        if (n == 1) return 0; // 如果只有一个人，那么他肯定是赢家

        int[] people = new int[n]; // 创建一个数组来表示围成一圈的人
        for (int i = 0; i < n; i++) {
            people[i] = i;
        }

        int count = 0;
        int index = m - 1; // 将索引调整为从 0 开始

        while (true) {
            if (count == k - 1) {
                // 当计数达到 k-1 时，移除第 k 个人
                people[index] = -1; // 用 -1 表示这个人已经被杀掉
                count = 0; // 重置计数器
                // 移动到下一个有效人的位置
                while (people[index] == -1) {
                    index = (index + 1) % n;
                }
            }

            // 计数递增
            count++;
            index = (index + 1) % n; // 移动到下一个人

            // 如果只剩下一个人，返回其索引
            if (count == n) {
                for (int i = 0; i < n; i++) {
                    if (people[i] != -1) {
                        return i;
                    }
                }
            }
        }
    }
}
