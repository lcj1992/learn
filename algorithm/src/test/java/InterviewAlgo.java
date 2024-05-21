public class InterviewAlgo {
    // 数组
    // SpiralArraySolution，二维数组顺时针打印，https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
    // SearchMatrixSolution，搜索二维矩阵，https://leetcode.cn/problems/search-a-2d-matrix/
    // ArrayTest#testGenerateMatrix，给定数字打印矩阵
    // 1  2  6  7
    // 3  5  8  13
    // 4  9  12 14
    // 10 11 15 16
    // TODO 数组中元素与下一个比它大的元素之间的距离

    // 线性表
    // RemoveZeroSumSublistsSolution，移除链表中连续和为0的元素，前缀和，https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
    // ReverseListSolution，反转链表，https://leetcode.cn/problems/UHnkqh/description/
    // ReverseKGroupSolutionTest，间隔k位反转链表，间隔2位反转链表，https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
    // ReverseBetweenTest， 反转链表，left到right之间的，https://leetcode.cn/problems/reverse-linked-list-ii/description/
    // TODO 两个链表相乘，1->9->null,3->2->null 返回 6->0->8 不能遍历后变成整数直接计算
    // kthToLastSolution，链表中倒数第k个元素，双指针，https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/submissions/532884868/
    // 删除链表倒数第k个元素，https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
    // TODO 奇数位升序偶数位降序链表排序
    // TODO LRU缓存机制
    // TODO 找两个队列里的相同元素
    // MergeKListsTest，merge k sorted list，https://leetcode.cn/problems/merge-k-sorted-lists/description/

    // 图
    // GraphTest，给定微服务集群中的调用关系，例如：[('A', 'B'), ('B', 'C'), ('C', 'D'), ('D', 'A')]，看是否存在循环调用

    // 二叉树
    // BinaryTreeTraversalTest，二叉树的前中后序遍历、层序遍历、是否子树、是否完全相同、共同子结构
    // 判断一个二叉树是否是另一个二叉树的子树，https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
    // BinaryTreeTraversalTest#testMidNodeSum，树的非叶子节点求和
    // TODO 镜像二叉树
    // TODO 从右边看二叉树输出；平衡二叉树，优化
    // TODO 找出二叉树中所有路径节点值相加为指定值的路径
    // TODO 二叉树中，查找所有根到叶子节点的和为 target 的路径
    // TODO 二叉搜索树的第k大节点
    // TODO 两棵二叉树，寻找他们共同子结构，给出相同子结构的节点数量
    // TODO 二叉树其他题目，https://blog.csdn.net/LaoJiu_/article/details/66974736

    // 排序
    // LargestNumberSolutionTest，最大数，本质上还是排序，自定义排序逻辑而已。给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数，https://leetcode.cn/problems/largest-number/solutions/27403/179-by-ikaruga/

    // 查找
    // SearchSolution，搜索旋转排序数组，https://leetcode.cn/problems/search-in-rotated-sorted-array
    // SearchMatrixSolution，搜索二维矩阵，https://leetcode.cn/problems/search-a-2d-matrix/
    // SearchRangeSolution，给定一个升序整型数组，如[1,2,2,3,4,5,5,6]，给定一个target，找到开始index和结束index，如target=2返回[1,2]，target=3返回[3,3]，如果target不存在，则返回[-1,-1]，如target=7返回[-1,-1]。二分查找变种，两种思路，一种是找到后暴力探索，https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

    // 双指针，滑动窗口
    // LengthOfLongestSubstringKDistinctSolution，至多包含 K 个不同字符的最长子串，和最长无重复子串类似，https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/description/
    // LengthOfLongestSubStringSolution，map记录出现过的字符，调整left指针，最大长度即为当前值和（当前指针-left指针+1）两者的最大值；要求输出重复最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/3982/hua-dong-chuang-kou-by-powcai/
    // ContainCharArrayTest，tibcacbdata，问能否在这个字符串中找到一个长度为m的连续子串，使得这个子串刚好由上面m个字符组成，顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1，时间复杂度On，比如上面这个例子，acbd，3。https://cloud.tencent.com/developer/article/2285729
    // kthToLastSolution，链表中倒数第k个元素，双指针

    // 动态规划
    // Knapsack01Test，01背包问题，状态转移方程：dp[i][j] = Math.max(dp[i - 1][j], (v[i - 1] + dp[i - 1][j - w[i - 1]])); dp[i][j] = dp[i-1][j]
    // LengthOfLISTest，最长上升子序列，状态转移方程：dp[i]=max(dp[j])+1，其中0≤j<i且num[j]<num[i]，https://leetcode.cn/problems/longest-increasing-subsequence/description/
    // LongestCommonSubsequenceTest，最长公共子序列，状态转移方程：https://leetcode.cn/problems/qJnOS7/description/
    // LongestPalindromeTest，最长回文子串
    // FindNumberOfLISTest

    // TODO 回溯
    // TODO 全排列
    // TODO N皇后

    // 其他
    // TODO YSFCircleTest 约瑟夫问题，https://blog.csdn.net/longintchar/article/details/75150621
    // Three6AddSolution，36进制加法
    // TODO 进制转换


}
