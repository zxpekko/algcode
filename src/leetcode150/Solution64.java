package leetcode150;

import java.util.Enumeration;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:13 2024/8/14
 */
public class Solution64 {
    public static void main(String[] args) {
        Solution64 solution64 = new Solution64();

        System.out.println(solution64.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
    public int minPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            if(i==0)
                dp[i][0]= grid[i][0];
            else
                dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int j=0;j<n;j++){
            if(j==0)
                dp[0][j]=grid[0][j];
            else
                dp[0][j]=grid[0][j]+dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}