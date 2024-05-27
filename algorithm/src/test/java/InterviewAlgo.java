public class InterviewAlgo {
    // TODO 需明确各算法的复杂度以及使用场景
    // 滑动窗口是TCP的拥塞控制上
    // 图，循环依赖问题；pipeline应用框架，启动顺序问题；压测稳定性基于调用链路输出依赖关系图
    // cache，LRU，FIFO

    // 数组
    // SpiralArrayTest，螺旋遍历二维数组
    // SearchMatrixTest，搜索二维矩阵
    // ArrayTest#testGenerateMatrix，给定数字打印矩阵
    // 1  2  6  7
    // 3  5  8  13
    // 4  9  12 14
    // 10 11 15 16
    // TODO 数组中元素与下一个比它大的元素之间的距离
    // 区间融合，MergeIntervalsTest
    // 会议室，CanAttendMeetingsTest
    // 安排会议室，有一个包含开始时间和结束时间(0~24，精确到 0.5)的二维数组，确定需要的最少会议室。会议室问题变种

    // 线性表
    // RemoveZeroSumSublistsTest，移除链表中连续和为0的元素
    // ReverseListTest，反转链表
    // ReverseKGroupTest，间隔k位反转链表，间隔2位反转链表
    // ReverseBetweenTest， 反转链表，left到right之间的
    // TODO 两个链表相乘，1->9->null,3->2->null 返回 6->0->8 不能遍历后变成整数直接计算
    // kthToLastTest，链表中倒数第k个元素，双指针
    // RemoveNthFromEndTest，删除链表倒数第k个元素
    // TODO 奇数位升序偶数位降序链表排序，https://blog.csdn.net/xun_zhao_t521/article/details/119683806
    // TODO LRU缓存机制
    // TODO 找两个队列里的相同元素
    // TODO MergeKListsTest，合并多个有序链表，merge k sorted list


    // 图
    // GraphTest，给定微服务集群中的调用关系，例如：[('A', 'B'), ('B', 'C'), ('C', 'D'), ('D', 'A')]，看是否存在循环调用
    // TODO 输入一个 List<List<Integer>>，每个 List 的前一个元素依赖后一个元素(想象成一个分布式系统，必须我所依赖的项目都启动了，我才能启动)，如何确定最优的启动顺序


    // 二叉树
    // BinaryTreeTraversalTest，二叉树的前中后序遍历、层序遍历、是否子树、是否完全相同、共同子结构
    // testSubTree， 判断一个二叉树是否是另一个二叉树的子树
    // BinaryTreeTraversalTest#testMidNodeSum，树的非叶子节点求和
    // TODO 镜像二叉树
    // TODO 从右边看二叉树输出；平衡二叉树，优化
    // TODO 找出二叉树中所有路径节点值相加为指定值的路径
    // TODO 二叉树中，查找所有根到叶子节点的和为 target 的路径
    // TODO 二叉搜索树的第k大节点
    // TODO 两棵二叉树，寻找他们共同子结构，给出相同子结构的节点数量
    // TODO 二叉树其他题目，https://blog.csdn.net/LaoJiu_/article/details/66974736


    // 排序
    // TODO 12. 在有序数组里查询一个数，数组里数相等的情况取最小 idx
    // LargestNumberTest，最大数


    // 查找
    // SearchTest，搜索旋转排序数组
    // SearchMatrixTest，搜索二维矩阵
    // SearchRangeTest，在排序数组中查找元素的第一个和最后一个位置


    // 双指针，滑动窗口
    // LengthOfLongestSubstringKDistinctTest，至多包含 K 个不同字符的最长子串
    // LengthOfLongestSubStringTest，最长无重复子串
    // ContainCharArrayTest，tibcacbdata，问能否在这个字符串中找到一个长度为m的连续子串，使得这个子串刚好由上面m个字符组成，顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1，时间复杂度On，比如上面这个例子，acbd，3。https://cloud.tencent.com/developer/article/2285729
    // kthToLastTest，链表中倒数第k个元素
    // RemoveNthFromEndTest，移除倒数第n个元素
    // MaxSlidingWindowTest，滑动窗口最大值


    // 动态规划
    // Knapsack01Test，01背包问题
    // LengthOfLISTest，最长上升子序列
    // LongestCommonSubsequenceTest，最长公共子序列
    // LongestPalindromeTest，最长回文子串
    // FindNumberOfLISTest


    // 回溯
    // PermuteTest，全排列
    // SolveNQueensTest，N皇后问题


    // 贪心
    // 分发糖果
    // 设计模式
    // DoubleCheckVersion，单例模式


    // 其他
    // Three6AddTest，36进制加法
    // TODO YSFCircleTest 约瑟夫问题
    // TODO 手写一致性 hash 算法的应用场景，请求进来怎么通过一致性哈希算法 找到实际的机器 IP 的代码实现 过程
    // TODO 进制转换
    // TODO 在2.5亿个整数中找出不重复的整数，内存不足以容纳这2.5亿个整数
    // TODO 红黑树的数据结构
    // TODO 比如十几亿个数据里找到较小的100个数
    // TODO topK 算法
    //  另一个最大岛
    // TODO 有一个数字矩阵，包含0和1，相邻的数字1代表“陆地”;给出某个坐标，求该坐标对应的陆地面积 (即有多少个相邻的 1)?在矩阵很大的情况下，有没有更快的办法?
    // TODO 再加一个堆插入结点的步骤
    // TODO 最后一题常规股票买卖
    // TODO 牛客的跳石板、合并区间、找出出现超过一半的数
    // TODO 三数之和

}
