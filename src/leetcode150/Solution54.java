package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:29 2024/7/25
 */
public class Solution54 {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int curDir = 0;
        boolean[][] record = new boolean[matrix.length][matrix[0].length];
        int m = matrix.length, n = matrix[0].length;
        int total = m * n;
        int row = 0, col = 0, index = 0;
        while (index < total) {
            result.add(matrix[row][col]);
            record[row][col] = true;
            int curRow = row + directions[curDir][0];
            int curCol = col + directions[curDir][1];
            if (curRow < 0 || curRow >= m || curCol < 0 || curCol >= n || record[curRow][curCol])
                curDir = (curDir + 1) % 4;
            row += directions[curDir][0];
            col += directions[curDir][1];
            index++;
        }
        return result;
    }
}