package interview;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:30 2024/8/25
 */
public class Solution560 {
    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(new int[]{1, 2, 3}, 3));
    }
    public int subarraySum(int[] nums, int k){
        int n=nums.length;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        int pre=0;
        int count=0;
        for(int i=0;i<n;i++){
            pre+=nums[i];
            if(hashMap.containsKey(pre-k))
                count+=hashMap.get(pre-k);
            hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
