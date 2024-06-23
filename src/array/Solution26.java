package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:25 2024/6/19
 */
public class Solution26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.removeDuplicates(new int[]{0, 0, 1, 1, 2}));
        Solution26Ⅰ solution26Ⅰ = new Solution26Ⅰ();

    }
    public int removeDuplicates(int[] nums){
        int n=nums.length;
        int p=0,q=1;
        while (q<n){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
                q++;
            }
            else
                q++;
        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
}
class Solution26Ⅰ{
    public int removeDuplicates(int[] nums){
        int n=nums.length;
        int p=0,q=1;
        while (q<n){
            if(nums[p]==nums[q]){
                q++;
            }
            else {
                nums[p+1]=nums[q];
                p++;
                q++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
}