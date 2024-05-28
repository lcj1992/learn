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





    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



    示例 1：

    输入：[1,2,3,1]
    输出：4
    解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    偷窃到的最高金额 = 1 + 3 = 4 。
    示例 2：

    输入：[2,7,9,3,1]
    输出：12
    解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    偷窃到的最高金额 = 2 + 9 + 1 = 12 。

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/house-robber/solutions/263856/da-jia-jie-she-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

    在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

    返回 你能获得的 最大 利润 。



    示例 1：

    输入：prices = [7,1,5,3,6,4]
    输出：7
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
    总利润为 4 + 3 = 7 。
    示例 2：

    输入：prices = [1,2,3,4,5]
    输出：4
    解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    总利润为 4 。
    示例 3：

    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。


    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/476791/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int n = prices.length;
            for (int i = 1; i < n; ++i) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/476791/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。



    示例 1：


    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    输出：7
    解释：因为路径 1→3→1→1→1 的总和最小。
    示例 2：

    输入：grid = [[1,2,3],[4,5,6]]
    输出：12

    class Solution {
        public int minPathSum(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(i == 0 && j == 0) continue;
                    else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }

    作者：Krahets
    链接：https://leetcode.cn/problems/minimum-path-sum/solutions/25943/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    从前序与中序遍历序列构造二叉树

    class Solution {
        private Map<Integer, Integer> indexMap;

        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。



    示例 1：

    输入：a = 1, b = 2
    输出：3
    示例 2：

    输入：a = 2, b = 3
    输出：5

    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/sum-of-two-integers/solutions/1017617/liang-zheng-shu-zhi-he-by-leetcode-solut-c1s3/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
