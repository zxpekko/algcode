package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:10 2024/5/15
 */
public class Solution72 {
    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        System.out.println(solution72.minDistance("horse", "ros"));
        Solution72Ⅰ solution72Ⅰ = new Solution72Ⅰ();
        System.out.println(solution72Ⅰ.minDistance("horse", "ros"));
    }
    public int minDistance(String word1, String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
            }
        }
        return dp[m][n];
    }
}
class Solution72Ⅰ{
    public int minDistance(String word1, String word2){
        int m=word1.length(),n=word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<=m;i++)
            dp[i][0]=i;
        for(int j=0;j<=n;j++)
            dp[0][j]=j;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[m][n];
    }
}