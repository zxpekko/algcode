package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:10 2024/8/11
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(new int[]{1, 2, 3}));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        boolean[] used = new boolean[nums.length];
        dfs(nums,used);
        return result;
    }
    public void dfs(int[] nums,boolean[] used){
        if(subResult.size()==nums.length){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                subResult.add(nums[i]);
                used[i]=true;
                dfs(nums,used);
                subResult.remove(subResult.size()-1);
                used[i]=false;
            }
        }
    }
}