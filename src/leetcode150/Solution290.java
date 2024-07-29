package leetcode150;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:35 2024/7/29
 */
public class Solution290 {
    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        System.out.println(solution290.wordPattern("abba", "dog dog dog dog"));
    }
    public boolean wordPattern(String pattern, String s){
        HashMap<Character,String> hashMap=new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                count++;
        }
        count++;
        if(count!=pattern.length())
            return false;
        String[] s1 = s.split(" ");
        for(int i=0;i<pattern.length();i++){
            if(!hashMap.containsKey(pattern.charAt(i))){
                hashMap.put(pattern.charAt(i),s1[i]);
            }
            else {
                String s2 = hashMap.get(pattern.charAt(i));
                if(!s2.equals(s1[i]))
                    return false;
            }
        }
        HashMap<String,Character> record=new HashMap<>();
        for(int i=0;i<s1.length;i++){
            if(!record.containsKey(s1[i])){
                record.put(s1[i],pattern.charAt(i));
            }
            else {
                Character character = record.get(s1[i]);
                if(character!=pattern.charAt(i))
                    return false;
            }
        }
        return true;
    }
}