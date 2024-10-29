package leetcode150;

import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:0:31 2024/8/4
 */
public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        System.out.println(solution216.combinationSum3(3, 24));
        Solution216Ⅰ solution216Ⅰ = new Solution216Ⅰ();
        System.out.println(solution216Ⅰ.combinationSum3(3, 24));
        Solution216Ⅱ solution216Ⅱ = new Solution216Ⅱ();
        System.out.println(solution216Ⅱ.combinationSum3(3, 25));
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n){
        int max=0,min=0;
        for(int i=1;i<=k;i++){
            min+=i;
            max+=(10-i);
        }
        if(n<min||n>max)
            return result;
        dfs(k,n,1);
        return result;
    }
    public void dfs(int k,int n,int start){
        if(subResult.size()==k&&n==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        else if(subResult.size()==k)
            return;
        for(int i=start;i<=9;i++){
            n-=i;
            subResult.add(i);
            dfs(k,n,i+1);
            n+=i;
            subResult.remove(subResult.size()-1);
        }
    }
}
class Solution216Ⅰ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n){
        int max=0,min=0;
        for(int i=0;i<k;i++){
            max+=(9-i);
            min+=(i+1);
        }
        if(n<min||n>max)
            return result;
        dfs(k,n,1);
        return result;
    }
    public void dfs(int k,int n,int start){
        if(n==0&&subResult.size()==k){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(n!=0&&subResult.size()>=k)
            return;
        for(int i=start;i<=9;i++){
            n-=i;
            subResult.add(i);
            dfs(k,n,i+1);
            n+=i;
            subResult.remove(subResult.size()-1);
        }
    }
}
class Solution216Ⅱ{
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> subResult=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n){
        int min=0,max=0;
        for(int i=0;i<k;i++){
            min+=(1+i);
            max+=(9-i);
        }
        if(n<min||n>max)
            return result;
        dfs(k,n,1);
        return result;
    }
    public void dfs(int k,int target,int start){
        if(subResult.size()==k&&target==0){
            result.add(new ArrayList<>(subResult));
            return;
        }
        if(subResult.size()==k)
            return;
        for(int i=start;i<=9;i++){
            subResult.add(i);
            target-=i;
            dfs(k,target,i+1);
            subResult.remove(subResult.size()-1);
            target+=i;
        }
    }
}