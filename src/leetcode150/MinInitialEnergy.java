package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:22 2024/8/15
 */
public class MinInitialEnergy {
    public static void main(String[] args) {
        MinInitialEnergy minInitialEnergy = new MinInitialEnergy();
        System.out.println(minInitialEnergy.minInitialEnegy(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }
    public int minInitialEnegy(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];//dp[i][j]表示从i,j位置到达右下角当前应该多少最低初始电量
        dp[m-1][n-1]=Math.max(1,1-grid[m-1][n-1]);
        //最后一列。
        for(int i=m-2;i>=0;i--){
            dp[i][n-1]=Math.max(1,dp[i+1][n-1]-grid[i][n-1]);
        }
        //最后一行
        for(int j=n-2;j>=0;j--){
            dp[m-1][j]=Math.max(1,dp[m-1][j+1]-grid[m-1][j]);
        }
        //其余
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int minEn=Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(1,minEn-grid[i][j]);
            }
        }
        return dp[0][0];
    }
}