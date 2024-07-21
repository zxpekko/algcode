package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:32 2024/7/19
 */
public class Solution122 {
    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        System.out.println(solution122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] prices){
        int n=prices.length;
        int[][] dp = new int[n][2];//多笔交易要注意。dp[i][0]代表第i天持有，dp[i][1]代表第i天不持有。
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[n-1][1];
    }
}