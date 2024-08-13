package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:02 2024/8/10
 */
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2));
    }
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
