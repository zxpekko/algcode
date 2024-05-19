package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:26 2024/5/19
 */
public class Solution188 {
    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        System.out.println(solution188.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
    public int maxProfit(int k, int[] prices){
        int n=prices.length;
        int[][] dp = new int[n][2 * k + 1];
        for(int i=0;i<2*k+1;i++){
            if(i%2==0)
                dp[0][i]=0;
            else
                dp[0][i]=-prices[0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<2*k+1;j++){
                if(j%2==0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]);
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
            }
        }
        return dp[n-1][2*k];
    }
}
