package array;

import javax.xml.bind.annotation.XmlMimeType;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:01 2024/5/18
 */
public class Solution33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        Solution33Ⅰ solution33Ⅰ = new Solution33Ⅰ();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution33Ⅰ.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        Solution33Ⅱ solution33Ⅱ = new Solution33Ⅱ();
        System.out.println(solution33Ⅱ.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
    public int search(int[] nums, int target){
        int n=nums.length;
        if(n==0)
            return -1;
        if(n==1)
            return target==nums[0]?0:-1;
        int l=0,r=n-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<nums[mid]){
                    r=mid-1;
                }
                else l=mid+1;
            }
            else {
                if(nums[mid]<target&&target<=nums[r])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return -1;
    }
}
class Solution33Ⅰ{
    public int search(int[] nums, int target){
        int n=nums.length;
        if(n==0)
            return -1;
        if(n==1)
            return target==nums[0]?0:-1;
        int left=0,right=n-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid])
                return mid;
            if(nums[mid]>=nums[0]){
                if(target>=nums[0]&&target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else {
                if(target>nums[mid]&&target<=nums[n-1])
                    left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}
class Solution33Ⅱ{
    public int search(int[] nums, int target){
        int n=nums.length;
        int left=0,right=n-1;
        if(n==1)
            return target==nums[0]?0:-1;
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
                if(target>nums[mid]&&target<=nums[n-1])
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}