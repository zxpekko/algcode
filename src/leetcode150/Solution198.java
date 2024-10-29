package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:29 2024/8/13
 */
public class Solution198 {
    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(new int[]{2,7,9,3,1}));
        Solution198Ⅰ solution198Ⅰ = new Solution198Ⅰ();
        System.out.println(solution198Ⅰ.rob(new int[]{2, 7, 9, 3, 1}));
    }
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1)
            return nums[0];
        else if(n==2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}
class Solution198Ⅰ{
    public int rob(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i==1)
                dp[i]=Math.max(nums[i-1],nums[i]);
            else
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}