package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:06 2024/8/16
 */
public class Solution97 {
    public static void main(String[] args) {
        Solution97 solution97 = new Solution97();
        System.out.println(solution97.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
    public boolean isInterleave(String s1, String s2, String s3){
        int n=s1.length();
        int m=s2.length();
        if(n+m!=s3.length())
            return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0]=true;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i>0){
                    dp[i][j]=dp[i][j]||(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
                }
                if(j>0){
                    dp[i][j]=dp[i][j]||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[n][m];
    }
}