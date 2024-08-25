package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:04 2024/8/24
 */
public class Solution3040 {
    public static void main(String[] args) {
        Solution3040 solution3040 = new Solution3040();
        System.out.println(solution3040.maxOperations(new int[]{3,2,6,1,4}));
        Solution3040Ⅰ solution3040Ⅰ = new Solution3040Ⅰ();
        System.out.println(solution3040Ⅰ.maxOperations(new int[]{3, 2, 6, 1, 4}));
    }
    int[][] dp;
    public int maxOperations(int[] nums){
        int n=nums.length;
        dp=new int[n][n];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        int target1=nums[0]+nums[1];
        int target2=nums[0]+nums[nums.length-1];
        int target3=nums[nums.length-1]+nums[nums.length-2];
        int res1=dfs(2,nums.length-1,target1,nums);
        int res2=dfs(1,nums.length-2,target2,nums);
        int res3=dfs(0,nums.length-3,target3,nums);
        return Math.max(Math.max(res1,res2),res3)+1;
    }
    public int dfs(int i,int j,int target,int[] nums){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int res=0;
        if(nums[i]+nums[i+1]==target)
            res=Math.max(res,dfs(i+2,j,target,nums)+1);
        if(nums[i]+nums[j]==target)
            res=Math.max(res,dfs(i+1,j-1,target,nums)+1);
        if(nums[j]+nums[j-1]==target)
            res=Math.max(res,dfs(i,j-2,target,nums)+1);
        dp[i][j]=res;
        return res;
    }
}
class Solution3040Ⅰ{
    int[][] dp;
    public int maxOperations(int[] nums){
        int n=nums.length;
        dp=new int[n][n];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        int target1=nums[0]+nums[1];
        int target2=nums[0]+nums[nums.length-1];
        int target3=nums[nums.length-1]+nums[nums.length-2];
        int max1=dfs(2,nums.length-1,nums,target1);
        int max2=dfs(1,nums.length-2,nums,target2);
        int max3=dfs(0,nums.length-3,nums,target3);
        return Math.max(Math.max(max1,max2),max3)+1;
    }
    public int dfs(int i,int j,int[] nums,int target){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int res=0;
        if(nums[i]+nums[i+1]==target)
            res=Math.max(res,dfs(i+2,j,nums,target)+1);
        if(nums[i]+nums[j]==target)
            res=Math.max(res,dfs(i+1,j-1,nums,target)+1);
        if(nums[j]+nums[j-1]==target)
            res=Math.max(res,dfs(i,j-2,nums,target)+1);
        dp[i][j]=res;
        return res;
    }
}