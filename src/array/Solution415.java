package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:16 2024/5/13
 */
public class Solution415 {
    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        System.out.println(solution415.addStrings("1", "9"));
    }
    public String addStrings(String num1, String num2){//使用stringbuilder其实不用将数字转成string，直接加入list集合就行。
        List<String> record=new ArrayList<>();
        int index1=num1.length()-1,index2=num2.length()-1;
        int n1=num1.length(),n2=num2.length();
        int last=0;
        while (index1>=0&&index2>=0){
            int left=num1.charAt(index1)-'0';
            int right=num2.charAt(index2)-'0';
            int sum=left+right+last;
            if(sum>=10){
                last=1;
            }
            else {
                last=0;
            }
            String value=String.valueOf(sum%10);
            record.add(value);
            index1--;
            index2--;
        }
        while (index1>=0){
            int left=num1.charAt(index1)-'0'+last;
            if(left>=10){
                last=1;
            }
            else last=0;
            record.add(String.valueOf(left%10));
            index1--;
        }
        while (index2>=0){
            int left=num2.charAt(index2)-'0'+last;
            if(left>=10){
                last=1;
            }
            else last=0;
            record.add(String.valueOf(left%10));
            index2--;
        }
        if(last==1)
            record.add(String.valueOf(last));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=record.size()-1;i>=0;i--){
            stringBuilder.append(record.get(i));
        }
        return stringBuilder.toString();
    }
    @Test
    public void test(){
        List<Character> list=new ArrayList<>();
        String a="123";
        Integer i=a.charAt(0)-'0';
//        list.add((Character)i)
        System.out.println(i instanceof Integer);
    }
}
