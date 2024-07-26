package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:22 2024/7/24
 */
public class Solution209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        System.out.println(solution209.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
    public int minSubArrayLen(int target, int[] nums){
        int n=nums.length;
        int left=0,right=0;
        int sum=nums[left];
        int length=Integer.MAX_VALUE;
        while (right<n){
            if(sum<target){
                right++;
                if(right<n)
                    sum+=nums[right];
            }
            else {
                length=Math.min(length,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return length==Integer.MAX_VALUE?0:length;
    }
}
