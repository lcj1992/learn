import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/8/15
 */
public class GetRowSolution {

    public static void main(String[] args) {
        GetRowSolution solution = new GetRowSolution();
        List<Integer> row = solution.getRow(3);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        }
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> before = new ArrayList<>();
        for (int i = 1; i < rowIndex + 2; i++) {
            List<Integer> result = new ArrayList<>(i + 1);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    result.add(1);
                    continue;
                }
                result.add(before.get(j - 1) + before.get(j));
            }
            results.add(result);
            before = result;
        }
        return results.get(results.size() - 1);
    }
}
