package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:11 2024/6/5
 */
public class Solution918 {
    public static void main(String[] args) {
        Solution918 solution918 = new Solution918();
        System.out.println(solution918.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }
//    public int maxSubarraySumCircular(int[] nums){
//        int n=nums.length;
//        int[] newNums = new int[2 * n];
//        for(int i=0;i<n;i++){
//            newNums[i]=nums[i];
//            newNums[i+n]=nums[i];
//        }
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            int curMax=0;
//            for(int j=i;j<i+n;j++){
//                curMax+=newNums[j];
//                max=Math.max(max,curMax);
//            }
//        }
//        return max;
//    }
    public int maxSubarraySumCircular(int[] nums){
        int result=nums[0];
        int pre=nums[0];
        int n=nums.length;
        int[] leftMax = new int[n];
        leftMax[0]=nums[0];
        int leftSum=nums[0];
        for(int i=1;i<n;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            result=Math.max(result,pre);
            leftSum+=nums[i];
            leftMax[i]=Math.max(leftMax[i-1],leftSum);
        }
        int rightSum=0;
        for(int i=n-1;i>0;i--){
            rightSum+=nums[i];
            result=Math.max(result,rightSum+leftMax[i-1]);
        }
        return result;
    }
}