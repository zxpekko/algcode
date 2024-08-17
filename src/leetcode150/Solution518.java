package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:55 2024/8/13
 */
public class Solution518 {
    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        System.out.println(solution518.change(5, new int[]{1, 2, 5}));
        Solution518Ⅰ solution518Ⅰ = new Solution518Ⅰ();
        System.out.println(solution518Ⅰ.change(5, new int[]{1, 2, 5}));
        Solution518Ⅱ solution518Ⅱ = new Solution518Ⅱ();
        System.out.println(solution518Ⅱ.change(5, new int[]{1, 2, 5}));
    }
    public int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
class Solution518Ⅰ{
    public int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
class Solution518Ⅱ{
    public int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}