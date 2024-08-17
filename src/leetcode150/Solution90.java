package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:29 2024/8/16
 */
public class Solution90 {
    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[]{1, 2, 2}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,used);
        return result;
    }
    public void dfs(int[] nums,int start,boolean[] used){
        result.add(new ArrayList<>(subResult));
        for(int i=start;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1])
                continue;
            subResult.add(nums[i]);
            used[i]=true;
            dfs(nums,i+1,used);
            subResult.remove(subResult.size()-1);
            used[i]=false;
        }
    }
}