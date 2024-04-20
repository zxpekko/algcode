package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * @Date:11:23 2024/2/26
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(!hashMap.containsKey(target-nums[i])){
                hashMap.put(nums[i],i );
            }
            else{
                result[0]=hashMap.get(target-nums[i]);
                result[1]=i;
                break;
            }
        }
        return result;
    }
}
