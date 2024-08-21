package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:55 2024/8/17
 */
public class Solution53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        int[] max = solution53.getMax(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(Arrays.toString(max));
        int[] maxIndex = solution53.getMaxIndex(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(Arrays.toString(maxIndex));
        int[] maxIndex1 = solution53.getMaxIndex1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(Arrays.toString(maxIndex1));
    }
    public int maxSubArray(int[] nums){
        int curMax=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            curMax=Math.max(nums[i],nums[i]+curMax);
            max=Math.max(max,curMax);
        }
        return max;
    }
    public int[] getMax(int[] nums){
        int n=nums.length;
        int start=0,s=0;
        int end=0;
        int max=nums[0];
        int curMax=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i]+curMax){
                curMax=nums[i];
                s=i;
            }
            else {
                curMax+=nums[i];
            }
            if(curMax>max){
                max=curMax;
                start=s;
                end=i;
            }
        }
        return new int[]{start,end};
    }
    public int[] getMaxIndex(int[] nums){
        int start=0,end=0;
        int maxEnding=nums[0],max=nums[0];
        int s=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>maxEnding+nums[i]){
                maxEnding=nums[i];
                s=i;
            }
            else {
                maxEnding+=nums[i];
            }
            if(maxEnding>max){
                max=maxEnding;
                start=s;
                end=i;
            }
        }
        return new int[]{start,end};
    }
    public int[] getMaxIndex1(int[] nums){
        int maxEnding=nums[0],totalEnding=nums[0];
        int start=0,end=0,s=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>maxEnding+nums[i]){
                maxEnding=nums[i];
                s=i;
            }
            else
                maxEnding+=nums[i];
            if(maxEnding>totalEnding){
                totalEnding=maxEnding;
                start=s;
                end=i;
            }
        }
        return new int[]{start,end};
    }
}