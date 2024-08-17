package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:19 2024/8/16
 */
public class Solution221 {
    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        System.out.println(solution221.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
    public int maximalSquare(char[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int[m][n];//dp[i][j]表示以i，j为右下角的最大正方形的长度
        for(int i=0;i<m;i++){
            if(matrix[i][0]=='1')
                dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]=='1')
                dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1')
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
            }
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}