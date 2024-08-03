package leetcode150;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.prefs.PreferencesFactory;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:24 2024/8/3
 */
public class Solution100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(10);
        TreeNode q = new TreeNode(10);
        TreeNode pl = new TreeNode(5);
        TreeNode pr = new TreeNode(15);
        TreeNode qr = new TreeNode(5);
        TreeNode ql = new TreeNode(15);
//        p.left=pl;
//        q.right=qr;
        p.left=pl;
        p.right=pr;
        q.left=qr;
        qr.right=ql;
        Solution100 solution100 = new Solution100();
        System.out.println(solution100.isSameTree(p, q));
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null||q==null)
            return p==null&&q==null;
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode poll1 = queue1.poll();
            TreeNode poll2 = queue2.poll();
            if(poll1.val!=poll2.val)
                return false;
            if(poll1.left!=null&&poll2.left!=null){
                queue1.offer(poll1.left);
                queue2.offer(poll2.left);
            }
            if(poll1.right!=null&&poll2.right!=null){
                queue1.offer(poll1.right);
                queue2.offer(poll2.right);
            }
            if((poll1.left!=null&&poll2.left==null)||(poll1.left==null&&poll2.left!=null))
                return false;
            if((poll1.right!=null&&poll2.right==null)||(poll1.right==null&&poll2.right!=null))
                return false;
        }
        return true;
    }
}