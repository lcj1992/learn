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

    boolean backtrack(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = backtrack(board, word, i + 1, j, k + 1) || backtrack(board, word, i - 1, j, k + 1) || backtrack(board, word, i, j + 1, k + 1) || backtrack(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
