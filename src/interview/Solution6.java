package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:39 2024/8/21
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(modify(s));
    }
    public static int modify(String s){
        int n=s.length();
        int length=n/2;
        int count=0;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(i+length))
                count++;
        }
        return count;
    }
}
