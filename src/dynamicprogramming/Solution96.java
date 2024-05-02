package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:59 2024/5/1
 */
public class Solution96 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(1));
    }
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[0]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
