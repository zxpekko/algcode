package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:27 2024/7/19
 */
public class Solution238 {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        int[] ints = solution238.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=nums[0];
        right[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            left[i]=nums[i]*left[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i]=nums[i]*right[i+1];
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                result[i]=right[i+1];
            }
            else if(i==n-1){
                result[i]=left[i-1];
            }
            else {
                result[i]=left[i-1]*right[i+1];
            }
        }
        return result;
    }
}