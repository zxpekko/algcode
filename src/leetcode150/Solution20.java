package leetcode150;

import binarytree.Solution;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:19 2024/7/31
 */
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("]"));
    }
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else if(s.charAt(i)==']'){
                if(!stack.isEmpty()&&stack.peek()=='[')
                    stack.pop();
                else return false;
            }
            else if(s.charAt(i)=='}'){
                if(!stack.isEmpty()&&stack.peek()=='{')
                    stack.pop();
                else return false;
            }
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
