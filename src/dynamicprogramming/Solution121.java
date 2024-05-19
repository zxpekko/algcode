package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:11 2024/5/19
 */
public class Solution121 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] prices){
        int n=prices.length;
        int[][] dp = new int[n][2];//dp[i][0]表示第i天持有股票所得的最大现金，dp[i][1]表示第i天不持有股票所得的最大现金
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[n-1][1];
    }
}