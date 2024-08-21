package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:47 2024/8/20
 */
public class Solution162 {
    public static void main(String[] args) {
        Solution162 solution162 = new Solution162();
        System.out.println(solution162.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(solution162.findPeakElement1(new int[]{1, 2, 3, 1}));
    }
    public int findPeakElement(int[] nums){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1])
                right=mid;
            else left=mid+1;
        }
        return left;
    }
    public int findPeakElement1(int[] nums){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1])
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}
