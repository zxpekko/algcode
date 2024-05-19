package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:09 2024/4/29
 */
public class Solution53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Solution53Ⅰ solution53Ⅰ = new Solution53Ⅰ();
        System.out.println(solution53Ⅰ.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int maxSubArray(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                dp[i]=nums[i];
            else {
                dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            }
        }
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
class Solution53Ⅰ{
    public int maxSubArray(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                dp[i]=nums[i];
            else
                dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
