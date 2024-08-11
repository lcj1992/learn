package ds.graph;

import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-to-reach-city-with-discounts/">...</a>
 */
public class MinimumCostTest {

    @Test
    public void test() {
        int res = minimumCost(4, new int[][]{{1, 3, 17}, {1, 2, 7}, {3, 2, 5}, {0, 1, 6}, {3, 0, 20}}, 20);
        System.out.println(res);
    }

    static class Node {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    List<Node> g = new ArrayList<>();

    int[][] edges;
    int[] distTo;
    boolean[] vis;
    int n, st, et, cnt;
    final int INF = 0x3f3f3f3f;

    void init1() {
        // init g
        g.clear();
        for (int[] edge : edges) {
            g.add(new Node(edge[0], edge[1], edge[2]));
            g.add(new Node(edge[1], edge[0], edge[2]));
        }
        // init distTo
        distTo = new int[n];
        Arrays.fill(distTo, INF);
        distTo[0] = 0;
    }

    void init2() {
        // init g
        g.clear();
        for (int[] edge : edges) {
            g.add(new Node(edge[0], edge[1], edge[2] / 2));
            g.add(new Node(edge[1], edge[0], edge[2] / 2));
        }
    }

    void SPFA(int cnt) {
        Queue<Integer> q = new LinkedList<>();
        vis = new boolean[n];
        Arrays.fill(vis, false);
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty() && cnt-- > 0) {
            int top = q.poll();
            vis[top] = false;
            int[] back = distTo.clone();
            for (int i = 0; i < g.size(); i++) {
                Node node = g.get(i);
                int a = node.a, b = node.b, c = node.c;
                if (back[a] + c < distTo[b]) {
                    distTo[b] = back[a] + c;
                    if (!vis[b]) {
                        q.add(b);
                        vis[b] = true;
                    }
                }
            }
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/minimum-cost-to-reach-city-with-discounts/solutions/1861743/liang-ci-bellman-by-huyuanyuan-yiwp/?envType=study-plan-v2&envId=pdd-2023-fall-sprint">...</a>
     */
    public int minimumCost(int n, int[][] highways, int discounts) {
        this.edges = highways;
        this.n = n;
        this.st = 0;
        this.et = n - 1;
        this.cnt = discounts;
        init1();
        SPFA(n);
        init2();
        SPFA(cnt);
        int res = distTo[n - 1];
        if (res > INF / 2) {
            return -1;
        }
        return res;
    }

}
