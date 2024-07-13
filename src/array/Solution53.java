package array;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:41 2024/7/12
 */
public class Solution53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int maxSubArray(int[] nums){
        int n=nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
