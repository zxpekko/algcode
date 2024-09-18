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
        SolutionAverage solutionAverage = new SolutionAverage();
        System.out.println(solutionAverage.averageSubarray(new int[]{1, 2, 3}, 2));
        System.out.println(solution560.subarraySumⅠ(new int[]{1, 2, 3}, 3));
        System.out.println(solution560.subarraySumⅡ(new int[]{1, 2, 3}, 3));
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
    public int subarraySumⅠ(int[] nums,int k){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int pre=0,count=0;
        hashMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(hashMap.containsKey(pre-k))
                count+=hashMap.get(pre-k);
            hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);
        }
        return count;
    }
    public int subarraySumⅡ(int[] nums,int k){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int pre=0,count=0;
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(hashMap.containsKey(pre-k))
                count+=hashMap.get(pre-k);
            hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
class SolutionAverage{
    public int averageSubarray(int[] arr,int k){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,0);
        int pre=0,cur=0;
        int length=0;
        for(int i=1;i<=arr.length;i++){
            cur=pre+arr[i-1]-k;
            if(hashMap.containsKey(cur))
                length=Math.max(length,i-hashMap.get(cur));
            hashMap.put(cur,i);
        }
        return length;
    }
}