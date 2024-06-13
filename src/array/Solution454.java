package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:49 2024/4/27
 */
public class Solution454 {
    public static void main(String[] args) {
        Solution454 solution454 = new Solution454();
        System.out.println(solution454.fourSumCount(new int[]{0,1,-1}, new int[]{-1,1,0}, new int[]{0,0,1}, new int[]{-1,1,1}));
        Solution454Ⅰ solution454Ⅰ = new Solution454Ⅰ();
        System.out.println(solution454Ⅰ.fourSumCount(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1}));
        System.out.println(solution454Ⅰ.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer,Integer> record=new HashMap<>();
        int n=nums1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int subSum=nums1[i]+nums2[j];
                if(!record.containsKey(subSum)){
                    record.put(subSum,1);
                }
                else {
                    Integer integer = record.get(subSum);
                    record.put(subSum,integer+1);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int lastSum=nums3[i]+nums4[j];
                if(record.containsKey(-lastSum))
                    count+=record.get(-lastSum);
            }
        }
        return count;
    }
}
class Solution454Ⅰ{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum=nums1[i]+nums2[j];
                record.put(sum,record.getOrDefault(sum,0)+1);
            }
        }
        int result=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int sum=nums3[i]+nums4[j];
                result+=record.getOrDefault(-sum,0);
            }
        }
        return result;
    }
}
