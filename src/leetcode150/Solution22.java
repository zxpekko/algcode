package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:43 2024/8/11
 */
public class Solution22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
        Solution22Ⅰ solution22Ⅰ = new Solution22Ⅰ();
        System.out.println(solution22Ⅰ.generateParenthesis(3));
    }
    List<String> result=new ArrayList<>();
    StringBuilder stringBuilder=new StringBuilder();
    public List<String> generateParenthesis(int n){
        dfs(0,0,n);
        return result;
    }
    public void dfs(int left,int right,int n){
        if(stringBuilder.length()==n*2){
            result.add(stringBuilder.toString());
            return;
        }
        if(left<n){
            stringBuilder.append('(');
            left+=1;
            dfs(left,right,n);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            left-=1;
        }
        if(right<left){
            stringBuilder.append(')');
            right+=1;
            dfs(left,right,n);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            right-=1;
        }
    }
}
class Solution22Ⅰ{
    List<String> result=new ArrayList<>();
    StringBuilder stringBuilder=new StringBuilder();
    public List<String> generateParenthesis(int n){
        dfs(0,0,n);
        return result;
    }
    public void dfs(int left,int right,int n){
        if(stringBuilder.length()==n*2){
            result.add(stringBuilder.toString());
            return;
        }
        if(left<n){
            left++;
            stringBuilder.append('(');
            dfs(left,right,n);
            left--;
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
        if(right<left){
            right++;
            stringBuilder.append(')');
            dfs(left,right,n);
            right--;
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
    }
}