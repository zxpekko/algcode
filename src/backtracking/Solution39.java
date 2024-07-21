package backtracking;

import javax.xml.ws.soap.AddressingFeature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:44 2024/4/22
 */
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.combinationSum(new int[]{2, 3, 6, 7}, 7));
        Solution39Ⅰ solution39Ⅰ = new Solution39Ⅰ();
        System.out.println(solution39Ⅰ.combinationSum(new int[]{2, 3, 6, 7}, 7));
        Solution39Ⅱ solution39Ⅱ = new Solution39Ⅱ();
        System.out.println(solution39Ⅱ.combinationSum(new int[]{2, 3, 6, 7}, 7));

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] ints = new int[count];
        for(int i=0;i<count;i++)
            ints[i]=scanner.nextInt();
        int target=scanner.nextInt();
        System.out.println(solution39Ⅱ.combinationSum(ints, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        dfs(candidates,target,0,result,subResult);
        return result;
    }
    public void dfs(int[] candidates,int target,int start,List<List<Integer>> result,List<Integer> subResult){
        if(target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            subResult.add(candidates[i]);
            dfs(candidates,target-candidates[i],i,result,subResult);
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
            subResult.add(candidates[i]);
            target-=candidates[i];
            dfs(candidates,target,i);
            subResult.remove(subResult.size()-1);
            target+=candidates[i];
        }
    }
}
class Solution39Ⅱ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        result.clear();
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
            subResult.add(candidates[i]);
            target-=candidates[i];
            dfs(candidates,i,target);
            subResult.remove(subResult.size()-1);
            target+=candidates[i];
        }
    }
}