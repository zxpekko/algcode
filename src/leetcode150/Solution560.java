package leetcode150;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:40 2024/7/28
 */
public class Solution560 {
    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(new int[]{1, 2, 3}, 3));
    }
    public int subarraySum(int[] nums, int k){
        int n=nums.length;
        HashMap<Integer, Integer> record = new HashMap<>();
        record.put(0,1);
        int pre=0,count=0;
        for(int i=0;i<n;i++){
            pre+=nums[i];
            if(record.containsKey(pre-k)){
                Integer value = record.get(pre - k);
                count+=value;
            }
            record.put(pre,record.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
