package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:20 2024/7/18
 */
public class Solution26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    public int removeDuplicates(int[] nums){
        int n= nums.length;
        int p=0,q=1;
        while (q<n){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
                q++;
            }
            else {
                q++;
            }
        }
        return p+1;
    }
}
