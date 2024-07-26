package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:28 2024/7/22
 */
public class Solution167 {
    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        int[] ints = solution167.twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(Arrays.toString(ints));
    }
    public int[] twoSum(int[] numbers, int target){
        int n=numbers.length;
        int left=0,right=n-1;
        while (left<right){
            int sum=numbers[left]+numbers[right];
            if (sum>target)
                right--;
            else if(sum<target)
                left++;
            else{
                int[] res = new int[2];
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }
        }
        return null;
    }
}
