package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:02 2024/5/5
 */
public class Solution131 {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("a"));
    }
    List<List<String>> result=new ArrayList<>();
    List<String> subResult=new ArrayList<>();
    public List<List<String>> partition(String s){
        dfs(s,0);
        return result;
    }
    public void dfs(String s,int startIndex){
        if(startIndex==s.length()){
            result.add(new ArrayList<>(subResult));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isParalima(s,startIndex,i)){
                subResult.add(s.substring(startIndex,i+1));
                dfs(s,i+1);
                subResult.remove(subResult.size()-1);
            }
        }
    }
    public boolean isParalima(String s,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
}
