package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:47 2024/5/19
 */
public class Solution309 {
    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        System.out.println(solution309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
    public int maxProfit(int[] prices){
        int n=prices.length;
        int[][] dp = new int[n][4];//0代表持有股票，1代表不持有股票，2代表卖出股票动作当天，3代表冷冻期
        dp[0][0]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(Math.max(dp[i-1][0],dp[i-1][1]-prices[i]),dp[i-1][3]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][3]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }
        return Math.max(Math.max(dp[n-1][0],dp[n-1][1]),Math.max(dp[n-1][2],dp[n-1][3]));
    }
}
