package leetcode150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:28 2024/8/4
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root){
        if(root==null)
            return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode temp=poll.left;
            poll.left=poll.right;
            poll.right=temp;
            if(poll.left!=null)
                queue.offer(poll.left);
            if(poll.right!=null)
                queue.offer(poll.right);
        }
        return root;
    }
}
class Solution226Ⅰ{
    public TreeNode invertTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}