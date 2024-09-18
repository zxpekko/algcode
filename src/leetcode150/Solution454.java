package leetcode150;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:14 2024/9/18
 */
public class Solution454 {
    public static void main(String[] args) {
        Solution454 solution454 = new Solution454();
        System.out.println(solution454.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int target=nums1[i]+nums2[j];
                hashMap.put(target,hashMap.getOrDefault(target,0)+1);
            }
        }
        int result=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j< nums4.length;j++){
                int target=nums3[i]+nums4[j];
                result+=hashMap.getOrDefault(target,0);
            }
        }
        return result;
    }
}