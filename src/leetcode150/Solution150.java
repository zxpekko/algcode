package leetcode150;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:19 2024/7/31
 */
public class Solution150 {
    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
        System.out.println(solution150.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public int evalRPN(String[] tokens){
        Stack<String> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!"+".equals(tokens[i])&&!"-".equals(tokens[i])&&!"*".equals(tokens[i])&&!"/".equals(tokens[i]))
                stack.push(tokens[i]);
            else {
                String right = stack.pop();
                String left = stack.pop();
                int rightNum=Integer.parseInt(right);
                int leftNum=Integer.parseInt(left);
                int result = getResult(leftNum, rightNum, tokens[i]);
                stack.push(""+result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public int getResult(int left,int right,String op){
        switch (op){
            case "+":
                return left+right;
            case "-":
                return left-right;
            case "*":
                return left*right;
            case "/":
                return left/right;
            default:
                return 0;
        }
    }
}
