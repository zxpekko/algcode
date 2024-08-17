package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:25 2024/8/13
 */
public class Solution300 {
    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}