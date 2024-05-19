package dynamicprogramming;

import javax.xml.bind.annotation.XmlAnyAttribute;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:16 2024/5/19
 */
public class Solution123 {
    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        System.out.println(solution123.maxProfit(new int[]{1,2,3,4,5}));
    }
    public int maxProfit(int[] prices){
        int n=prices.length;
        int[][] dp = new int[n][5];//dp[i][0]代表第i天没有操作，1代表第一次持有股票，2代表第一次不持有股票，3代表第二次持有股票，4代表第二次不持有股票
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=0;
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[n-1][4];
    }
}
