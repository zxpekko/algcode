package array;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:05 2024/5/26
 */
public class Solution560 {
    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(solution560.subarraySumⅠ(new int[]{1, 2, 3}, 3));
        Solution560Ⅰ solution560Ⅰ = new Solution560Ⅰ();
        System.out.println(solution560Ⅰ.subarraySum(new int[]{1, 2, 3}, 3));
    }
//    public int subarraySum(int[] nums, int k){
//        int left=0,right=0;
//        int sum=nums[left];
//        int result=0;
//        while (right<nums.length){
//            if(sum>k&&right-left+1==1)
//                return result;
//            else if(sum==k){
//                result++;
//                sum-=(nums[left]);
//                left++;
//            }
//            else if(sum<k){
//                right++;
//                if(right<nums.length)
//                    sum+=nums[right];
//            }
//            else if(sum>k){
//                sum-=(nums[left]);
//                left++;
//            }
//        }
//        return result;
//    }
    public int subarraySum(int[] nums, int k){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j>=0;j--){
                sum+=nums[j];
                if(sum==k)
                    count++;
            }
        }
        return count;
    }
    public int subarraySumⅠ(int[] nums, int k){//前缀和，时间空间复杂度为O(n).思路：前缀和与哈希表优化。
        int n=nums.length;
        HashMap<Integer, Integer> record=new HashMap<>();
        record.put(0,1);
        int count=0;
        int pre =0;
        for(int i=0;i<n;i++){
            pre+=nums[i];
            if(record.containsKey(pre-k))
                count+=record.get(pre-k);
            record.put(pre,record.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
class Solution560Ⅰ{
    public int subarraySum(int[] nums, int k){
        int n=nums.length;
        HashMap<Integer,Integer> record=new HashMap<>();
        record.put(0,1);
        int pre=0,count=0;
        for(int i=0;i<n;i++){
            pre+=nums[i];
            if(record.containsKey(pre-k))
                count+=(record.get(pre-k));
            record.put(pre,record.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
