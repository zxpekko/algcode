package leetcode150;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:00 2024/8/19
 */
public class Solution918 {
    public static void main(String[] args) {
        Solution918 solution918 = new Solution918();
        System.out.println(solution918.maxSubarraySumCircular(new int[]{-3,-2,-3}));
        System.out.println(solution918.maxSubarraySumCircular1(new int[]{-2}));
        System.out.println(solution918.maxSubarraySumCircular2(new int[]{-3, -2, -3}));
        Solution918Ⅰ solution918Ⅰ = new Solution918Ⅰ();
        System.out.println(solution918Ⅰ.maxSubarraySumCircular(new int[]{-3, -2, -3}));

    }
    public int maxSubarraySumCircular(int[] nums){//超时
        int n=nums.length;
        int[] arr = new int[2 * n];
        int max=Integer.MIN_VALUE;
        int[] dp = new int[2*n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            arr[i+n]=nums[i];
        }
        for(int i=0;i<n;i++){
            Arrays.fill(dp,0);
            dp[i]=nums[i];
            for(int j=i+1;j<i+n;j++){
                dp[j]=Math.max(dp[j-1]+arr[j],arr[j]);
            }
            int curMax=Integer.MIN_VALUE;
            for(int k=i;k<i+n;k++)
                curMax=Math.max(curMax,dp[k]);
            max=Math.max(max,curMax);
        }
        return max;
    }
    public int maxSubarraySumCircular1(int[] nums){//超时
        int n=nums.length;
        int[] arr = new int[2 * n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            arr[i+n]=nums[i];
        }
        for(int i=0;i<n;i++){
            int dpMax=nums[i];
            int curMax=nums[i];
            for(int j=i+1;j<i+n;j++){
                dpMax=Math.max(dpMax+arr[j],arr[j]);
                curMax=Math.max(curMax,dpMax);
            }
            max=Math.max(max,curMax);
        }
        return max;
    }
    public int maxSubarraySumCircular2(int[] nums){
        int n=nums.length;
        int pre=nums[0],res=nums[0];
        int[] leftMax=new int[n];
        leftMax[0]=nums[0];
        int leftSum=nums[0];
        for(int i=1;i<n;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            res=Math.max(res,pre);
            leftSum+=nums[i];
            leftMax[i]=Math.max(leftMax[i-1],leftSum);
        }
        int rightSum=0;
        for(int i=n-1;i>0;i--){
            rightSum+=nums[i];
            res=Math.max(res,rightSum+leftMax[i-1]);
        }
        return res;
    }
}
class Solution918Ⅰ{
    public int maxSubarraySumCircular(int[] nums){
        int res=nums[0],curMax=nums[0];
        int leftSum=nums[0];
        int[] leftMax=new int[nums.length];
        leftMax[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            curMax=Math.max(curMax+nums[i],nums[i]);
            res=Math.max(res,curMax);
            leftSum+=nums[i];
            leftMax[i]=Math.max(leftSum,leftMax[i-1]);
        }
        int rightSum=0;
        for(int i=nums.length-1;i>0;i--){
            rightSum+=nums[i];
            res=Math.max(res,rightSum+leftMax[i-1]);
        }
        return res;
    }
}
class Solution918Ⅱ{
    public int maxSubarraySumCircular(int[] nums){
        int n=nums.length;
        int[] leftMax=new int[n];
        int leftSum=nums[0];
        leftMax[0]=nums[0];
        int curMax=nums[0],res=nums[0];
        for(int i=1;i<n;i++){
            curMax=Math.max(nums[i],nums[i]+curMax);
            res=Math.max(res,curMax);
            leftSum+=nums[i];
            leftMax[i]=Math.max(leftMax[i-1],leftSum);
        }
        int rightSum=0;
        for(int j=n-1;j>0;j--){
            rightSum+=nums[j];
            res=Math.max(res,rightSum+leftMax[j-1]);
        }
        return res;
    }
}