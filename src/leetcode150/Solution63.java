package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:43 2024/8/15
 */
public class Solution63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                dp[i][0]=1;
            }
            else {
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]!=1){
                dp[0][j]=1;
            }
            else break;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
