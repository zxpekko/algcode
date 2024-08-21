package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:25 2024/8/20
 */
public class Solution35 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
    public int searchInsert(int[] nums, int target){
        int n=nums.length;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
}
