package interview;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:36 2024/9/19
 */
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrays {

    // 检查数组是否为升序或降序
    private static boolean isSorted(int[] array) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) ascending = false;
            if (array[i] > array[i - 1]) descending = false;
        }

        return ascending || descending;
    }

    // 判断是否可以通过无限次交换使得至少一个数组有序
    private static boolean canBeSorted(int[] a, int[] b) {
        int n = a.length;
        int[] combined = new int[2 * n];

        // 合并数组 a 和 b
        System.arraycopy(a, 0, combined, 0, n);
        System.arraycopy(b, 0, combined, n, n);

        // 检查合并后的数组是否有序
        return isSorted(combined);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 数据组数

        while (T-- > 0) {
            int n = scanner.nextInt(); // 数组长度
            int[] a = new int[n];
            int[] b = new int[n];

            // 读取数组 a
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // 读取数组 b
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            // 判断是否可以排序
            if (canBeSorted(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
