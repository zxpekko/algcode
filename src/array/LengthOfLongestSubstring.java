package array;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:44 2024/3/31
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringⅡ("bbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstringⅢ("abcda"));
        LengthOfLongestSubstringⅡ lengthOfLongestSubstringⅡ = new LengthOfLongestSubstringⅡ();
        System.out.println(lengthOfLongestSubstringⅡ.lengthOfLongestSubstring("abcda"));
        LengthOfLongestSubstring1 lengthOfLongestSubstring1 = new LengthOfLongestSubstring1();
        System.out.println(lengthOfLongestSubstring1.lengthOfLongestSubstring("aaaa"));
        LengthOfLongestSubstring2 lengthOfLongestSubstring2 = new LengthOfLongestSubstring2();
        System.out.println(lengthOfLongestSubstring2.lengthOfLongestSubstring("abcda"));
        LengthOfLongestSubstring3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring3();
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring("abcda"));
        LengthOfLongestSubstring4 lengthOfLongestSubstring4 = new LengthOfLongestSubstring4();
        System.out.println(lengthOfLongestSubstring4.lengthOfLongestSubstring("abcda"));
    }
    public int lengthOfLongestSubstring(String s){
        int right=-1;
        HashSet<Character> record = new HashSet<>();
        List<Character> list=new ArrayList<>();
        int result=0;
        List<Character> maxList=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(i!=0){
                record.remove(s.charAt(i-1));
                list.remove(0);
            }
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                list.add(s.charAt(right+1));
                right++;
            }
            result= Math.max(result,right-i+1);
            if(result==right-i+1)
                maxList=new ArrayList<>(list);
        }
        System.out.println(maxList);
        return result;
    }
    public int lengthOfLongestSubstringⅡ(String s){
        int right=-1;
        int result=0;
        HashSet<Character> record = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(i!=0){
                record.remove(s.charAt(i-1));
            }
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(result,right-i+1);
        }
        return result;
    }
    public int lengthOfLongestSubstringⅢ(String s){
        int right=-1;
        int result=0;
        ArrayList<Character> maxList = new ArrayList<>();
        ArrayList<Character> curList = new ArrayList<>();
        HashSet<Character> record = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(i!=0){
                record.remove(s.charAt(i-1));
                curList.remove(0);
            }

            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                curList.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(result,right-i+1);
            if(result==right-i+1)
                maxList=new ArrayList<>(curList);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c:maxList)
            stringBuilder.append(c);
        System.out.println(stringBuilder.toString());
        return result;
    }
}
class LengthOfLongestSubstringⅡ{
    public int lengthOfLongestSubstring(String s){
        int right=-1;
        int result=0;
        HashSet<Character> record = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(result,right-i+1);
        }
        return result;
    }
}
class LengthOfLongestSubstring1{
    public int lengthOfLongestSubstring(String s){
        int right=-1,result=0;
        int l=0,r=0;
        HashSet<Character> record=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            if(result<right-i+1){
                result=right-i+1;
                l=i;
                r=right;
            }
//            result=Math.max(result,right-i+1);
        }
        String substring = s.substring(l, r + 1);
        System.out.println(substring);
        return result;
    }
}
class LengthOfLongestSubstring2{
    public int lengthOfLongestSubstring(String s){
        int right=-1,result=0;
        int l=0,r=0;
        HashSet<Character> record=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            if(result<right-i+1){
                result=right-i+1;
                l=i;
                r=right;
            }
        }
        String substring = s.substring(l, r + 1);
        System.out.println(substring);
        return result;
    }
}
class LengthOfLongestSubstring3{
    public int lengthOfLongestSubstring(String s){
        int n=s.length();
        int right=-1;
        int result=0;
        HashSet<Character> record=new HashSet<>();
        for(int i=0;i<n;i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<n&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(result,right-i+1);
        }
        return result;
    }
}
class LengthOfLongestSubstring4{
    public int lengthOfLongestSubstring(String s){
        int result=0;
        int right=-1;
        HashSet<Character> record=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<s.length()&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(result,right-i+1);
        }
        return result;
    }
}