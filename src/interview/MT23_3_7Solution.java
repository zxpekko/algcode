package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:01 2024/8/27
 */
public class MT23_3_7Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.charAt(0)=='.'||s.charAt(s.length()-1)=='.'){
            System.out.println("invalid");
            return;
        }
        String[] split = s.split("\\.");
        for(int i=0;i<split.length;i++){
            if(!judge(split[i])){
                System.out.println("invalid");
                return;
            }
        }
        if(split.length!=4){
            System.out.println("invalid");
            return;
        }

    }
    public static boolean judge(String s){
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }
}