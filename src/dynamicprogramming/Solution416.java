package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:33 2024/5/30
 */
public class Solution416 {
    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        System.out.println(solution416.canPartition(new int[]{1, 2,3,5}));
    }
    public boolean canPartition(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        int[] dp = new int[sum + 1];
        for(int i=0;i<nums.length;i++){
            for(int j=dp.length-1;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum]==sum;
    }
}
