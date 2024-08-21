package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:00 2024/8/18
 */
public class Solution188 {
    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        System.out.println(solution188.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
    public int maxProfit(int k, int[] prices){
        int[][] dp = new int[prices.length][2 * k + 1];
        for(int i=1;i<2*k+1;i+=2){
            dp[0][i]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                dp[i][2*j-1]=Math.max(dp[i-1][2*j-1],dp[i-1][2*j-2]-prices[i]);
                dp[i][2*j]=Math.max(dp[i-1][2*j],dp[i-1][2*j-1]+prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }
}