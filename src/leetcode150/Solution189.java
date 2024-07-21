package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:11 2024/7/18
 */
public class Solution189 {
    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        solution189.rotate(new int[]{-1},2);
    }
    public void rotate(int[] nums, int k){
        int n=nums.length;
        k=k%n;
        if(k==0)
            return;
        int[] temp = new int[k];
        int index=0;
        for(int i=n-k;i<n;i++){
            temp[index++]=nums[i];
        }
        index=n-1;
        for(int i=n-k-1;i>=0;i--){
            nums[index--]=nums[i];
        }
        for(int i=0;i<k;i++)
            nums[i]=temp[i];

    }
}
