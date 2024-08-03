package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:23 2024/7/30
 */
public class Solution228 {
    public static void main(String[] args) {
        Solution228 solution228 = new Solution228();
        System.out.println(solution228.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
    public List<String> summaryRanges(int[] nums){
        List<String> result=new ArrayList<>();
        int i=0;
        int n= nums.length;
        while (i<n){
            int low=i;
            i++;
            while (i<n&&nums[i]==nums[i-1]+1){
                i++;
            }
            int high=i-1;
            StringBuilder s=new StringBuilder(""+nums[low]);
            if(low<high){
                s.append("->");
                s.append(nums[high]);
            }
            result.add(s.toString());
        }
        return result;
    }
}
