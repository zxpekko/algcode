package leetcode150;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:环形数组石子
 * @Date:13:58 2024/8/19
 */
public class AcSolution1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int max = getMinOrMax(arr, true);
        int min = getMinOrMax(arr, false);
        System.out.println(min);
        System.out.println(max);
//        AcSolution1068 acSolution1068 = new AcSolution1068();
        System.out.println(AcSolution1068Ⅰ.getMinOrMax(arr, false));
        System.out.println(AcSolution1068Ⅰ.getMinOrMax(arr, true));
    }


    public static int getMinOrMax(int[] arr, boolean max) {
        int n = arr.length;
        int[] pre = new int[2 * n + 1];
        int[] newArr = new int[2 * n];
        int[][] dp = new int[2 * n + 1][2 * n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
            newArr[i + n] = arr[i];
        }
        for (int i = 1; i <= 2 * n; i++) {
            pre[i] = pre[i - 1] + newArr[i - 1];
        }
        for (int len = 2; len <= 2*n; len++) {
            for (int i = 1; i + len - 1 <= 2 * n; i++) {
                int j = i + len - 1;
                if (max) {
                    dp[i][j] = Integer.MIN_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][k] + dp[k + 1][j] + pre[j] - pre[i - 1], dp[i][j]);
                    }
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + pre[j] - pre[i - 1], dp[i][j]);
                    }
                }
            }
        }
        if (max) {
            int result = 0;
            for (int i = 1; i + n - 1 < dp.length; i++) {
                result = Math.max(result, dp[i][i + n - 1]);
            }
            return result;
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i + n - 1 < dp.length; i++) {
                if(dp[i][i+n-1]!=0)
                    result = Math.min(result, dp[i][i + n - 1]);
            }
            return result==Integer.MAX_VALUE?0:result;
        }
    }
}
class AcSolution1068Ⅰ{
    public static int getMinOrMax(int[] arr, boolean max){
        int n=arr.length;
        int[] pre = new int[2 * n + 1];

        int[][] dp = new int[2 * n + 1][2 * n + 1];
        int[] newArr = new int[2 * n];
        for(int i=0;i<n;i++){
            newArr[i]=arr[i];
            newArr[i+n]=arr[i];
        }
        for(int i=1;i<=2*n;i++){
            pre[i]=pre[i-1]+newArr[i-1];
        }
        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=2*n;i++){
                int j=i+len-1;
                if(max){
                    dp[i][j]=Integer.MIN_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.max(dp[i][k]+dp[k+1][j]+pre[j]-pre[i-1],dp[i][j]);
                    }
                }
                else {
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+pre[j]-pre[i-1]);
                    }
                }
            }
        }
        if(max){
            int result=0;
            for(int i=0;i+n-1<=2*n;i++){
                result=Math.max(result,dp[i][i+n-1]);
            }
            return result;
        }
        else {
            int result=Integer.MAX_VALUE;
            for(int i=0;i+n-1<2*n;i++){
                if(dp[i][i+n-1]!=0)
                    result=Math.min(result,dp[i][i+n-1]);
            }
            return result;
        }
    }
}