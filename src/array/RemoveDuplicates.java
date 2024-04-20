package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:11 2024/3/31
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates.removeDuplicates(nums));
        RemoveDuplicatesⅡ removeDuplicatesⅡ = new RemoveDuplicatesⅡ();
        System.out.println(removeDuplicatesⅡ.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums){
        int left=0,right=1;
        int count=0;
        int n=nums.length;
        while (left<n-count&&right<n-count){
            if(nums[left]!=nums[right]){
                left++;
                right++;
            }
            else {
                for(int i=right+1;i<n-count;i++)
                    nums[i-1]=nums[i];
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return n-count;
    }
}
class RemoveDuplicatesⅡ{
    public int removeDuplicates(int[] nums){
        int p=0,q=1;
        while (q< nums.length){
            if(nums[p]==nums[q]){
                q++;
            }
            else {
                nums[p+1]=nums[q];
                q++;
                p++;
            }

        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
}
