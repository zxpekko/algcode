package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:50 2024/8/3
 */
public class Solution131 {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("aaaba"));
        Solution131Ⅰ solution131Ⅰ = new Solution131Ⅰ();
        System.out.println(solution131Ⅰ.partition("aaaba"));
    }
    List<List<String>> result=new ArrayList<>();
    List<String> subResult=new ArrayList<>();
    public List<List<String>> partition(String s){
        dfs(s,0);
        return result;
    }
    public void dfs(String s,int start){
           if(start==s.length()){
               result.add(new ArrayList<>(subResult));
               return;
           }
           for(int i=start;i<s.length();i++){
               if(isPali(s,start,i)){
                   subResult.add(s.substring(start,i+1));
                   dfs(s,i+1);
                   subResult.remove(subResult.size()-1);
               }
           }
    }
    public boolean isPali(String s,int left,int right){
        while (left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
class Solution131Ⅰ{
    List<List<String>> result=new ArrayList<>();
    List<String> subResult=new ArrayList<>();
    public List<List<String>> partition(String s){
        dfs(s,0);
        return result;
    }
    public void dfs(String s,int start){
        if(start==s.length()){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalid(s,start,i)){
                subResult.add(s.substring(start,i+1));
                dfs(s,i+1);
                subResult.remove(subResult.size()-1);
            }
        }
    }
    public boolean isPalid(String s,int start,int end){
        int left=start,right=end;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}