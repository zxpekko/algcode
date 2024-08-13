package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:0:23 2024/8/4
 */
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.combinationSum(new int[]{2, 3, 5}, 8));
        Solution39Ⅰ solution39Ⅰ = new Solution39Ⅰ();
        System.out.println(solution39Ⅰ.combinationSum(new int[]{2, 3, 5}, 8));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        dfs(candidates,0,target);
        return result;
    }
    public void dfs(int[] candidates,int start,int target){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            target-=candidates[i];
            subResult.add(candidates[i]);
            dfs(candidates,i,target);
            target+=candidates[i];
            subResult.remove(subResult.size()-1);
        }
    }
}
class Solution39Ⅰ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        dfs(candidates,target,0);
        return result;
    }
    public void dfs(int[] candidates,int target,int start){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            target-=candidates[i];
            subResult.add(candidates[i]);
            dfs(candidates,target,i);
            target+=candidates[i];
            subResult.remove(subResult.size()-1);
        }
    }
}