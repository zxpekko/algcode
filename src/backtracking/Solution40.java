package backtracking;

import leetcode.LargestRectangleArea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        Solution40Ⅰ solution40Ⅰ = new Solution40Ⅰ();
        System.out.println(solution40Ⅰ.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        SolutionⅡ solutionⅡ = new SolutionⅡ();
        System.out.println(solutionⅡ.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
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
class Solution40Ⅰ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        boolean[] record = new boolean[candidates.length];
        dfs(candidates,target,0,record);
        return result;
    }
    public void dfs(int[] candidates,int target,int start,boolean[] record){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            if(i!=start&&candidates[i]==candidates[i-1]&&!record[i-1])
                continue;
            subResult.add(candidates[i]);
            record[i]=true;
            target-=candidates[i];
            dfs(candidates,target,i+1,record);
            subResult.remove(subResult.size()-1);
            record[i]=false;
            target+=candidates[i];
        }
    }
}
class SolutionⅡ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        int n=candidates.length;
        boolean[] visited= new boolean[n];
        dfs(candidates,0,target,visited);
        return result;
    }
    public void dfs(int[] candidates,int start,int target,boolean[] visited){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i!=start&&candidates[i]==candidates[i-1]&&!visited[i-1])
                continue;
            subResult.add(candidates[i]);
            target-=candidates[i];
            visited[i]=true;
            dfs(candidates,i+1,target,visited);
            subResult.remove(subResult.size()-1);
            target+=candidates[i];
            visited[i]=false;
        }
    }
}