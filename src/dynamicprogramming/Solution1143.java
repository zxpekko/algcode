package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:55 2024/4/28
 */
public class Solution1143 {
    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence("abcde", "ace"));
        Solution1143Ⅰ solution1143Ⅰ = new Solution1143Ⅰ();
        System.out.println(solution1143Ⅰ.longestCommonSubsequence("abcde", "ace"));
        Solution1143Ⅱ solution1143Ⅱ = new Solution1143Ⅱ();
        System.out.println(solution1143Ⅱ.longestCommonSubsequence("abcde", "ace"));
    }
    public int longestCommonSubsequence(String text1, String text2){
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
               if(text1.charAt(i-1)==text2.charAt(j-1)){
                   dp[i][j]=dp[i-1][j-1]+1;
               }
               else
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
class Solution1143Ⅰ{
    public int longestCommonSubsequence(String text1, String text2){
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
//        int max=dp[1][1];
//        for(int i=1;i<=m;i++){
//            for(int j=1;j<=n;j++){
//                max=Math.max(max,dp[i][j]);
//            }
//        }
//        return max;
        return dp[m][n];
    }
}
class Solution1143Ⅱ{
    public int longestCommonSubsequence(String text1, String text2){
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int max=dp[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}