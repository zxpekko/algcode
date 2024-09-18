package interview;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:35 2024/8/26
 */
public class Solution3264 {
    public static void main(String[] args) {
        Solution3264 solution3264 = new Solution3264();
        int[] finalState = solution3264.getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2);
        System.out.println(Arrays.toString(finalState));
    }
    public int[] getFinalState(int[] nums, int k, int multiplier){
        for(int i=0;i<k;i++){
            int min = getMin(nums);
            nums[min]=nums[min]*multiplier;
        }
        return nums;
    }
    public int getMin(int[] nums){
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[index])
                index=i;
        }
        return index;
    }
}
