package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:20 2024/8/6
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("2"));
    }
    char[][] chars={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if(digits.length()==0)
            return result;
        StringBuilder stringBuilder = new StringBuilder();
        dfs(digits,0,stringBuilder);
        return result;
    }
    public void dfs(String digits,int index,StringBuilder stringBuilder){
        if(index==digits.length()){
            result.add(new String(stringBuilder));
            return;
        }
        int num = Integer.parseInt(digits.substring(index, index + 1));
        char[] aChar = chars[num-2];
        for(int i=0;i<aChar.length;i++){
            stringBuilder.append(aChar[i]);
            dfs(digits,index+1,stringBuilder);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        }
    }
}