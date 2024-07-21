package leetcode150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:31 2024/7/18
 */
public class Solution169 {
    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        System.out.println(solution169.majorityElement(new int[]{3,3}));

    }
    public int majorityElement(int[] nums){
        int n=nums.length;
        int up=n/2;
        Arrays.sort(nums);
        if(nums.length==1)
            return nums[0];
        int curCount=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]==nums[i]){
                curCount++;
                if(curCount>up){
                    return nums[i];
                }
            }
            else {
                curCount=1;
            }
        }
        return 0;
    }
    public int majorityElement1(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
//            Integer count = hashMap.get(nums[i]);
//            if(count>nums.length/2)
//                return nums[i];
        }
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(entry.getValue()>nums.length/2)
                return entry.getKey();
        }
        return 0;
    }
}
