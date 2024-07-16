package binarytree;

import org.junit.experimental.theories.internal.SpecificDataPointsSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:04 2024/4/4
 */
public class InOrder {
//    public void inOrder(TreeNode root){这个中序遍历迭代法不正确。
//        Stack<TreeNode> stack = new Stack<>();
//        if(root==null)
//            return;
//        stack.push(root);
//        List<Integer> result=new ArrayList<>();
//        TreeNode cur=root;
//        while (cur!=null||!stack.isEmpty()){
//            if(cur!=null){
//                cur=cur.left;
//            }
//            else {
//                cur = stack.pop();
//                result.add(cur.val);
//                cur=cur.right;
//            }
//        }
//    }
}
class Inorder1{
    public void inorder(TreeNode root){
        if(root==null)
            return;
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                cur=pop.right;
            }
        }
    }
}
class InorderⅠ{
    public List<Integer> inorder(TreeNode root){
        if(root==null)
            return null;
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                cur=pop.right;
            }
        }
        return result;
    }
}
class InorderⅡ{
    public void inorder(TreeNode root,List<TreeNode> result){
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop);
                cur=pop.right;
            }
        }
    }
}
class InorderⅢ{
    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> inorder(TreeNode root){
        if(root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop);
                cur=pop.right;
            }
        }
        return result;
    }
}