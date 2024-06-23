package dynamicprogramming;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:48 2024/4/20
 */
public class Solution300 {
    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        Solution300Ⅰ solution300Ⅰ = new Solution300Ⅰ();
        System.out.println(solution300Ⅰ.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        Solution300Ⅱ solution300Ⅱ = new Solution300Ⅱ();
        System.out.println(solution300Ⅱ.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        Solution300Ⅲ solution300Ⅲ = new Solution300Ⅲ();
        int i = solution300Ⅲ.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        System.out.println(i);
    }
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];//dp[i]代表以下标为i的元素结尾的最长递增子序列。
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int max=dp[0];
        System.out.println(Arrays.toString(dp));
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
class Solution300Ⅰ{
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
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
class Solution300Ⅱ{
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
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
class Solution300Ⅲ{
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
