package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * @Date:11:50 2023/11/28
 */
public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartitionⅡ(new int[]{1, 5,11,5}));
        CanPartitionⅡ canPartitionⅡ = new CanPartitionⅡ();
        System.out.println(canPartitionⅡ.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartitionⅡ.canPartitionⅡ(new int[]{1, 5, 11, 5}));
    }
    List<Integer> subResult=new ArrayList<>();
    List<List<Integer>> result=new ArrayList<>();
    public boolean canPartition(int[] nums){
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1)
            return false;
        int target=sum/2;
        dfs(target,nums,0,subResult,result);
        System.out.println(result);
        if(result.size()>0)
            return true;
        else
            return false;
    }
    public void dfs(int target,int[] nums,int start,List<Integer> subResult,List<List<Integer>> result){
          if(target==0){
              result.add(new ArrayList<>(subResult));
              return;
          }
          if(start>= nums.length)
              return;
          dfs(target,nums,start+1,subResult,result);
          if(target-nums[start]>=0){
              subResult.add(nums[start]);
              dfs(target-nums[start],nums,start+1,subResult,result);
              subResult.remove(subResult.size()-1);
          }
    }
    public boolean canPartitionⅡ(int[] nums){//考虑背包问题的应用
        //weight和value都是这个nums，最终目标是dp[target]==target，装满大小为target的背包的最大价值，如果能到target，说明正好装满。
        int n= nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        if(sum%2==1)
            return false;
        int[] dp = new int[target+1];
        for(int i=0;i<n;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[target]==target)
            return true;
        return false;
    }
}
class CanPartitionⅡ{
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int volumn=sum/2;
        int[][] dp = new int[n][volumn + 1];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=volumn;j++){
            if(j<nums[0])
                dp[0][j]=0;
            else
                dp[0][j]=nums[0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=volumn;j++){
                if(nums[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n-1][volumn]==volumn;
    }
    public boolean canPartitionⅡ(int[] nums){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        int half=sum/2;
        int[] dp = new int[half + 1];
        for(int i=0;i<n;i++){
            for(int j=half;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[half]==half;
    }
}
