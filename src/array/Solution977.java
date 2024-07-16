package array;

import leetcode.binarysearch.FindNthDigit;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:53 2024/7/15
 */
public class Solution977 {
    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        int[] ints = solution977.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }
    public int[] sortedSquares(int[] nums){
        int n=nums.length;
        int[] result = new int[n];
        int i=0,j=n-1;
        int startIndex=n-1;
        while (i<=j){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                result[startIndex--]=nums[i]*nums[i];
                i++;
            }
            else {
                result[startIndex--]=nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }
}
