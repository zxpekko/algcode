package stacksandqueues;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:35 2024/4/16
 */
public class Solution1047 {
    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();
        System.out.println(solution1047.removeDuplicates("abbaca"));
    }
    public String removeDuplicates(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()&&stack.peek()==s.charAt(i)){
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        Stack<Character> helpStack = new Stack<>();
        while (!stack.isEmpty()){
            helpStack.push(stack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!helpStack.isEmpty()){
            stringBuilder.append(helpStack.pop());
        }
        return stringBuilder.toString();
    }
}
