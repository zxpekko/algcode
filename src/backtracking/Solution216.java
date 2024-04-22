package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:35 2024/4/21
 */
public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        System.out.println(solution216.combinationSum3(3, 100));
    }
    public List<List<Integer>> combinationSum3(int k, int n){
        int max=0,min=0;
        for(int i=1;i<=k;i++){
            min+=i;
            max+=(9-i+1);
        }
        if(n<min||n>max)
            return new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        dfs(n,k,1,result,subResult);
        return result;
    }
    public void dfs(int n,int k,int start,List<List<Integer>> result,List<Integer> subResult){
        if(subResult.size()==k&&n==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(subResult.size()==k)
            return;
        if(n<0||start>n)
            return;
        for(int i=start;i<=9;i++){
            subResult.add(i);
            dfs(n-i,k,i+1,result,subResult);
            subResult.remove(subResult.size()-1);
        }
    }
}
