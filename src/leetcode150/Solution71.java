package leetcode150;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:56 2024/7/31
 */
public class Solution71 {
    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath("/home//foo/"));
    }
    public String simplifyPath(String path){
        String[] split = path.split("/");
        Deque<String> stack=new LinkedList<>();
        for(String str:split){
            if("..".equals(str)){
                if(!stack.isEmpty())
                    stack.pollLast();
            }
            else if(str.length()>0&&!".".equals(str))
                stack.offerLast(str);
        }
        StringBuilder sb=new StringBuilder();
        if(stack.isEmpty())
            sb.append("/");
        else {
            while (!stack.isEmpty()){
                sb.append("/");
                sb.append(stack.pollFirst());
            }
        }
        return sb.toString();
    }
}
