public class Interview {
    // 数组
    // SpiralArraySolution，二维数组顺时针打印
    // SearchMatrixSolution，搜索二维矩阵
    // testGenerateMatrix，给定数组打印矩阵

    // 链表
    // RemoveZeroSumSublistsSolution，移除链表中连续和为0的元素，前缀和
    // ReverseListSolution，反转链表
    // ReverseKGroupSolutionTest，间隔k位反转链表，间隔2位反转链表
    // TODO 反转链表，left到right之间的
    // TODO 两个链表相乘，1->9->null,3->2->null 返回 6->0->8 不能遍历后变成整数直接计算
    // TODO 奇数位升序偶数位降序链表排序

    // 图
    // GraphTest，校验微服务集群是否存在循环依赖

    // 排序
    // LargestNumberSolutionTest，最大数，本质上还是排序，自定义排序逻辑而已

    // 二叉树
    // BinaryTreeTest，二叉树的前中后序遍历、层序遍历、是否子树、是否完全相同、共同子结构
    // TODO 镜像二叉树
    // TODO 从右边看二叉树输出；平衡二叉树，优化
    // TODO 找出二叉树中所有路径节点值相加为指定值的路径
    // TODO 二叉树中，查找所有根到叶子节点的和为 target 的路径
    // TODO 两棵二叉树，寻找他们共同子结构，给出相同子结构的节点数量

    // 查找
    // SearchSolution，搜索旋转排序数组
    // SearchRangeSolution，二分查找变种，两种思路，一种是找到后暴力探索

    // 双指针，滑动窗口
    // LengthOfLongestSubstringKDistinctSolution，和最长无重复子串类似
    // LengthOfLongestSubStringSolution，map记录出现过的字符，调整left指针，最大长度即为当前值和（当前指针-left指针+1）两者的最大值
    // ContainCharArrayTest，问能否在这个字符串中找到一个长度为m的连续子串
    // ContainCharArrayTest，tibcacbdata，问能否在这个字符串中找到一个长度为m的连续子串，使得这个子串刚好由上面m个字符组成，顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1，时间复杂度On，比如上面这个例子，acbd，3。
    // kthToLastSolution，链表中倒数第k个元素，双指针

    // 动态规划
    // Knapsack01Test，01背包问题，状态转移方程dp[i][j] = Math.max(dp[i - 1][j], (v[i - 1] + dp[i - 1][j - w[i - 1]]));
    // LengthOfLISTest，最长上升子序列，状态转移方程是dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
    // TODO 最长公共子序列

    // TODO 回溯
    // TODO 全排列
    // TODO N皇后

    // 其他
    // TODO YSFCircleTest 约瑟夫问题

}
