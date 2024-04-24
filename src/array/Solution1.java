package array;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:04 2024/4/24
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] ints = solution1.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> record=new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(!record.containsKey(target-nums[i]))
                record.put(nums[i],i);
            else{
                Integer integer = record.get(target - nums[i]);
                result[0]=i;
                result[1]=integer;
            }
        }
        return result;
    }
}
