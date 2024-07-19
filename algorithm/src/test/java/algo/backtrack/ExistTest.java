package algo.backtrack;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/word-search/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class ExistTest {

    @Test
    public void test() {
        boolean res = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println(res);
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, char[] word, int rowId, int colId, int k) {
        if (rowId >= board.length || rowId < 0 || colId >= board[0].length || colId < 0 || board[rowId][colId] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[rowId][colId] = '\0';
        // 向下
        boolean res = backtrack(board, word, rowId + 1, colId, k + 1)
                // 向上
                || backtrack(board, word, rowId - 1, colId, k + 1)
                // 向左
                || backtrack(board, word, rowId, colId + 1, k + 1)
                // 向右
                || backtrack(board, word, rowId, colId - 1, k + 1);
        board[rowId][colId] = word[k];
        return res;
    }
}
