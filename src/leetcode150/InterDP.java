package leetcode150;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:定义一个数组的权值是这个数组的最大值减最小值。
 * 现在有一个数组，想把这个数组剪切成若干个不相交的子数组，求所有子数组的权值之和。
 * 输入第一个整数代表长度，然后n个整数代表数组。用java写
 * @Date:19:57 2024/8/24
 */
public class InterDP {
    public static void main(String[] args) {
        InterDP interDP = new InterDP();
        System.out.println(interDP.divide(new int[]{1, 4, 1, 4, 10, 6}));
    }
    public int divide(int[] nums){
        int n=nums.length;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for(int i=0;i<n;i++){
            max[i][i]=nums[i];
            min[i][i]=nums[i];
            for(int j=i+1;j<n;j++){
                max[i][j]=Math.max(max[i][j-1],nums[j]);
                min[i][j]=Math.min(min[i][j-1],nums[j]);
            }
        }
        int[][] dp = new int[n][n];
        for(int len=2;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;
                dp[i][j]=max[i][j]-min[i][j];
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k+1][j]);
                }
            }
        }
        for(int[] arr:dp)
            System.out.println(Arrays.toString(arr));
        return dp[0][n-1];
    }
    @Test
    public void test(){
        int[] nums={10,4,1,4,3,6};
        int n=nums.length;
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for(int i=0;i<n;i++){
            max[i][i]=nums[i];
            min[i][i]=nums[i];
            for(int j=i+1;j<n;j++){
                max[i][j]=Math.max(max[i][j-1],nums[j]);
                min[i][j]=Math.min(min[i][j-1],nums[j]);
            }
        }
        for(int[] arr:max)
            System.out.println(Arrays.toString(arr));
        System.out.println("=========");
        for(int[] arr:min)
            System.out.println(Arrays.toString(arr));
    }
}
