package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:09 2024/4/21
 */
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2));
        Solution77Ⅰ solution77Ⅰ = new Solution77Ⅰ();
        System.out.println(solution77Ⅰ.combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subResult=new ArrayList<>();
        dfs(n,k,1,result,subResult);
        return result;
    }
    public void dfs(int n,int k,int start,List<List<Integer>> result,List<Integer> subResult){
        if(subResult.size()>=k){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(k- subResult.size()>n-start+1)//剪枝操作。
            return;
        for(int i=start;i<=n;i++){
            subResult.add(i);
            dfs(n,k,i+1,result,subResult);
            subResult.remove(subResult.size()-1);
        }
    }
}
class Solution77Ⅰ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        dfs(n,k,1);
        return result;
    }
    public void dfs(int n,int k,int start){
        if(subResult.size()==k){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=start;i<=n;i++){
            subResult.add(i);
            dfs(n,k,i+1);
            subResult.remove(subResult.size()-1);
        }
    }
}