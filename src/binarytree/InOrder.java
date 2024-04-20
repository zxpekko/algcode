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
    public void inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return;
        stack.push(root);
        List<Integer> result=new ArrayList<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                cur=cur.left;
            }
            else {
                cur = stack.pop();
                result.add(cur.val);
                cur=cur.right;
            }
        }
    }
}
