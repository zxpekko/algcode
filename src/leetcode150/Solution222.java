package leetcode150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:06 2024/8/6
 */
public class Solution222 {
    public int countNodes(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        int count=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            count++;
            if(poll.left!=null)
                queue.offer(poll.left);
            if(poll.right!=null)
                queue.offer(poll.right);
        }
        return count;
    }
}
class Solution222Ⅰ{
    public int countNodes(TreeNode root){
        if(root==null)
            return 0;
        if(root.left!=null&&root.right!=null)
            return 1;
        int left=countNodes(root.left);
        int right=countNodes(root.right);
        return left+right+1;
    }
}