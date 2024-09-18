package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:27 2024/8/31
 */
public class PerfectRectangles {
    public static int[] countPerfectSubmatrices(int[][] matrix) {
        int n = matrix.length;
        int[][] prefixSum = new int[n + 1][n + 1];
        int[] result = new int[n + 1];

        // 计算前缀和矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        // 遍历所有可能的尺寸 i * i
        for (int i = 1; i <= n; i++) {
            for (int r = i; r <= n; r++) {
                for (int c = i; c <= n; c++) {
                    int sum = prefixSum[r][c]
                            - prefixSum[r - i][c]
                            - prefixSum[r][c - i]
                            + prefixSum[r - i][c - i];
                    if (sum * 2 == i * i) { // 0 的数量等于 1 的数量
                        result[i]++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            String next = scanner.next();
            for(int j=0;j<n;j++){
//                char c = next.charAt(j);
                matrix[i][j]=Integer.parseInt(next.substring(j,j+1));
            }
        }

        int[] result = countPerfectSubmatrices(matrix);

        for (int i = 1; i < result.length; i++) {
            System.out.println("Size " + i + "x" + i + ": " + result[i]);
        }
    }
}
