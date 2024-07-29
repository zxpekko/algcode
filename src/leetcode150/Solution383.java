package leetcode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:09 2024/7/28
 */
public class Solution383 {
    public static void main(String[] args) {
        Solution383 solution383 = new Solution383();
        System.out.println(solution383.canConstruct("aa", "ab"));
    }
    public boolean canConstruct(String ransomNote, String magazine){
        HashMap<Character, Integer> record = new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            record.put(ransomNote.charAt(i),record.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for(int i=0;i<magazine.length();i++){
            if(record.containsKey(magazine.charAt(i))){
                Integer value = record.get(magazine.charAt(i));
                record.put(magazine.charAt(i),value-1);
            }
        }
        for(Map.Entry<Character,Integer> entry:record.entrySet()){
            if(entry.getValue()>0)
                return false;
        }
        return true;
    }
}
