package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:40 2024/7/22
 */
public class Solution392 {
    public static void main(String[] args) {
        Solution392 solution392 = new Solution392();
        System.out.println(solution392.isSubsequence("aa", "a"));
    }
    public boolean isSubsequence(String s, String t){
        int m=s.length(),n=t.length();
        if(n==0&&m!=0)
            return false;
        if(m>n)
            return false;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n]==m?true:false;
    }
}