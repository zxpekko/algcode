package leetcode150;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:07 2024/7/29
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] ints = solution1.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> record=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(record.containsKey(target-nums[i])){
                int[] result = new int[2];
                result[0]=record.get(target-nums[i]);
                result[1]=i;
                return result;
            }
            else
                record.put(nums[i],i);
        }
        return null;
    }
}
