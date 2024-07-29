package leetcode150;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:54 2024/7/29
 */
public class Solution242 {
    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram("anagram", "nagaram"));
    }
    public boolean isAnagram(String s, String t){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            if(!hashMap.containsKey(t.charAt(i)))
                return false;
            else {
                Integer value = hashMap.get(t.charAt(i));
                value--;
                if(value==0)
                    hashMap.remove(t.charAt(i));
                else
                    hashMap.put(t.charAt(i),value);
            }
        }
        if(hashMap.size()==0)
            return true;
        return false;
    }
}