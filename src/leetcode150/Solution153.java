package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:52 2024/8/21
 */
public class Solution153 {
    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        System.out.println(solution153.findMin(new int[]{2,3,4,5,1}));
        System.out.println(solution153.findMin1(new int[]{2, 3, 4, 5, 1}));
    }
    public int findMin(int[] nums){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]<nums[right])
                right=mid;
            else
                left=mid+1;
        }
        return nums[left];
    }
    public int findMin1(int[] nums){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<right){
            int mid=(left+right)/2;
            if(nums[mid]<nums[right])
                right=mid;
            else left=mid+1;
        }
        return nums[left];
    }
}
