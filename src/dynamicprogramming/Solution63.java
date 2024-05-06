package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:42 2024/5/3
 */
public class Solution63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1)
                break;
            else
                dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1)
                break;
            else
                dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
