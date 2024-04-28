package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:22 2024/4/25
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        System.out.println(solution18.fourSum(new int[]{2,2,2,2,2}, 8));
    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;
        int i=0;
        while (i<n){
            if(nums[i]>0&&nums[i]>target)
                return result;
            while (i>0&&i<n&&nums[i]==nums[i-1])
                i++;
            if(i>=n)
                break;
            int j=i+1;
            while (j<n){
                while (j>i+1&&j<n&&nums[j]==nums[j-1])
                    j++;
                if(j>=n)
                    break;
                int k=j+1,l=n-1;
                while (k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                        List<Integer> subResult=new ArrayList<>();
                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[k]);
                        subResult.add(nums[l]);
                        result.add(new ArrayList<>(subResult));
                        while (k<l&&nums[k]==nums[k+1])
                            k++;
                        while (k<l&&nums[l]==nums[l-1])
                            l--;
                        k++;
                        l--;
                    }
                    else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }
                    else
                        k++;
                }
                j++;
            }
            i++;
        }
        return result;
    }
}