package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:11 2024/7/22
 */
public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        Solution15Ⅰ solution15Ⅰ = new Solution15Ⅰ();
        System.out.println(solution15Ⅰ.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public List<List<Integer>> threeSum(int[] nums){
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            int left=i+1,right=n-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> subResult=new ArrayList<>();
                    subResult.add(nums[i]);
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
                else if(sum>0)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }
}
class Solution15Ⅰ{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            else {
                int left=i+1,right=n-1;
                while (left<right){
                    int target=nums[i]+nums[left]+nums[right];
                    if(target==0){
                        List<Integer> subResult=new ArrayList<>();
                        subResult.add(nums[i]);
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
                    else if(target<0)
                        left++;
                    else right--;
                }
            }
        }
        return result;
    }
}