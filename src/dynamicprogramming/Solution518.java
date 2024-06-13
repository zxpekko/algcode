package dynamicprogramming;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:19 2024/6/1
 */
public class Solution518 {
    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        System.out.println(solution518.change(5, new int[]{1, 2, 5}));
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
