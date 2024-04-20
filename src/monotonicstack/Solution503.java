package monotonicstack;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:59 2024/4/12
 */
public class Solution503 {
    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] ints = solution503.nextGreaterElements(new int[]{1,2,3,4,3});
        System.out.println(Arrays.toString(ints));
    }
    public int[] nextGreaterElements(int[] nums){
        int n=nums.length;
        int[] nums2 = new int[2 * n];
        int[] result2 = new int[2 * n];
        int[] result = new int[n];
        Arrays.fill(result2,-1);
        for(int i=0;i<n;i++){
            nums2[i]=nums[i];
        }
        for(int i=0,j=n;i<n;i++,j++){
            nums2[j]=nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<2*n;i++){
            while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                Integer pop = stack.pop();
                result2[pop]=nums2[i];
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            result[i]=result2[i];
        }
        return result;
    }
}
