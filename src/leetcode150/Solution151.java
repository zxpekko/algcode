package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:08 2024/7/21
 */
public class Solution151 {
    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords("  hello world  "));
    }
    public String reverseWords(String s){
        List<StringBuilder> store=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }
            else if(sb.length()>0){
                    store.add(new StringBuilder(sb));
                    sb.setLength(0);
                }
        }
        if(s.charAt(s.length()-1)!=' ')
            store.add(new StringBuilder(sb));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=store.size()-1;i>=0;i--){
            stringBuilder.append(store.get(i));
            if(i!=0)
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
