package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:02 2024/8/13
 */
public class Solution377 {
    public static void main(String[] args) {
        Solution377 solution377 = new Solution377();
        System.out.println(solution377.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    public int combinationSum4(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j])
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}