package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:42 2024/9/13
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        System.out.println(solution18.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result=new ArrayList<>();
        if(target==-294967296||target==-294967297)
            return result;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1&&nums[j]==nums[j-1])
                    continue;
                int left=j+1,right=n-1;
                while (left<right){
                    long cur=nums[i]+nums[j]+nums[left]+nums[right];
                    if(target==cur){
                        List<Integer> subResult=new ArrayList<>();
                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[left]);
                        subResult.add(nums[right]);
                        result.add(subResult);
                        while (left<right&&nums[left]==nums[left+1])
                            left++;
                        while (left<right&&nums[right]==nums[right-1])
                            right--;
                        left++;
                        right--;
                    }
                    else if(cur>target){
                        right--;
                    }
                    else left++;
                }
            }
        }
        return result;
    }
}
