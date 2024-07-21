package leetcode150;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:54 2024/7/20
 */
public class Solution13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.romanToInt("LVIII"));
    }
    public int romanToInt(String s){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        int n=s.length();
        int value=0;
        for(int i=0;i<n;i++){
            Integer val = hashMap.get(s.charAt(i));
            if(i<n-1&&val<hashMap.get(s.charAt(i+1)))
                value-=val;
            else value+=val;
        }
        return value;
    }
}
