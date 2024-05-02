package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:45 2024/5/1
 */
public class Solution343 {
    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();
        System.out.println(solution343.integerBreak(10));
    }
    public int integerBreak(int n){
        int[] dp = new int[n + 1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}
