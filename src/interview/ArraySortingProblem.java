package interview;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:38 2024/9/19
 */
import java.util.Scanner;

import java.util.Scanner;

public class ArraySortingProblem {
    static boolean foundSolution = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            // 尝试所有可能的交换组合
            tryAllPermutations(a, b, 0, n);
            if (foundSolution) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    private static void tryAllPermutations(int[] a, int[] b, int index, int n) {
        if (index == n) {
            if (canSortArray(a) || canSortArray(b)) {
                foundSolution = true;
            }
            return;
        }
        // 不交换当前位置
        tryAllPermutations(a, b, index + 1, n);
        // 交换当前位置
        int temp = a[index];
        a[index] = b[index];
        b[index] = temp;
        tryAllPermutations(a, b, index + 1, n);
        // 恢复交换前的状态
        temp = a[index];
        a[index] = b[index];
        b[index] = temp;
    }

    private static boolean canSortArray(int[] arr) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                isIncreasing = false;
            }
            if (arr[i] > arr[i - 1]) {
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
}