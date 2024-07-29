package leetcode150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:23 2024/7/28
 */
public class Solution205 {
    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic("egg", "add"));
    }
    public boolean isIsomorphic(String s, String t){
        if(s.length()!=t.length())
            return false;
        return judge(s,t)&&judge(t,s);
    }
    public boolean judge(String left,String right){
        HashMap<Character, Character> record = new HashMap<>();
        int n=left.length();
        for(int i=0;i<n;i++){
            if(!record.containsKey(left.charAt(i)))
                record.put(left.charAt(i),right.charAt(i));
            else {
                Character value = record.get(left.charAt(i));
                if(value!=right.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
