package interview;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:43 2024/8/21
 */
public class Solution7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s="";
        s = scanner.next();
        scanner.close();
        System.out.println(get(s));
    }
    public static int get(String s){
        Stack<Character> stack = new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else {
                if(!stack.isEmpty()){
                    stack.pop();
                    count+=2;
                }
                else break;
            }
        }
        return count;
    }
}
