package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:12 2024/7/18
 */
public class Solution27 {
    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
    public int removeElement(int[] nums, int val){
        int p=0,q=0;
        while (q<nums.length){
            if(nums[q]==val){
                q++;
            }
            else{
                nums[p]=nums[q];
                p++;
                q++;
            }
        }
        return p;
    }
}
