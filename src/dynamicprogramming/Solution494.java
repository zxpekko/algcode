package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:24 2024/5/31
 */
public class Solution494 {
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        System.out.println(solution494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public int findTargetSumWays(int[] nums, int target){
        int sum=0;
        for(int num:nums)
            sum+=num;
        if((sum+target)%2!=0)
            return 0;
        int x=(sum+target)/2;
        if(x<0)
            return 0;
        int[] dp = new int[x + 1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=x;j>=nums[i];j--){
                dp[j]+=(dp[j-nums[i]]);
            }
        }
        return dp[x];
    }
}
