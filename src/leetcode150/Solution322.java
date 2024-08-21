package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:31 2024/8/13
 */
public class Solution322 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(new int[]{1, 2, 5}, 11));
        Solution322Ⅰ solution322Ⅰ = new Solution322Ⅰ();
        System.out.println(solution322Ⅰ.coinChange(new int[]{1, 2, 5}, 11));
        Solution322Ⅱ solution322Ⅱ = new Solution322Ⅱ();
        System.out.println(solution322Ⅱ.coinChange(new int[]{1, 2, 5}, 11));
    }
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
class Solution322Ⅰ{
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount];
    }
}
class Solution322Ⅱ{
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE)
                    dp[j]=Math.min(dp[j-coins[i]]+1,dp[j]);
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}