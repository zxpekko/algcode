package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:11 2024/4/22
 */
public class Solution40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        boolean[] record = new boolean[candidates.length];
        dfs(candidates,target,0,result,subResult,record);
        return result;
    }
    public void dfs(int[] candidates,int target,int start,List<List<Integer>> result,List<Integer> subResult,boolean[] record){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&!record[i-1])
                continue;//去重关键点
            subResult.add(candidates[i]);
            record[i]=true;
            dfs(candidates,target-candidates[i],i+1,result,subResult,record);
            subResult.remove(subResult.size()-1);
            record[i]=false;
        }
    }
}