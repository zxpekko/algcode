package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 * @Date:10:02 2023/12/4
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(new int[]{1, 2, 3}, 4));
        CombinationSum4Ⅱ combinationSum4Ⅱ = new CombinationSum4Ⅱ();
        System.out.println(combinationSum4Ⅱ.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    public int combinationSum4(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j< nums.length;j++){
                if(nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
class CombinationSum4Ⅱ{
    public int combinationSum4(int[] nums, int target){
        int n=nums.length;
        int[] dp = new int[target + 1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<n;j++){
                if(nums[j]<=i)
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
