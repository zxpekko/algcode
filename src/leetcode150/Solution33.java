package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:24 2024/8/21
 */
public class Solution33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Solution33Ⅰ solution33Ⅰ = new Solution33Ⅰ();
        System.out.println(solution33Ⅰ.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Solution33Ⅱ solution33Ⅱ = new Solution33Ⅱ();
        System.out.println(solution33Ⅱ.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
    public int search(int[] nums, int target){
        int n=nums.length;
        int left=0,right=n-1;
        if(nums.length==1)
            return nums[0]==target?0:-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid])
                return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<nums[mid])
                    right=mid-1;
                else left=mid+1;
            }
            else {
                if(nums[mid]<target&&target<=nums[n-1])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}
class Solution33Ⅰ{
    public int search(int[] nums, int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else {
                if(nums[mid]<target&&target<=nums[n-1])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}
class Solution33Ⅱ{
    public int search(int[] nums, int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<nums[mid])
                    right=mid-1;
                else left=mid+1;
            }
            else {
                if(nums[mid]<target&&target<=nums[n-1])
                    left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}