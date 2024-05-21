package dynamicprogramming;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:08 2024/4/25
 */
public class Solution674 {
    public static void main(String[] args) {
        Solution674 solution674 = new Solution674();
        System.out.println(solution674.findLengthOfLCIS(new int[]{2,2,2,2,2}));
        Solution674Ⅱ solution674Ⅱ = new Solution674Ⅱ();
        System.out.println(solution674Ⅱ.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
    public int findLengthOfLCIS(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){

            if(nums[i]>nums[i-1])
                dp[i]=dp[i-1]+1;
        }
        int max=dp[0];
        for(int i=0;i<n;i++){
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
class Solution674Ⅱ{
    public int findLengthOfLCIS(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1])
                dp[i]=dp[i-1]+1;
        }
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}