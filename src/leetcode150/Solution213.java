package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:17 2024/9/20
 */
public class Solution213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        System.out.println(solution213.rob(new int[]{0}));
    }
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1)
            return nums[0];
        int[] nums2 = new int[2 * n];
        for(int i=0;i<n;i++){
            nums2[i]=nums[i];
            nums2[i+n]=nums[i];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int max1 = getMax(nums2, i, i + n - 2);
            max=Math.max(max,max1);
        }
        return max;
    }
    public int getMax(int[] nums,int start,int end){
        int[] dp = new int[nums.length];
        dp[start]=nums[start];
        for(int i=start+1;i<=end;i++){
            if(i==start+1){
                dp[i]=Math.max(nums[i-1],nums[i]);
            }
            else
                dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[end];
    }
}