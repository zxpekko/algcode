package stacksandqueues;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:53 2024/5/19
 */
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()[]{}"));
    }
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else {
                if(!stack.isEmpty()){
                    Character peek = stack.peek();
                    if((s.charAt(i)==')'&&peek=='(')||(s.charAt(i)==']'&&peek=='[')||(s.charAt(i)=='}'&&peek=='{')){
                        stack.pop();
                        continue;
                    }
                    else
                        return false;
                }
                else return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
