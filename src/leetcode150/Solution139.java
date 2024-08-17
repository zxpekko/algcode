package leetcode150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:38 2024/8/13
 */
public class Solution139 {
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution139.wordBreak1("leetcode", wordDict));
        Solution139Ⅰ solution139Ⅰ = new Solution139Ⅰ();
        System.out.println(solution139Ⅰ.wordBreak("leetcode", wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict){
        int m=s.length();
        HashSet<String> hashSet=new HashSet<>(wordDict);
        boolean[] valid=new boolean[m+1];
        valid[0]=true;
        for(int i=1;i<=m;i++){
            for(int j=0;j<i;j++){
                if(hashSet.contains(s.substring(j,i))&&valid[j]){
                    valid[i]=true;
                    break;
                }
            }
        }
        return valid[m];
    }
    boolean wordBreak=false;
    public boolean wordBreak1(String s, List<String> wordDict){
        HashSet<String> hashSet=new HashSet<>(wordDict);
        dfs(s,0,hashSet);
        return wordBreak;
    }
    public void dfs(String s,int start,HashSet<String> hashSet){
        if(start>=s.length()){
            wordBreak=true;
            return;
        }
        for(int i=start;i<s.length();i++){
            String substring = s.substring(start, i + 1);
            if(hashSet.contains(substring)){
                dfs(s,i+1,hashSet);
            }
        }
    }
}
class Solution139Ⅰ{
    public boolean wordBreak(String s, List<String> wordDict){
        int m=s.length();
        HashSet<String> hashSet=new HashSet<>(wordDict);
        boolean[] valid = new boolean[m + 1];
        valid[0]=true;
        for(int i=1;i<=m;i++){
            for(int j=0;j<i;j++){
                if(hashSet.contains(s.substring(j,i))&&valid[j]){
                    valid[i]=true;
                    break;
                }
            }
        }
        return valid[m];
    }
}