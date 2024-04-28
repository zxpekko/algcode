package dynamicprogramming;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:51 2024/4/19
 */
public class Solution516 {
    public static void main(String[] args) {
        Solution516 solution516 = new Solution516();
        System.out.println(solution516.longestPalindromeSubseq("cbbd"));
        Solution516Ⅱ solution516Ⅱ = new Solution516Ⅱ();
        System.out.println(solution516Ⅱ.longestPalindromeSubseq("cbbd"));
    }
    public int longestPalindromeSubseq(String s){
        int n=s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=Math.max(dp[i+1][j-1]+2,dp[i][j]);
                else {
                    dp[i][j]= Math.max(dp[i+1][j],Math.max(dp[i][j],dp[i][j-1]));
                }
            }
        }
        return dp[0][n-1];
    }
}
class Solution516Ⅱ{
    public int longestPalindromeSubseq(String s){
        int n=s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}