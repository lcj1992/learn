package algo.bfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/shortest-path-in-a-grid-with-obstacles-elimination/">...</a>
 */
public class ShortestPathTest {

    @Test
    public void test() {
        int res = shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1);
        System.out.println(res);
    }

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Create a queue to store the state of each cell
        Queue<int[]> queue = new LinkedList<>();
        // Create a 2D array to store the number of obstacles eliminated at each cell
        int[][] obstaclesEliminated = new int[rows][cols];

        // Initialize the obstaclesEliminated array with a large value (m * n)
        for (int[] row : obstaclesEliminated) {
            Arrays.fill(row, k + 1);
        }

        // Start from the top-left cell (0, 0) with 0 obstacles eliminated
        queue.offer(new int[]{0, 0});
        obstaclesEliminated[0][0] = 0;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];

                // If we reach the bottom-right cell, return the number of steps
                if (row == rows - 1 && col == cols - 1) {
                    return steps;
                }

                // Explore the four adjacent cells
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check if the new cell is within the grid boundaries
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        // Calculate the obstacles eliminated at the new cell
                        int newObstaclesEliminated = obstaclesEliminated[row][col] + grid[newRow][newCol];

                        // If the new cell has fewer obstacles eliminated and is within the limit k
                        if (newObstaclesEliminated < obstaclesEliminated[newRow][newCol]) {
                            //经过障碍物更少的，只是入队了，不一定能访问到
                            //同一个坐标，可能会重复入队
                            // 看上面的例子
                            // Update the obstacles eliminated at the new cell
                            obstaclesEliminated[newRow][newCol] = newObstaclesEliminated;
                            // Add the new cell to the queue
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }

            // Increment the number of steps
            steps++;
        }

        // If no path is found, return -1
        return -1;
    }

}
