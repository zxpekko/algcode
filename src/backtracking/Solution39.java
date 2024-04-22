package backtracking;

import javax.xml.ws.soap.AddressingFeature;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:44 2024/4/22
 */
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.combinationSum(new int[]{2, 3, 6, 7}, 7));
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
