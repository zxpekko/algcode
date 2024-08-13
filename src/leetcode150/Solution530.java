package leetcode150;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:55 2024/8/7
 */
public class Solution530 {
    List<Integer> inorder=new ArrayList<>();
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        inorder(root);
//        int min= Integer.MAX_VALUE;
//        for(int i=0;i<inorder.size()-1;i++){
//            min=Math.min(min,inorder.get(i+1)-inorder.get(i));
//        }
        return min;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        inorder.add(root.val);
        if(inorder.size()>=2){
            min=Math.min(min,inorder.get(inorder.size()-1)-inorder.get(inorder.size()-2));
        }
        inorder(root.right);
    }
}
class Solution530Ⅰ{

    public int getMinimumDifference(TreeNode root){
        List<Integer> result=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if(result.size()>=2)
                    min=Math.min(min,result.get(result.size()-1)-result.get(result.size()-2));
                cur=pop.right;
            }
        }
        return min;
    }
}