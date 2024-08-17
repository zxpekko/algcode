package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:36 2024/8/15
 */
public class Solution516 {
    public static void main(String[] args) {
        Solution516 solution516 = new Solution516();
        System.out.println(solution516.longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s){
        int n=s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dp[i][j]);

            }
        }
        return max;
    }
}
