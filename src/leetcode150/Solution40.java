package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:39 2024/8/3
 */
public class Solution40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates,target,0,visited);
        return result;
    }
    public void dfs(int[] candidates,int target,int start,boolean[] visited){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i!=start&&candidates[i]==candidates[i-1]&&!visited[i-1])
                continue;
            target-=candidates[i];
            visited[i]=true;
            subResult.add(candidates[i]);
            dfs(candidates,target,i+1,visited);
            target+=candidates[i];
            visited[i]=false;
            subResult.remove(subResult.size()-1);
        }
    }
}
